package app.conf;

import app.constant.AppConstants;
import app.interceptor.PathInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RequestConf extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PathInterceptor()).addPathPatterns("/**").excludePathPatterns(AppConstants.APP_CTX_PATH);
        super.addInterceptors(registry);
    }
}

