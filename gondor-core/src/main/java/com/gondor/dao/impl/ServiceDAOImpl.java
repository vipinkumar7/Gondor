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

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gondor.dao.ServiceDao;
import com.gondor.exceptions.EntityNotFoundException;
import com.gondor.model.orm.Host;
import com.gondor.model.orm.Service;
import com.gondor.model.orm.ServiceType;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Repository
public class ServiceDAOImpl extends BaseDAOImpl implements ServiceDao
{


    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ServiceDAOImpl.class );


    /**
     * @param sessionFactory
     */
    @Autowired
    public ServiceDAOImpl( SessionFactory sessionFactory )
    {
        super( sessionFactory );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#getStatus(java.lang.Integer)
     */
    @Override
    public String getStatus( Integer serviceid )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#startService(com.gondor.model.orm.ServiceType)
     */
    @Override
    public Integer createService( ServiceType serviceType, Integer hostId )
    {
        LOG.trace( "Method: startService called." );

        Service service = new Service();
        Host host = (Host) getCurrentSession().get( Host.class, hostId );
        if ( host == null )
            throw new EntityNotFoundException( "Host object  not found" );
        service.setHost( host );
        service.setName( serviceType );
        getCurrentSession().save( service );
        return service.getId();
        //TODO python service call
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#stopService(java.lang.Integer)
     */
    @Override
    public void stopService( Integer serviceid )
    {
        LOG.trace( "Method: stopService called." );
        Service service = (Service) getCurrentSession().get( Service.class, serviceid );
        service.setRunning( false );
        getCurrentSession().saveOrUpdate( service );

        LOG.trace( "Method: stopService finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#checkService(java.lang.Integer)
     */
    @Override
    public boolean checkService( Integer serviceid )
    {
        LOG.trace( "Method: checkService called." );
        Service service = (Service) getCurrentSession().get( Service.class, serviceid );
        return service.isRunning();

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#checkService(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public boolean checkIfServiceExists( ServiceType serviceType, Integer hostId )
    {
        LOG.trace( "Method: checkIfServiceExists called." );
        String hql = "from Service where HOST_ID= :host  and  SERVICE_NAME =:service";
        Query query = getCurrentSession().createQuery( hql );
        query.setParameter( "host", hostId );
        query.setParameter( "service", serviceType );
        @SuppressWarnings ( "unchecked") List<Service> lServices = query.list();
        if ( lServices != null && !lServices.isEmpty() )
            return true;
        return false;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#startService(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public Integer startService( ServiceType serviceType, Integer hostId )
    {
        LOG.trace( "Method: startService called." );
        String hql = "UPDATE Service set STATE=:state where HOST_ID=:host  and  SERVICE_NAME =:service";
        Query query = getCurrentSession().createQuery( hql );
        query.setParameter( "state", true );
        query.setParameter( "host", hostId );
        query.setParameter( "service", serviceType );
        return query.executeUpdate();
        //TODO python service call
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#getServiceType(java.lang.Integer)
     */
    @Override
    public ServiceType getServiceType( Integer serviceid )
    {
        LOG.trace( "Method: getServiceType called." );
        Service service = (Service) getCurrentSession().get( Service.class, serviceid );
        return service.getName();


    }
}
