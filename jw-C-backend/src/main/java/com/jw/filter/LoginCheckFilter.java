package com.jw.filter;



import com.alibaba.fastjson.JSON;
import com.jw.config.JwtConfig;
import com.jw.controller.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否登录
 */
@WebFilter(filterName = "loginCheckFilter" ,urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    // 路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获得uri
        String requestURI = request.getRequestURI();

        // 是否要处理
        boolean check = check(requestURI);
        if(check){
            // 放行
            filterChain.doFilter(request,response);
            return;
        }


        // 是否登录 -1
        if(request.getHeader("Authorization") != null ){
            if(jwtConfig.parseJwt(request.getHeader("Authorization")).get("username")!=null){
                // 放行
                filterChain.doFilter(request,response);
                return;
            }
        }


        // 没有登录 输出流 响应数据
        response.getWriter().write(JSON.toJSONString(Response.buildFailed("A0010", "NOT_LOGIN")));

        return ;
    }

    /**
     * 路径匹配
     * @param requestURI
     * @return
     */
    public boolean check(String requestURI) {
        String[] urls = new String[]{
                "/user/**",
                "/courses/xml",
                "/courses/others"
        };

        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }

        return false;
    }
}
