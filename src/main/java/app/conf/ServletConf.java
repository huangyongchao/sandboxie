package app.conf;


import app.servlet.ApiServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServletConf {

    /**
     * 代码注册servlet(不需要@ServletComponentScan注解)
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new ApiServlet(), "/servlet/api/");   }



}

