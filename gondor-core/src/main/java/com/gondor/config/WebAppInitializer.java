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

import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.gondor.filters.GondorCorsFilter;


/**
 * @author Vipin Kumar
 * @created 15-Sep-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( WebAppInitializer.class );


    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
     */
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        LOG.trace( "Method: getRootConfigClasses called." );

        return new Class<?>[] { ApplicationContextConfig.class };

    }


    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
     */
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        LOG.trace( "Method: getServletConfigClasses called." );

        return new Class<?>[] { WebSecurityConfiguration.class, OAuth2ServerConfig.class, WebContextConfig.class };

    }


    /* (non-Javadoc)
    * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#onStartup(javax.servlet.ServletContext)
    */
    @Override
    public void onStartup( ServletContext servletContext ) throws ServletException
    {
        LOG.trace( "Method: onStartup called." );

        super.onStartup( servletContext );
        DelegatingFilterProxy filter = new DelegatingFilterProxy( "springSecurityFilterChain" );
        filter.setContextAttribute( "org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher" );
        servletContext.addFilter( "springSecurityFilterChain", filter ).addMappingForUrlPatterns( null, false, "/*" );

        LOG.trace( "Method: onStartup finished." );
    }


    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
     */
    @Override
    protected String[] getServletMappings()
    {
        LOG.trace( "Method: getServletMappings called." );

        return new String[] { "/" };

    }


    /* (non-Javadoc)
     * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletFilters()
     */
    @Override
    protected Filter[] getServletFilters()
    {
        LOG.trace( "Method: getServletFilters called." );


        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding( StandardCharsets.UTF_8.name() );
        GondorCorsFilter corsFilter = new GondorCorsFilter();
        return new Filter[] { characterEncodingFilter, corsFilter };

    }
}
