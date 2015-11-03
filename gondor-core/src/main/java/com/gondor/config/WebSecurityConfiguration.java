/**
 *  * Copyright (c) 2015 Gondor. 
 * All rights reserved. 
 * 
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 *
 */
package com.gondor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * @author Vipin Kumar
 * @created 03-Nov-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( WebSecurityConfiguration.class );
    
    
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("KYLIN").roles("USER").and().withUser("analyst")
                .password("KYLIN").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
      web
        .ignoring()
           .antMatchers("/resources/**"); // #3
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .authorizeRequests()
          .antMatchers("/signup","/about").permitAll() // #4
          .antMatchers("/admin/**").hasRole("ADMIN") // #6
          .anyRequest().authenticated() // 7
          .and()
      .formLogin()  // #8
          .loginProcessingUrl("/login") // #9
          .permitAll(); // #5
    }
    
}
