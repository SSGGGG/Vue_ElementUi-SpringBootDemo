package com.cxytiandi.elementui.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cxytiandi.elementui.filter.HTTPBasicAuthorizeFilter;

@Configuration
public class FilterConfig {
	
	@Bean  
    public FilterRegistrationBean  filterRegistrationBean2() {  
        // 创建过滤器的注册器Bean
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // 设置自定义的Http过滤器
        HTTPBasicAuthorizeFilter httpBasicFilter = new HTTPBasicAuthorizeFilter();  
        registrationBean.setFilter(httpBasicFilter);
        // 设置url匹配路径
        List<String> urlPatterns = new ArrayList<String>(1);  
        urlPatterns.add("/*");  
        registrationBean.setUrlPatterns(urlPatterns);  
        return registrationBean;  
    }
	
}
