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
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


/**
 * @author Vipin Kumar
 * @created 03-Nov-2015
 * 
 * OauthServer Configuration
 * 
 */
@Configuration
@EnableResourceServer
public class OAuth2ServerConfig
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( OAuth2ServerConfig.class );


    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter
    {


        @Autowired
        private TokenStore tokenStore;

        @Autowired
        private AuthenticationManager authenticationManager;
        
        @Bean
        public TokenStore tokenStore()
        {
            return new InMemoryTokenStore();
        }


        @Override
        public void configure( AuthorizationServerEndpointsConfigurer endpoints ) throws Exception
        {
            endpoints.tokenStore( tokenStore ).authenticationManager( authenticationManager );
        }


        @Override
        public void configure( ClientDetailsServiceConfigurer clients ) throws Exception
        {
            clients.inMemory().withClient( "acme" ).secret( "acmesecret" )
                .authorizedGrantTypes( "authorization_code", "refresh_token", "password" ).scopes( "openid" )
                .autoApprove( true );


        }


        /* (non-Javadoc)
         * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer)
         */
        @Override
        public void configure( AuthorizationServerSecurityConfigurer security ) throws Exception
        {
            LOG.trace( "Method: configure called." );

            super.configure( security );

        }

    }
}
