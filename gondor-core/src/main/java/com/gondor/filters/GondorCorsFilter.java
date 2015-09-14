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
package com.gondor.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


/**
 * @author Vipin Kumar
 * @created 24-Aug-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Component
public class GondorCorsFilter implements Filter
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( GondorCorsFilter.class );


    @Override
    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader( "Access-Control-Allow-Origin", "*" );
        response.addHeader( "Access-Control-Allow-Headers", "Authorization,Origin, "
            + "No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, "
            + "Cache-Control, Expires, Content-Type, X-E4M-With, Accept" );
        //response.setHeader( "Content-Type", "application/json" );
        response.addHeader( "Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE" );
        response.addHeader( "Access-Control-Max-Age", "3600" );
        chain.doFilter( req, res );

    }


    @Override
    public void init( FilterConfig arg0 ) throws ServletException
    {
        LOG.debug( "Cors Filter Initialized" );
    }


    @Override
    public void destroy()
    {

    }
}
