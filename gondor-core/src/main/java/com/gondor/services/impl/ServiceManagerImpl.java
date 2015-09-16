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

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gondor.model.orm.Host;
import com.gondor.model.orm.InstanceConfiguration;
import com.gondor.model.orm.ServiceType;
import com.gondor.repository.ServiceRepository;
import com.gondor.services.ServiceManager;


/**
 * @author Vipin Kumar
 * @created 08-Jul-2015
 * 
 * Service manager is responsible for managing all the services 
 * 
 */
@Service ( "serviceManager")
public class ServiceManagerImpl implements ServiceManager
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ServiceManagerImpl.class );


    @Autowired
    private ServiceRepository serviceRepository;


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#startService(com.gondor.model.ServiceType,java.lang.Integer)
     */
    @Override
    public void startService( ServiceType serviceType, Integer hostId )
    {
        LOG.trace( "Method: startService called." );
        serviceRepository.startService( serviceType, hostId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#stopService(java.lang.Integer)
     */
    @Override
    public void stopService( Integer serviceId )
    {
        LOG.trace( "Method: stopService called." );
        serviceRepository.stopService( serviceId );
        LOG.trace( "Method: stopService finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getStatus(java.lang.Integer)
     */
    @Override
    public String getStatus( Integer serviceId )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#createService(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public Integer createService( com.gondor.model.orm.Service service )
    {
        LOG.trace( "Method: createService called." );

        serviceRepository.save( service );
        return service.getId();
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getServiceType(java.lang.Integer)
     */
    @Override
    public ServiceType getServiceType( Integer serviceId )
    {
        LOG.trace( "Method: getServiceType called." );

        return serviceRepository.getServiceType( serviceId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#checkIfServiceExists(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public com.gondor.model.orm.Service getServiceIfExists( ServiceType serviceType, Integer hostId )
    {
        LOG.trace( "Method: checkIfServiceExists called." );

        return serviceRepository.getServiceIfExists( serviceType, hostId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#checkService(java.lang.Integer)
     */
    @Override
    public boolean checkService( Integer serviceId )
    {
        LOG.trace( "Method: checkService called." );

        return serviceRepository.checkState( serviceId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getServiceIfExists(java.lang.Integer)
     */
    @Override
    public com.gondor.model.orm.Service getServiceIfExists( Integer serviceId )
    {
        LOG.trace( "Method: getServiceIfExists called." );
        return serviceRepository.findOne( serviceId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#addServiceToHost(com.gondor.model.orm.Service, com.gondor.model.orm.Host)
     */
    @Override
    public void addServiceToHost( com.gondor.model.orm.Service service, Host host )
    {
        LOG.trace( "Method: addServiceToHost called." );
        service.setHost( host );
        serviceRepository.save( service );
        LOG.trace( "Method: addServiceToHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getAllConfig(java.lang.Integer)
     */
    @Override
    public Set<InstanceConfiguration> getAllConfig( Integer serviceId )
    {
        LOG.trace( "Method: getAllConfig called." );

        return serviceRepository.getAllConfig( serviceId );

    }

}
