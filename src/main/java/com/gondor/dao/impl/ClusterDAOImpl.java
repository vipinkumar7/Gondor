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
package com.gondor.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gondor.dao.ClusterDao;
import com.gondor.model.orm.Cluster;
import com.gondor.model.orm.Host;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Repository
public class ClusterDAOImpl implements ClusterDao
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ClusterDAOImpl.class );


    @Autowired
    private SessionFactory sessionFactory;


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#listAll()
     */
    @Override
    @Transactional
    public List<Cluster> listAllClusters()
    {
        LOG.trace( "Method: listAll called." );
        @SuppressWarnings ( "unchecked") List<Cluster> listCluster = sessionFactory.getCurrentSession()
            .createCriteria( Cluster.class ).setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).list();

        return listCluster;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#getStatus(int)
     */
    @Override
    public String getStatus( int clusterId )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#getAllhosts(int)
     */
    @SuppressWarnings ( "unchecked")
    @Override
    public List<Host> getAllhosts( int clusterId )
    {
        LOG.trace( "Method: getAllhosts called." );

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria( Host.class );
        criteria.add( Restrictions.eq( "CLUSTER_ID", clusterId ) );
        return criteria.list();

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#createCluster(java.lang.String)
     */
    @Override
    public void createCluster( Cluster cluster )
    {
        LOG.trace( "Method: createCluster called." );

        sessionFactory.getCurrentSession().saveOrUpdate( cluster );

        LOG.trace( "Method: createCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#addHostToCluster(int, int)
     */
    @Override
    @Transactional
    public void addHostToCluster( int hostId, int clusterId )
    {
        LOG.trace( "Method: addHostToCluster called." );

        Host host = (Host) sessionFactory.getCurrentSession().get( Host.class, hostId );
        Cluster cluster = (Cluster) sessionFactory.getCurrentSession().get( Cluster.class, clusterId );
        host.setCluster( cluster );

        LOG.trace( "Method: addHostToCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#decommissionCluster(int)
     */
    @Override
    public void decommissionCluster( int clusterId )
    {
        LOG.trace( "Method: decommissionCluster called." );


        LOG.trace( "Method: decommissionCluster finished." );
    }


}
