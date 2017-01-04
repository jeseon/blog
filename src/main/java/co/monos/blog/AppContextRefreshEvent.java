package co.monos.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import co.monos.blog.dao.UserRepository;
import co.monos.blog.domain.User;

@Component
public class AppContextRefreshEvent implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User test = new User();
        test.setEmail("test@test.com");
        test.setUsername("test");
        test.setPassword("1111");
        userRepository.save(test);
    }
}