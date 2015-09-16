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
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gondor.model.orm.Host;
import com.gondor.model.orm.Service;
import com.gondor.services.HostManager;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * Host specific tasks
 * 
 */
@Controller
@RequestMapping ( value = "/host")
public class HostController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HostController.class );

    @Autowired
    private HostManager hostManager;


    /**
     * 
     * @return
     */
    @RequestMapping ( value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Host>> getAllHosts()
    {
        LOG.trace( "Method: getAllHosts called." );
        return new ResponseEntity<List<Host>>( hostManager.getAllHosts(), HttpStatus.OK );
    }


    /**
     * 
     * @param id
     * @return
     */
    @RequestMapping ( value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Host> getHost( @PathVariable Integer id )
    {
        LOG.trace( "Method: getAllHosts called." );
        return new ResponseEntity<Host>( hostManager.getHost( id ), HttpStatus.OK );
    }


    /**
     * All services running in this host
     * @param hostId
     * @return
     */
    @RequestMapping ( value = "/{id}/services", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Set<Service>> getAllServices( @PathVariable Integer hostId )
    {
        LOG.trace( "Method: getAllServices called." );
        return new ResponseEntity<Set<Service>>( hostManager.getAllServices( hostId ), HttpStatus.OK );
    }


    /**
     * 
     * @param id
     * @return
     */
    @RequestMapping ( value = "/{id}/status", method = RequestMethod.GET)
    @ResponseBody
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
    @ResponseBody
    public ResponseEntity<Host> createHost( @RequestParam ( value = "clusterId", required = true) Integer clusterId,
        @RequestBody Host host )
    {
        return new ResponseEntity<Host>( hostManager.cretateHost( host ), HttpStatus.OK );
    }


    /**
     * 
     * @param host
     * @param clusterId
     * 
     * Validate if the hostname/ip is present any cluster
     */
    @RequestMapping ( value = "/{hostname}/validate", method = RequestMethod.GET)
    public Boolean validateHost( @PathVariable String hostname,
        @RequestParam ( value = "cluster", required = true) Boolean inCluster )
    {

        return inCluster == true ? hostManager.checkIfHostInAnyCluster( hostname ) : hostManager
            .validateHostAlreadyPresent( hostname );

    }


    @RequestMapping ( value = "/{id}/check", method = RequestMethod.GET)
    public Boolean checkeHost( @PathVariable Integer id, @RequestParam ( value = "cluster", required = true) Boolean inCluster )
    {
        return inCluster == true ? hostManager.checkIfHostInAnyCluster( id ) : false;

    }


    @RequestMapping ( value = "/{id}/decomminsion", method = RequestMethod.GET)
    public void decomminsionHost( @PathVariable Integer id )
    {
        hostManager.decomminsionHost( id );
    }


    @RequestMapping ( value = "/{clusterId}/add", method = RequestMethod.GET)
    public void addHostsToCluster( @RequestBody Host host, @PathVariable Integer clusterId )
    {
        //   hostManager.addHostToCluster( host, clusterId );
    }

}
