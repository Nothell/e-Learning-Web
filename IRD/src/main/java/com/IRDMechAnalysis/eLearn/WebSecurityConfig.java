package com.IRDMechAnalysis.eLearn;
 
import org.springframework.context.annotation.Configuration;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests().antMatchers("/","/topics/").permitAll().and()
        .authorizeRequests().antMatchers("/console/**").permitAll();

http.csrf().disable();
http.headers().frameOptions().disable();
            //  .authorizeRequests();
            /*    .antMatchers("/register", "/login").permitAll()
                .antMatchers("/h2-console").hasRole("ADMIN")
                .anyRequest().authenticated() 
           ;
        http.csrf().disable();
        http.headers().frameOptions().disable();*/
    }
    
    
    public String Encrypt(String pass) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(pass);
	return hashedPassword;
    }
   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication();
    }*/
}
