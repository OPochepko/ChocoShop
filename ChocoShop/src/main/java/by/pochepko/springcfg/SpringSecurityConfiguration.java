package by.pochepko.springcfg;

import by.pochepko.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    public SpringSecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final UserService userService;


    @Override
    protected void configure(AuthenticationManagerBuilder aut) throws Exception {
        aut.userDetailsService(userService);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/chocolates/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/chocolates/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/chocolates/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/chocolates").hasAuthority("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
