package com.jw.service.impl;


import com.jw.entity.*;


import com.jw.service.CourseService;

import com.jw.util.XMLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    // TODO
    @Value("${mypath.aurl}")
    private String Aurl;

    @Value("${mypath.burl}")
    private String Burl;

    @Value("${mypath.curl}")
    private String Curl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CourseA> getAOthers() throws IOException {
        List<CourseA> ans = new ArrayList<>();

        try{
            String xmlC = restTemplate.getForObject(Curl, String.class);

            FileWriter fileWriter = new FileWriter(new File("src/main/resources/xml/c-source.xml"));
            fileWriter.write(xmlC);
            fileWriter.close();

            copyToXml("src/main/resources/xml/c-source.xml",
                    "src/main/resources/xml/c-format.xml",
                    "src/main/resources/xml/c2format.xsl");

            copyToXml("src/main/resources/xml/c-format.xml",
                    "src/main/resources/xml/c-a.xml",
                    "src/main/resources/xml/format2a.xsl");

            CourseAList courseAList = (CourseAList) XMLUtil.XML2Object(CourseAList.class,
                    "src/main/resources/xml/c-a.xml");

            for (CourseA course : courseAList.courses) {
                ans.add(course);
            }
        }catch (Exception e){
            System.err.println("C系统繁忙");
        }

        try{
            String xmlB = restTemplate.getForObject(Burl, String.class);

            FileWriter fileWriter = new FileWriter(new File("src/main/resources/xml/b-source.xml"));
            fileWriter.write(xmlB);
            fileWriter.close();


            copyToXml("src/main/resources/xml/b-source.xml",
                    "src/main/resources/xml/b-format.xml",
                    "src/main/resources/xml/b2format.xsl");

            copyToXml("src/main/resources/xml/b-format.xml",
                    "src/main/resources/xml/b-a.xml",
                    "src/main/resources/xml/format2a.xsl");

            CourseAList courseAList2 = (CourseAList) XMLUtil.XML2Object(CourseAList.class,
                    "src/main/resources/xml/b-a.xml");

            for (CourseA course : courseAList2.courses) {
                ans.add(course);
            }
        }catch (Exception e){
            System.err.println("B系统繁忙");
        }


        return ans;
    }

    @Override
    public List<CourseB> getBOthers() throws IOException {
        List<CourseB> ans = new ArrayList<>();

        try{
            String xmlC = restTemplate.getForObject(Curl, String.class);

            FileWriter fileWriter = new FileWriter(new File("src/main/resources/xml/c-source.xml"));
            fileWriter.write(xmlC);
            fileWriter.close();

            copyToXml("src/main/resources/xml/c-source.xml",
                    "src/main/resources/xml/c-format.xml",
                    "src/main/resources/xml/c2format.xsl");

            copyToXml("src/main/resources/xml/c-format.xml",
                    "src/main/resources/xml/c-b.xml",
                    "src/main/resources/xml/format2b.xsl");

            CourseBList courseBList = (CourseBList) XMLUtil.XML2Object(CourseBList.class,
                    "src/main/resources/xml/c-b.xml");

            for (CourseB course : courseBList.courses) {
                ans.add(course);
            }
        }catch (Exception e){
            System.err.println("C系统繁忙");
        }

        try{
            String xmlA = restTemplate.getForObject(Aurl, String.class);

            FileWriter fileWriter = new FileWriter(new File("src/main/resources/xml/a-source.xml"));
            fileWriter.write(xmlA);
            fileWriter.close();


            copyToXml("src/main/resources/xml/a-source.xml",
                    "src/main/resources/xml/a-format.xml",
                    "src/main/resources/xml/a2format.xsl");

            copyToXml("src/main/resources/xml/a-format.xml",
                    "src/main/resources/xml/a-b.xml",
                    "src/main/resources/xml/format2b.xsl");

            CourseBList courseBList2 = (CourseBList) XMLUtil.XML2Object(CourseBList.class,
                    "src/main/resources/xml/a-b.xml");

            for (CourseB course : courseBList2.courses) {
                ans.add(course);
            }
        }catch (Exception e){
            System.err.println("A系统繁忙");
        }

        return ans;
    }

    @Override
    public List<CourseC> getCOthers() throws IOException {
        List<CourseC> ans = new ArrayList<>();

        try{
            String xmlB = restTemplate.getForObject(Burl, String.class);

            FileWriter fileWriter = new FileWriter(new File("src/main/resources/xml/b-source.xml"));
            fileWriter.write(xmlB);
            fileWriter.close();

            copyToXml("src/main/resources/xml/b-source.xml",
                    "src/main/resources/xml/b-format.xml",
                    "src/main/resources/xml/b2format.xsl");

            copyToXml("src/main/resources/xml/b-format.xml",
                    "src/main/resources/xml/b-c.xml",
                    "src/main/resources/xml/format2c.xsl");

            CourseCList courseCList = (CourseCList) XMLUtil.XML2Object(CourseCList.class,
                    "src/main/resources/xml/b-c.xml");

            for (CourseC course : courseCList.courses) {
                ans.add(course);
            }
        }catch (Exception e){
            System.err.println("B系统繁忙");
        }

        try{
            String xmlA = restTemplate.getForObject(Aurl, String.class);

            FileWriter fileWriter = new FileWriter(new File("src/main/resources/xml/a-source.xml"));
            fileWriter.write(xmlA);
            fileWriter.close();


            copyToXml("src/main/resources/xml/a-source.xml",
                    "src/main/resources/xml/a-format.xml",
                    "src/main/resources/xml/a2format.xsl");

            copyToXml("src/main/resources/xml/a-format.xml",
                    "src/main/resources/xml/a-c.xml",
                    "src/main/resources/xml/format2c.xsl");

            CourseCList courseCList2 = (CourseCList) XMLUtil.XML2Object(CourseCList.class,
                    "src/main/resources/xml/a-c.xml");

            for (CourseC course : courseCList2.courses) {
                ans.add(course);
            }
        }catch (Exception e){
            System.err.println("A系统繁忙");
        }

        return ans;
    }

    private void copyToXml(String src, String dest, String xslt){
        File src2 = new File(src);
        File dest2 = new File(dest);
        File xslt2 = new File (xslt);

        Source srcSource = new StreamSource(src2);
        Result destResult = new StreamResult(dest2);
        Source xsltSource = new StreamSource(xslt2);

        try{
            TransformerFactory transFact = TransformerFactory.newInstance();
            Transformer trans = transFact.newTransformer(xsltSource);
            trans.transform(srcSource,destResult);
        }catch(TransformerConfigurationException e){
            e.printStackTrace();
        }catch(TransformerFactoryConfigurationError e){
            e.printStackTrace();
        }catch(TransformerException e){
            e.printStackTrace();
        }
    }
}
