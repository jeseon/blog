package co.monos.blog;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.monos.blog.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserService userService;
	
	@Autowired
    private HttpSession httpSession;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
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
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String username = authentication.getName();
                String password = (String) authentication.getCredentials();

                /// 이곳에서 DB에 저장된 사용자 정보(username, password)를 읽어들인후
                UserDetails userDetails = userService.loadUserByUsername(username);

                // 이곳에서 html page에서 사용자가 입력한 값과 비교를 하여, 인증처리를 진행한다.
                if (userDetails.getPassword().equals(password)) {
                    List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
                    grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
                    Authentication auth = new UsernamePasswordAuthenticationToken(username, password, AuthorityUtils.createAuthorityList("ROLE_USER"));
                    httpSession.setAttribute("user", username);
                    System.out.println(username + " logined");
                    return auth;
                }

                return null;
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return authentication.equals(UsernamePasswordAuthenticationToken.class);
            }
        });
    }
}