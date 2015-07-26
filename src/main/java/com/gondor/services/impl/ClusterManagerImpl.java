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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gondor.dao.ClusterDao;
import com.gondor.model.orm.Cluster;
import com.gondor.model.orm.Host;
import com.gondor.services.ClusterManager;


/**
 * @author Vipin Kumar
 * @created 07-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Service ( "clusterManager")
public class ClusterManagerImpl implements ClusterManager
{
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ClusterManagerImpl.class );


    @Autowired
    private ClusterDao clusterDao;


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#getAllhosts(int)
     */
    @Override
    public List<Host> getAllhosts( int clusterId )
    {
        LOG.trace( "Method: getAllhosts called." );

        return clusterDao.getAllhosts( clusterId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#createCluster(java.lang.String)
     */
    @Override
    public void createCluster( Cluster cluster )
    {
        LOG.trace( "Method: createCluster called." );

        clusterDao.createCluster( cluster );

        LOG.trace( "Method: createCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#addHostToCluster(int, int)
     */
    @Override
    public void addHostToCluster( int hostId, int clusterId )
    {
        LOG.trace( "Method: addHostToCluster called." );
        clusterDao.addHostToCluster( hostId, clusterId );

        LOG.trace( "Method: addHostToCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#decommissionCluster(int)
     */
    @Override
    public void decommissionCluster( int clusterId )
    {
        LOG.trace( "Method: decommissionCluster called." );

        clusterDao.decommissionCluster( clusterId );
        LOG.trace( "Method: decommissionCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#deleteCluster(int)
     */
    @Override
    public void deleteCluster( int clusterId )
    {
        LOG.trace( "Method: deleteCluster called." );

        LOG.trace( "Method: deleteCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#getStatus(int)
     */
    @Override
    public String getStatus( int clusterId )
    {
        LOG.trace( "Method: getStatus called." );

        return clusterDao.getStatus( clusterId );

    }

}
