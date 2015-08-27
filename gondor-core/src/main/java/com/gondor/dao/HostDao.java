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

import com.gondor.model.orm.Host;
import com.gondor.model.orm.Service;


/**
 * @author Vipin Kumar
 * @created 25-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public interface HostDao
{
    /**
     * get the Object hierarchy for this host Object 
     * @param hostID
     * @return
     */
    public String getStatus( Integer hostID );


    /**
     * List all hosts maintained by this application
     * @return
     */
    public List<Host> getAllHosts();


    /**
     * List all services running in this  host
     * @return
     */
    public List<Service> getAllServices( Integer hostId );


    /**
     * create new host and return its generated id
     * @param host
     * @return
     */
    public Host cretateHost( Host host );


    /**
     * deactivate this host from cluster 
     * @param hostId
     */
    public void decomminsionHost( Integer hostId );


    /**
     * Add this host to cluster 
     * @param hostId
     * @param clusterId
     */
    public void addHostToCluster( Integer hostId, Integer clusterId );


    /**
     * Check if this host is present in any cluster
     * @param hostIdentifier
     * @return
     */
    public Boolean checkHostName( String hostIdentifier, boolean cluster );


    /**
     * Check if this host is present in any cluster on true
     * or if hosts exists on false
     * @param hostIdentifier
     * @return
     */
    public Boolean checkHost( Integer hostId, boolean cluster );


    /**
     * Get the host object
     * @param hostId
     * @return
     */
    public Host getHost( Integer hostId );
}
