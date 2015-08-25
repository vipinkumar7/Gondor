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

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gondor.model.orm.SimpleConfiguration;
import com.gondor.model.orm.ServiceType;
import com.gondor.services.ServiceManager;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Controller
@RequestMapping ( value = "/gondor/services")
public class ServiceController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ServiceController.class );

    @Autowired
    private ServiceManager serviceManager;


    @RequestMapping ( value = "/{id}/status", method = RequestMethod.GET)
    public String getClustersStatus( @PathVariable Integer id, @RequestParam ( value = "host", required = true) Integer host )
    {
        LOG.trace( "Method: getClusters called." );
        return serviceManager.getStatus( id );
    }


    @RequestMapping ( value = "/{serviceType}/start/{hostId}", method = RequestMethod.GET)
    public void startService( @PathVariable ServiceType serviceType, @PathVariable Integer hostId )
    {
        LOG.trace( "Method: getClusters called." );
        serviceManager.startService( serviceType, hostId );
    }


    @RequestMapping ( value = "/{id}/stop", method = RequestMethod.GET)
    public void stopService( @PathVariable Integer id )
    {
        LOG.trace( "Method: getClusters called." );
        serviceManager.stopService( id );
    }


    @RequestMapping ( value = "/{id}/config", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Set<SimpleConfiguration>> getAllServiceConfig( @PathVariable Integer id )
    {
        LOG.trace( "Method: getClusters called." );
        return new ResponseEntity<Set<SimpleConfiguration>>( serviceManager.getAllServiceconfig( id ), HttpStatus.OK );
    }

}
