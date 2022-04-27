package com.glsiA.projet.security;

import com.glsiA.projet.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserService userService;

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .and()
                .withUser("vendeur").password(passwordEncoder().encode("vendeur"))
                .roles("VENDEUR");


        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers("/").hasAnyRole("ADMIN","USERS")
                .antMatchers("/dashboard").hasAnyRole("ADMIN","USERS")
                .antMatchers("/produit/create").hasRole("ADMIN")
                .antMatchers("/produit/save").hasRole("ADMIN")
                .antMatchers("/produit/afficher").hasAnyRole("ADMIN","USERS")
                .antMatchers("/categorie/create").hasRole("ADMIN")
                .antMatchers("/categorie/save").hasRole("ADMIN")
                .antMatchers("/categories/**").hasRole("ADMIN")
                .antMatchers("/Users/**").hasRole("ADMIN")
                .antMatchers("/approvisionnement/**").authenticated()
                .antMatchers("/customers/**").authenticated()
                .antMatchers("/sales/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/dashboard", true)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .clearAuthentication(true).invalidateHttpSession(true)
                .and()
                .rememberMe().tokenValiditySeconds(2592000).key("mySecret").userDetailsService(userService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userService);

        return daoAuthenticationProvider;
    }
}
