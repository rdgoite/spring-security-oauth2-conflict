package me.psychopunch.spring.demo.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SecurityConfiguration {

    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled=true)
    static class WebSecurity extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("user").password("password").authorities("ROLE_USER")
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest()
                    .permitAll()
                    .and()
                    .formLogin().defaultSuccessUrl("http://example.com")
                    .and()
                    .logout()
        }

    }

}
