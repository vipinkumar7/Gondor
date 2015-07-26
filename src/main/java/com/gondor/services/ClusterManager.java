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


    public String getStatus( int clusterId );


    /**
     * get all hosts in the cluster
     * @param clusterId
     * @return
     */
    public List<Host> getAllhosts( int clusterId );


    /**
     * create new cluster
     */
    public void createCluster( String name );


    /**
     * add this host(hostId) to this cluster(clusterId)
     * @param hostId
     * @param clusterId
     */
    public void addHostToCluster( int hostId, int clusterId );


    /**
     * remove all installed services from system
     * @param clusterId
     */
    public void decommissionCluster( int clusterId );


    /**
     * delete this cluster
     * @param clusterId
     */
    public void deleteCluster( int clusterId );


}
