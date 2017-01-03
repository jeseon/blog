package co.monos.blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/user/login")
            .and()
                .logout()
                    .logoutUrl("/user/logout")
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/posts")
            .and()
                .authorizeRequests()
                    .antMatchers("/**/new*", "/**/edit*", "/**/delete*").authenticated()
                    .antMatchers("/**").permitAll();
    }
}