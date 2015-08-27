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
import org.hibernate.criterion.Restrictions;
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
    public String getStatus( Integer hostID )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#cretateHost(java.lang.String)
     */
    @Override
    @Transactional ( rollbackFor = RuntimeException.class)
    public Host cretateHost( Host host )
    {
        LOG.trace( "Method: cretateHost called." );

        getCurrentSession().save( host );
        return host;
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#decomminsionHost(int)
     */
    @Override
    public void decomminsionHost( Integer hostId )
    {
        LOG.trace( "Method: decomminsionHost called." );
        Host host = (Host) getCurrentSession().get( Host.class, hostId );
        host.setActive( false );
        getCurrentSession().saveOrUpdate( host );
        LOG.trace( "Method: decomminsionHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#getHost(int)
     */
    @Override
    public Host getHost( Integer hostId )
    {
        LOG.trace( "Method: getHost called." );
        Host host = (Host) getCurrentSession().get( Host.class, hostId );
        return host;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#addHostToCluster(int, int)
     */
    @Override
    @Transactional ( rollbackFor = RuntimeException.class)
    public void addHostToCluster( Integer hostId, Integer clusterId )
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
     * @see com.gondor.dao.HostDao#getAllServices()
     */
    @SuppressWarnings ( "unchecked")
    @Override
    public List<Service> getAllServices( Integer hostId )
    {
        LOG.trace( "Method: getAllServices called." );

        Criteria criteria = getCurrentSession().createCriteria( Service.class );
        criteria.add( Restrictions.eq( "HOST_ID", hostId ) );
        return criteria.list();


    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#checkHost(java.lang.String, boolean)
     */
    @Override
    public Boolean checkHostName( String hostIdentifier, boolean cluster )
    {
        LOG.trace( "Method: checkHost called." );

        String hql = "from Host where HOST_IP= :ip  or   HOST_NAME =:name ";
        Query query = getCurrentSession().createQuery( hql );
        query.setParameter( "ip", hostIdentifier );
        query.setParameter( "name", hostIdentifier );
        @SuppressWarnings ( "unchecked") List<Host> hosts = query.list();

        return cluster == false ? ( ( hosts != null && !hosts.isEmpty() ) ? true : false ) : ( ( hosts == null || hosts
            .isEmpty() ) ? false : ( hosts.get( 0 ).getCluster() != null ? true : false ) );

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#checkHost(int, boolean)
     */
    @Override
    public Boolean checkHost( Integer hostId, boolean cluster )
    {
        LOG.trace( "Method: checkHost called." );

        Host host = (Host) getCurrentSession().get( Host.class, hostId );
        return cluster == false ? ( host != null ? true : false ) : ( host == null ? false : ( host.getCluster() != null ? true
            : false ) );

    }
}
