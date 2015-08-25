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

import com.gondor.dao.ServiceDao;
import com.gondor.dao.SimpleConfigurationDao;
import com.gondor.model.orm.Instance;
import com.gondor.model.orm.ServiceType;
import com.gondor.model.orm.SimpleConfiguration;
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
    private ServiceDao serviceDao;


    @Autowired
    private SimpleConfigurationDao configDao;


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#startService(com.gondor.model.ServiceType)
     */
    @Override
    public Integer startService( ServiceType serviceType, Integer hostId )
    {
        LOG.trace( "Method: startService called." );
        return serviceDao.startService( serviceType, hostId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#stopService(com.gondor.model.ServiceType)
     */
    @Override
    public void stopService( Integer serviceid )
    {
        LOG.trace( "Method: stopService called." );
        serviceDao.stopService( serviceid );

        LOG.trace( "Method: stopService finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getStatus(int)
     */
    @Override
    public String getStatus( Integer serviceid )
    {
        LOG.trace( "Method: getStatus called." );

        return serviceDao.getStatus( serviceid );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getAllInstances(int)
     */
    @Override
    public List<Instance> getAllInstances( int serviceId )
    {
        LOG.trace( "Method: getAllInstances called." );

        return serviceDao.getAllInstances( serviceId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#createService(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public Integer createService( ServiceType serviceType, Integer hostId )
    {
        LOG.trace( "Method: createService called." );

        return serviceDao.createService( serviceType, hostId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getServiceType(java.lang.Integer)
     */
    @Override
    public ServiceType getServiceType( Integer serviceid )
    {
        LOG.trace( "Method: getServiceType called." );

        return serviceDao.getServiceType( serviceid );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#checkIfServiceExists(com.gondor.model.orm.ServiceType, java.lang.Integer)
     */
    @Override
    public boolean checkIfServiceExists( ServiceType serviceType, Integer hostId )
    {
        LOG.trace( "Method: checkIfServiceExists called." );

        return serviceDao.checkIfServiceExists( serviceType, hostId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getAllConfig(int)
     */
    @Override
    public List<SimpleConfiguration> getAllConfig( int serviceId )
    {
        LOG.trace( "Method: getAllConfig called." );

        return serviceDao.getAllConfig( serviceId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#checkService(java.lang.Integer)
     */
    @Override
    public boolean checkService( Integer serviceid )
    {
        LOG.trace( "Method: checkService called." );

        return serviceDao.checkService( serviceid );

    }
}
