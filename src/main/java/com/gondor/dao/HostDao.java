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


/**
 * @author Vipin Kumar
 * @created 25-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public interface HostDao
{
    public String getStatus( int hostID );


    public List<Host> getAllHosts();


    public int cretateHost( Host host );


    public void decomminsionHost( int hostId );


    public Boolean validateHostAlreadyPresent( String hostIdentifier );


    public Boolean validateHostAlreadyPresent( String hostIdentifier, Integer clusterId );


    public void addHostToCluster( int hostId, int clusterId );


    public Boolean checkHost( String hostIdentifier );


    public Host getHost( int hostId );
}
