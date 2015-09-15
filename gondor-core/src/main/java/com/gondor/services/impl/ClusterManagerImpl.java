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
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gondor.exceptions.WrongEntityException;
import com.gondor.model.orm.Cluster;
import com.gondor.model.orm.Host;
import com.gondor.repository.ClusterRepository;
import com.gondor.services.ClusterManager;


/**
 * @author Vipin Kumar
 * @created 07-Jul-2015
 * 
 * Service layer for managing clusters
 * 
 */
@Service ( "clusterManager")
public class ClusterManagerImpl implements ClusterManager
{
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ClusterManagerImpl.class );


    @Autowired
    private ClusterRepository clusterRepository;


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#getAllhosts(int)
     */
    @Override
    public Set<Host> getAllhosts( Integer clusterId )
    {
        LOG.trace( "Method: getAllhosts called." );

        return clusterRepository.getHosts( clusterId );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#createCluster(java.lang.String)
     */
    @Override
    public void createCluster( Cluster cluster )
    {
        LOG.trace( "Method: createCluster called." );

        try {
            clusterRepository.save( cluster );

        } catch ( DataIntegrityViolationException e ) {
            throw new WrongEntityException( "Cluster name should be unique" );
        }
        LOG.trace( "Method: createCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#decommissionCluster(Integer)
     */
    @Override
    public void decommissionCluster( Integer clusterId )
    {
        LOG.trace( "Method: decommissionCluster called." );

        clusterRepository.decommissionCluster( clusterId );

        LOG.trace( "Method: decommissionCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#deleteCluster(Integer)
     */
    @Override
    public void deleteCluster( Integer clusterId )
    {
        LOG.trace( "Method: deleteCluster called." );
        clusterRepository.delete( clusterId );

        LOG.trace( "Method: deleteCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#getStatus(int)
     */
    @Override
    public String getStatus( Integer clusterId )
    {
        LOG.trace( "Method: getStatus called." );
        return null;
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ClusterManager#listAllClusters()
     */
    @Override
    public List<Cluster> listAllClusters()
    {
        LOG.trace( "Method: listAllClusters called." );
        return clusterRepository.findAll();
    }

}
