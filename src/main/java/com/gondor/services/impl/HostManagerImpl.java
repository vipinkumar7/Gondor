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
package com.gondor.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gondor.model.Hosts;
import com.gondor.services.HostManager;

/**
 * @author Vipin Kumar
 * @created 23-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Service("hostManager")
public class HostManagerImpl implements HostManager
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HostManagerImpl.class );

    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getAllHosts()
     */
    @Override
    public List<Hosts> getAllHosts(int clusterId)
    {
        LOG.trace("Method: getAllHosts called.");
        
        return null;
        
    }

    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#createHostOnCluster(int, int)
     */
    @Override
    public void createHostOnCluster( int hostId, int clusterId )
    {
        LOG.trace("Method: createHostOnCluster called.");
        
        
        LOG.trace("Method: createHostOnCluster finished.");
    }

    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#decomminsionHost(int, int)
     */
    @Override
    public void decomminsionHost( int hostId, int clusterId )
    {
        LOG.trace("Method: decomminsionHost called.");
        
        
        LOG.trace("Method: decomminsionHost finished.");
    }
}
