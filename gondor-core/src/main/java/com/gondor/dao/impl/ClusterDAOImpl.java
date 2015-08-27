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
import com.gondor.exceptions.EntityNotFoundException;
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
public class ClusterDAOImpl extends BaseDAOImpl implements ClusterDao
{


    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ClusterDAOImpl.class );


    /**
     * @param sessionFactory
     */
    @Autowired
    public ClusterDAOImpl( SessionFactory sessionFactory )
    {
        super( sessionFactory );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#listAll()
     */
    @Override
    @Transactional
    public List<Cluster> listAllClusters()
    {
        LOG.trace( "Method: listAll called." );
        @SuppressWarnings ( "unchecked") List<Cluster> listCluster = getCurrentSession().createCriteria( Cluster.class )
            .setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).list();
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

        Criteria criteria = getCurrentSession().createCriteria( Host.class );
        LOG.trace( "Method: getAllhosts called." );
        criteria.add( Restrictions.eq( "CLUSTER_ID", clusterId ) );
        return criteria.list();

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#createCluster(java.lang.String)
     */
    @Override
    @Transactional ( rollbackFor = RuntimeException.class)
    public Integer createCluster( Cluster cluster )
    {
        LOG.trace( "Method: createCluster called." );

        getCurrentSession().save( cluster );
        return cluster.getId();
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#decommissionCluster(int)
     */
    @Override
    public void decommissionCluster( int clusterId )
    {
        LOG.trace( "Method: decommissionCluster called." );
        Cluster cluster = (Cluster) getCurrentSession().get( Cluster.class, clusterId );
        cluster.setActive( false );
        getCurrentSession().saveOrUpdate( cluster );
        LOG.trace( "Method: decommissionCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#getCluster(int)
     */
    @Override
    public Cluster getCluster( int clusterId )
    {
        LOG.trace( "Method: getCluster called." );

        Cluster cluster = (Cluster) getCurrentSession().get( Cluster.class, clusterId );

        if ( cluster == null )
            throw new EntityNotFoundException( String.format( "%s  %d  %s \n", "cluster with id :", clusterId, " not found" ) );
        else
            return cluster;

    }


}
