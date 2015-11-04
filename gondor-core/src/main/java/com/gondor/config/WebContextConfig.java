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

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.gondor.controller.AdminController;
import com.gondor.security.oauth.AccessConfirmationController;
import com.gondor.security.oauth.GondorUserApprovalHandler;


/**
 * @author Vipin Kumar
 * @created 15-Sep-2015
 * 
 * Configuring web Context
 * 
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan ( "com.gondor.controller")
@PropertySource ( { "classpath:config.properties" })
public class WebContextConfig extends WebMvcConfigurerAdapter
{


    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix( "/WEB-INF/views/" );
        resolver.setSuffix( ".jsp" );
        return resolver;
    }


    @Override
    public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer )
    {
        configurer.enable();
    }


    @Bean
    public WebContentInterceptor webContentInterceptor()
    {
        WebContentInterceptor interceptor = new WebContentInterceptor();
        interceptor.setCacheSeconds( 0 );
        interceptor.setUseExpiresHeader( true );
        interceptor.setUseCacheControlHeader( true );
        interceptor.setUseCacheControlNoStore( true );
        return interceptor;
    }


    @Bean
    public Docket api()
    {
        return new Docket( DocumentationType.SWAGGER_2 ).select().apis( RequestHandlerSelectors.any() )
            .paths( PathSelectors.any() ).build().pathMapping( "/" ).apiInfo( apiInfo() );
    }


    private ApiInfo apiInfo()
    {
        return new ApiInfo( "Gondor API", "API for Gondor Application", "1.0", null, null, "Copyright @ Gondor",
            "www.gondor.com" );
    }


    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry )
    {
        registry.addResourceHandler( "/libs/**" ).addResourceLocations( "/libs/" );
        registry.addResourceHandler( "/app/**" ).addResourceLocations( "/app/" );
        registry.addResourceHandler( "/assets/**" ).addResourceLocations( "/assets/" );
    }


    @Override
    public void addInterceptors( InterceptorRegistry registry )
    {
        registry.addInterceptor( webContentInterceptor() );
    }


    @Bean
    public AccessConfirmationController accessConfirmationController( ClientDetailsService clientDetailsService )
    {
        AccessConfirmationController accessConfirmationController = new AccessConfirmationController();
        accessConfirmationController.setClientDetailsService( clientDetailsService );
        return accessConfirmationController;
    }


    @Bean
    public AdminController adminController( TokenStore tokenStore,
        @Qualifier ( "consumerTokenServices") ConsumerTokenServices tokenServices, GondorUserApprovalHandler userApprovalHandler )
    {
        AdminController adminController = new AdminController();
        adminController.setTokenStore( tokenStore );
        adminController.setTokenServices( tokenServices );
        adminController.setUserApprovalHandler( userApprovalHandler );
        return adminController;
    }
}
