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
import org.springframework.web.bind.annotation.ResponseBody;

import com.gondor.model.orm.Host;
import com.gondor.services.ClusterManager;


/**
 * @author Vipin Kumar
 * @created 25-Jul-2015
 * 
 * 
 * Class responsible for cluster manager specific tasks
 */

@Controller
@RequestMapping ( value = "/gondor/clusters")
public class ClusterController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ClusterController.class );


    @Autowired
    private ClusterManager clusterManager;


    /**
     * 
     * @param id
     * @return
     */
    @RequestMapping ( value = "/{id}/status", method = RequestMethod.GET)
    public String getClusterStatus( @PathVariable Integer id )
    {
        LOG.trace( "Method: getCluster called." );
        return clusterManager.getStatus( id );
    }


    /**
     * 
     * @param id
     * @return
     * 
     * All hosts belongs to this Cluster
     */
    @RequestMapping ( value = "/{id}/hosts", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Host>> getAllHosts( @PathVariable Integer id )
    {
        LOG.trace( "Method: getAllHosts called." );
        return new ResponseEntity<List<Host>>( clusterManager.getAllhosts( id ), HttpStatus.OK );
    }


    @RequestMapping ( value = "/{id}/decommission", method = RequestMethod.GET)
    public void decommissionCluster( @PathVariable Integer id )
    {
        LOG.trace( "Method: decommissionCluster called." );
        clusterManager.decommissionCluster( id );
    }


    @RequestMapping ( value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCluster( @PathVariable Integer id )
    {
        LOG.trace( "Method: decommissionCluster called." );
        clusterManager.deleteCluster( id );
    }
}
