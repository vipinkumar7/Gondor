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
package com.gondor.dao;

import java.util.List;

import com.gondor.model.orm.Cluster;
import com.gondor.model.orm.Host;


/**
 * @author Vipin Kumar
 * @created 25-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public interface ClusterDao
{
    public String getStatus( Integer clusterId );


    /**
     * List all the clusters maintained by the application
     * @return
     */
    public List<Cluster> listAllClusters();


    /**
     * List all the hosts in cluster
     * @param clusterId
     * @return
     */
    public List<Host> getAllhosts( Integer clusterId );


    /**
     * Create new cluster
     * @param cluster
     * @return newly created cluster id
     */
    public Integer createCluster( Cluster cluster );


    /**
     * stop all cluster hosts and services
     * @param clusterId
     */
    public void decommissionCluster( Integer clusterId );


    /**
     * Get the cluster with this id
     * @param clusterId
     * @return
     */
    public Cluster getCluster( Integer clusterId );

}
