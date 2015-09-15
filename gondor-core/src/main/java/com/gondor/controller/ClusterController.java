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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gondor.model.orm.Cluster;
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
@RequestMapping ( value = "/cluster")
public class ClusterController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ClusterController.class );


    @Autowired
    private ClusterManager clusterManager;


    @RequestMapping ( value = "", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus ( value = HttpStatus.OK)
    public void createCluster( @RequestBody Cluster cluster )
    {
        LOG.trace( "Method: createCluster called." );
        clusterManager.createCluster( cluster );
    }


    /**
     * 
     * @param id
     * @return
     */

    @RequestMapping ( value = "/{clusterId}/status", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation ( value = "get the status of cluster")
    @ApiResponses ( value = { @ApiResponse ( code = 200, message = "") })
    public String getClusterStatus(
        @ApiParam ( name = "clusterId", value = "id of cluster", required = true) @PathVariable Integer clusterId )
    {
        LOG.trace( "Method: getClusterStatus called." );
        return clusterManager.getStatus( clusterId );
    }


    /**
     * 
     * @return
     */
    @RequestMapping ( value = "/all", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<List<Cluster>> getAllClusters()
    {
        LOG.trace( "Method: getAllClusters called." );
        return new ResponseEntity<List<Cluster>>( clusterManager.listAllClusters(), HttpStatus.OK );
    }


    /**
     * 
     * @param id
     * @return
     * 
     * All hosts belongs to this Cluster
     */
    @RequestMapping ( value = "/{clusterId}/hosts", method = { RequestMethod.GET })
    @ResponseBody
    public ResponseEntity<Set<Host>> getAllHosts( @PathVariable Integer clusterId )
    {
        LOG.trace( "Method: getAllHosts called." );
        return new ResponseEntity<Set<Host>>( clusterManager.getAllhosts( clusterId ), HttpStatus.OK );
    }


    /**
     * 
     * @param id
     */
    @RequestMapping ( value = "/{clusterId}/decommission", method = RequestMethod.GET)
    @ResponseBody
    public void decommissionCluster( @PathVariable Integer clusterId )
    {
        LOG.trace( "Method: decommissionCluster called." );
        clusterManager.decommissionCluster( clusterId );
    }


    /**
     * 
     * @param clusterId
     */
    @RequestMapping ( value = "/{clusterId}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCluster( @PathVariable Integer clusterId )
    {
        LOG.trace( "Method: decommissionCluster called." );
        clusterManager.deleteCluster( clusterId );
    }
}
