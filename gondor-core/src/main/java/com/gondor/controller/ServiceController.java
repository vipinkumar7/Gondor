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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gondor.model.orm.Service;
import com.gondor.model.orm.ServiceType;
import com.gondor.model.orm.SimpleConfiguration;
import com.gondor.services.ServiceManager;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Controller
@RequestMapping ( value = "/gondor/service")
public class ServiceController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ServiceController.class );

    @Autowired
    private ServiceManager serviceManager;


    /**
     * 
     * @param serviceType
     * @param hostId
     * @return
     */
    @RequestMapping ( value = "/create/{serviceType}/{hostId}", method = { RequestMethod.GET })
    public Integer createService( @PathVariable ServiceType serviceType, @PathVariable Integer hostId )
    {
        LOG.trace( "Method: createService called." );
        return 1;//serviceManager.createService( serviceType, hostId );
    }


    /**
     * 
     * @param id
     * @param host
     * @return
     */
    @RequestMapping ( value = "/{id}/status", method = RequestMethod.GET)
    public String getServiceStatus( @PathVariable Integer id )
    {
        LOG.trace( "Method: getServiceStatus called." );
        return serviceManager.getStatus( id );
    }


    @RequestMapping ( value = "/{id}/type", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ServiceType> getServiceType( @PathVariable Integer id )
    {
        LOG.trace( "Method: getServiceType called." );
        return new ResponseEntity<ServiceType>( serviceManager.getServiceType( id ), HttpStatus.OK );
    }


    /**
     * 
     * @param serviceType
     * @param hostId
     */
    @RequestMapping ( value = "/{serviceType}/start/{hostId}", method = RequestMethod.GET)
    public void startService( @PathVariable ServiceType serviceType, @PathVariable Integer hostId )
    {
        LOG.trace( "Method: startService called." );
        serviceManager.startService( serviceType, hostId );
    }


    /**
     * 
     * @param id
     */
    @RequestMapping ( value = "/{id}/stop", method = RequestMethod.GET)
    public void stopService( @PathVariable Integer id )
    {
        LOG.trace( "Method: stopService called." );
        serviceManager.stopService( id );
    }


    /**
     * 
     * @param id
     * @return
     */
    @RequestMapping ( value = "/{id}/config", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<SimpleConfiguration>> getAllServiceConfig( @PathVariable Integer id )
    {
        LOG.trace( "Method: getAllServiceConfig called." );
        return null;//new ResponseEntity<List<SimpleConfiguration>>( serviceManager.getAllConfig( id ), HttpStatus.OK );
    }


    /**
     * 
     * @param type
     * @param hostId
     * @return
     */
    @RequestMapping ( value = "/{type}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Service> getServiceIfExists( @PathVariable ServiceType type,
        @RequestParam ( value = "hostId", required = true) Integer hostId )
    {

        return new ResponseEntity<Service>( serviceManager.getServiceIfExists( type, hostId ), HttpStatus.OK );

    }


    /**
     * 
     * @param id
     * @return
     */
    @RequestMapping ( value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Service> getServiceIfExists( @PathVariable Integer id )
    {
        return new ResponseEntity<Service>( serviceManager.getServiceIfExists( id ), HttpStatus.OK );
    }


    /**
     * 
     * @param id
     * @return
     */
    @RequestMapping ( value = "/{id}/check", method = RequestMethod.GET)
    public Boolean checkService( @PathVariable Integer id )
    {
        return serviceManager.checkService( id );
    }
}
