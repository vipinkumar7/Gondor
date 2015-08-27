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
package com.gondor.services;

import java.util.List;

import com.gondor.model.orm.Cluster;
import com.gondor.model.orm.Host;


/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public interface ClusterManager
{


    /**
     * List all object hierarchy for this cluster eg cluster -> hosts -> services
     * @param clusterId
     * @return
     */
    public String getStatus( Integer clusterId );


    /**
     * List all the clusters maintained by the application
     * @return
     */
    public List<Cluster> listAllClusters();


    /**
     * get all hosts in the cluster
     * @param clusterId
     * @return
     */
    public List<Host> getAllhosts( Integer clusterId );


    /**
     * create new cluster
     */
    public void createCluster( Cluster cluster );


    /**
     * remove all installed services from system
     * @param clusterId
     */
    public void decommissionCluster( Integer clusterId );


    /**
     * delete this cluster
     * @param clusterId
     */
    public void deleteCluster( Integer clusterId );


}
