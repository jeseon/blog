package co.monos.blog;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class BlogConfig {
	@Bean
	public FilterRegistrationBean hiddenHttpMethodRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(new HiddenHttpMethodFilter());
	    registration.addUrlPatterns("/*");
	    return registration;
	}
}