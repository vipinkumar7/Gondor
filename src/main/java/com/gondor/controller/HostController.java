/**
 *  * Copyright (c) 2015 Gondor
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
package com.gondor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gondor.services.HostManager;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * Host specific tasks
 * 
 */
@Controller
@RequestMapping ( value = "/gondor/hosts")
public class HostController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HostController.class );

    @Autowired
    private HostManager hostManager;


    /**
     * 
     * @param id
     * @return
     */
    @RequestMapping ( value = "/{id}/status", method = RequestMethod.GET)
    public String getHostStatus( @PathVariable Integer id )
    {
        LOG.trace( "Method: getHostStatus called." );
        return hostManager.getStatus( id );
    }


    /**
     * 
     * @param host
     * @param clusterId
     * 
     * Create this host with host identifier in cluster (clusterId)
     */
    @RequestMapping ( value = "/create", method = RequestMethod.PUT)
    public void createHost( @RequestParam ( value = "host", required = true) String host,
        @RequestParam ( value = "clusterId", required = true) Integer clusterId )
    {
        hostManager.createHost( host, clusterId );
    }


    /**
     * 
     * @param host
     * @param clusterId
     * 
     * Validate if the host is not already present in cluster 
     */
    @RequestMapping ( value = "/validate", method = RequestMethod.GET)
    public Boolean validateHost( @RequestParam ( value = "host", required = true) String host,
        @RequestParam ( value = "clusterId", required = true) Integer clusterId )
    {
        return hostManager.validateHost( host, clusterId );

    }


    @RequestMapping ( value = "/check", method = RequestMethod.GET)
    public Boolean checkeHost( @RequestParam ( value = "host", required = true) String host )
    {
        return hostManager.checkHost( host );

    }


    @RequestMapping ( value = "/{id}/decomminsion", method = RequestMethod.GET)
    public void decomminsionHost( @PathVariable Integer id )
    {
        hostManager.decomminsionHost( id );
    }


}
