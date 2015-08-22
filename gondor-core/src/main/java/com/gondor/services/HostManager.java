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
package com.gondor.services;

import com.gondor.model.orm.Host;


/**
 * @author Vipin Kumar
 * @created 23-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

public interface HostManager
{


    public String getStatus( int hostId );


    /**
     * create new host with the IP or host name provided
     * @param hostname
     */
    public void createHost( String hostIdentifier, Integer clusterId );


    /**
     * 
     * @param hostIdentifier
     * @return
     * hostIdentifier can be IP or Hostname
     */
    public Boolean validateHost( String hostIdentifier, Integer clusterId );


    /**
     * remove all services from this host
     * @param hostId
     */
    public void decomminsionHost( int hostId );


    public Boolean checkHost( String hostIdentifier );


    public Host getHost( int hostId );


    public Host getHost( String hostname );

}
