package com.gmail.dimaliahov.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan (
		basePackages = {
				"com.gmail.dimaliahov.controller",
				"com.gmail.dimaliahov.configuration"
		}
)
@PropertySource ("classpath:content.properties")
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Value ("${view.type}")
	private String contentType;

	@Value ("${view.name-prefix}")
	private String prefix;

	@Value ("${view.name-suffix}")
	private String suffix;

	@Value ("${resources.url}")
	private String resourcesUrl;

	@Value ("${resources.location}")
	private String resourcesLocation;

	@Bean
	public ViewResolver viewResolver () {
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setContentType(this.contentType);
		viewResolver.setPrefix(this.prefix);
		viewResolver.setSuffix(this.suffix);
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}

	@Override
	public void addResourceHandlers (final ResourceHandlerRegistry resource) {
		resource.addResourceHandler(this.resourcesUrl)
				.addResourceLocations(this.resourcesLocation);
	}

}
