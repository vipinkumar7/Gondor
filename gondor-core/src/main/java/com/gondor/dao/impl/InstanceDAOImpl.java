/**
 *  * Copyright (c) 2015 Gondor. 
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

import com.gondor.dao.InstanceDao;
import com.gondor.exceptions.EntityNotFoundException;
import com.gondor.model.orm.Instance;
import com.gondor.model.orm.Service;
import com.gondor.model.orm.ServiceType;
import com.gondor.model.orm.SimpleConfiguration;


/**
 * @author Vipin Kumar
 * @created 25-Aug-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class InstanceDAOImpl extends BaseDAOImpl implements InstanceDao
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( InstanceDAOImpl.class );


    /**
     * @param sessionFactory
     */
    @Autowired
    public InstanceDAOImpl( SessionFactory sessionFactory )
    {
        super( sessionFactory );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#getStatus(java.lang.Integer)
     */
    @Override
    public String getStatus( Integer instanceId )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#getInstanceType(java.lang.Integer)
     */
    @Override
    public ServiceType getInstanceType( Integer instanceId )
    {
        LOG.trace( "Method: getInstanceType called." );

        Instance instance = (Instance) getCurrentSession().get( Instance.class, instanceId );
        return instance.getName();

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#checkIfInstanceExists(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public Instance getInstanceIfExists( ServiceType serviceType, Integer serviceId )
    {
        LOG.trace( "Method: checkIfInstanceExists called." );

        Criteria criteria = getCurrentSession().createCriteria( Instance.class );
        criteria.add( Restrictions.eq( "SERVICE_ID", serviceId ) );
        criteria.add( Restrictions.eq( "INSTANCE_NAME", serviceType ) );
        return (Instance) ( ( criteria != null && !criteria.list().isEmpty() ) ? criteria.list().get( 0 ) : null );

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#checkService(java.lang.Integer)
     */
    @Override
    public Instance getInstanceIfExists( Integer instanceId )
    {
        LOG.trace( "Method: checkService called." );
        Instance instance = (Instance) getCurrentSession().get( Instance.class, instanceId );
        return instance;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#getAllConfig(int)
     */
    @SuppressWarnings ( "unchecked")
    @Override
    public List<SimpleConfiguration> getAllConfig( int instanceId )
    {
        LOG.trace( "Method: getAllConfig called." );

        Instance instance = (Instance) getCurrentSession().get( Instance.class, instanceId );
        Criteria criteria = getCurrentSession().createCriteria( SimpleConfiguration.class );
        criteria.add( Restrictions.in( "SERVICE_TYPE", instance.getName().allChildren() ) );//for all children of this service
        return criteria.list();

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#startNewInstance(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public void startInstance( Integer instanceId )
    {
        LOG.trace( "Method: startNewInstance called." );

        Instance instance = (Instance) getCurrentSession().get( Instance.class, instanceId );
        instance.setRunning( true );
        getCurrentSession().update( instance );

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#stopInstance(java.lang.Integer)
     */
    @Override
    public void stopInstance( Integer instanceId )
    {
        LOG.trace( "Method: stopInstance called." );

        Instance instance = (Instance) getCurrentSession().get( Instance.class, instanceId );
        instance.setRunning( false );
        getCurrentSession().update( instance );

        LOG.trace( "Method: stopInstance finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#createNewInstance(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public Integer createNewInstance( ServiceType serviceType, Integer serviceId )
    {
        LOG.trace( "Method: createNewInstance called." );

        Instance instance = new Instance();
        Service service = (Service) getCurrentSession().get( Service.class, serviceId );
        if ( service == null )
            throw new EntityNotFoundException( "Service object  not found" );
        instance.setService( service );
        instance.setName( serviceType );
        getCurrentSession().save( service );
        return instance.getId();

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.InstanceDao#checkState(java.lang.Integer)
     */
    @Override
    public boolean checkState( Integer instanceId )
    {
        LOG.trace( "Method: checkState called." );

        Instance instance = (Instance) getCurrentSession().get( Instance.class, instanceId );
        return instance.isRunning();

    }


}
