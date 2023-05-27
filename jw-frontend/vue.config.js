module.exports = {
  configureWebpack: {
    devServer: {
      port: 8001,
      host:"localhost",
      proxy: {
        '/api': {
          target: 'http://localhost:10022',
          ws: true,
          changeOrigin: true,
          pathRewrite: {
            '^/api': '/'
          }
        }
      }
    }
  }
};
