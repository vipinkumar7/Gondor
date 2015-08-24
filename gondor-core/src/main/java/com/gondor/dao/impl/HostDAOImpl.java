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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gondor.dao.HostDao;
import com.gondor.model.orm.Cluster;
import com.gondor.model.orm.Host;
import com.gondor.model.orm.Service;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Repository
public class HostDAOImpl extends BaseDAOImpl implements HostDao
{


    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HostDAOImpl.class );


    /**
     * @param sessionFactory
     */
    @Autowired
    public HostDAOImpl( SessionFactory sessionFactory )
    {
        super( sessionFactory );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#getStatus(int)
     */
    @Override
    public String getStatus( int hostID )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#cretateHost(java.lang.String)
     */
    @Override
    public int cretateHost( Host host )
    {
        LOG.trace( "Method: cretateHost called." );

        getCurrentSession().save( host );
        return host.getId();
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#decomminsionHost(int)
     */
    @Override
    public void decomminsionHost( int hostId )
    {
        LOG.trace( "Method: decomminsionHost called." );


        LOG.trace( "Method: decomminsionHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#validateHost(java.lang.String, java.lang.Integer)
     */
    @Override
    public Boolean validateHostAlreadyPresent( String hostIdentifier, Integer clusterId )
    {
        LOG.trace( "Method: validateHost called." );
        String hql = "from Host where HOST_IP= :ip  or   HOST_NAME =:name and CLUSTER_ID=:cluster";
        Query query = getCurrentSession().createQuery( hql );
        query.setParameter( "ip", hostIdentifier );
        query.setParameter( "name", hostIdentifier );
        query.setParameter( "cluster", clusterId );
        @SuppressWarnings ( "unchecked") List<Service> lServices = query.list();
        if ( lServices != null && !lServices.isEmpty() )
            return true;
        return false;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#checkHost(java.lang.String)
     */
    @Override
    public Boolean checkHost( String hostIdentifier )
    {
        LOG.trace( "Method: checkHost called." );
        //TODO native class for network check 
        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#getHost(int)
     */
    @Override
    public Host getHost( int hostId )
    {
        LOG.trace( "Method: getHost called." );
        Host host = (Host) getCurrentSession().get( Host.class, hostId );
        return host;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#addHostToCluster(int, int)
     */
    @Override
    @Transactional
    public void addHostToCluster( int hostId, int clusterId )
    {
        LOG.trace( "Method: addHostToCluster called." );

        Host host = (Host) getCurrentSession().get( Host.class, hostId );
        Cluster cluster = (Cluster) getCurrentSession().get( Cluster.class, clusterId );
        host.setCluster( cluster );
        getCurrentSession().saveOrUpdate( host );
        LOG.trace( "Method: addHostToCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#getAllHosts()
     */
    @Override
    public List<Host> getAllHosts()
    {
        LOG.trace( "Method: getAllHosts called." );

        LOG.trace( "Method: listAll called." );
        @SuppressWarnings ( "unchecked") List<Host> listhHosts = getCurrentSession().createCriteria( Host.class )
            .setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).list();
        return listhHosts;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#validateHostAlreadyPresent(java.lang.String)
     */
    @Override
    public Boolean validateHostAlreadyPresent( String hostIdentifier )
    {
        LOG.trace( "Method: validateHostAlreadyPresent called." );
        LOG.trace( "Method: validateHost called." );
        String hql = "from Host where HOST_IP= :ip  or   HOST_NAME =:name ";
        Query query = getCurrentSession().createQuery( hql );
        query.setParameter( "ip", hostIdentifier );
        query.setParameter( "name", hostIdentifier );
        @SuppressWarnings ( "unchecked") List<Service> lServices = query.list();
        if ( lServices != null && !lServices.isEmpty() )
            return true;
        return false;

    }
}
