package com.company.oa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.company.oa.configuration.CustomConfig;


@SpringBootApplication
@ServletComponentScan("com.company.camera")
@EnableConfigurationProperties({CustomConfig.class})

public class OaApplication extends SpringBootServletInitializer{

	/*public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new CatD(), "/oa/myservlet");// ServletName默认值为首字母小写，即myServlet
    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(OaApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OaApplication.class);
	}
}
