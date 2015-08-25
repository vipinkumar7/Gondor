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

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gondor.dao.SimpleConfigurationDao;
import com.gondor.dao.ServiceDao;
import com.gondor.model.orm.SimpleConfiguration;
import com.gondor.model.orm.ServiceType;
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
     * @see com.gondor.services.ServiceManager#checkService(com.gondor.model.ServiceType)
     */
    @Override
    public void checkService( Integer serviceid )
    {
        LOG.trace( "Method: checkService called." );

        serviceDao.checkService( serviceid );
        LOG.trace( "Method: checkService finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#getAllServiceconfig(com.gondor.model.ServiceType)
     */
    @Override
    public Set<SimpleConfiguration> getAllServiceconfig( Integer serviceid )
    {
        LOG.trace( "Method: getAllServiceconfig called." );

        Set<SimpleConfiguration> baseConfigurations = new HashSet<SimpleConfiguration>();
        ServiceType serviceType = serviceDao.getServiceType( serviceid );

        switch ( serviceType ) {
            case HDFS:
                break;
            case HBASE:
                break;
            case YARN:
                break;
        }

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.services.ServiceManager#restartService(com.gondor.model.orm.ServiceType)
     */
    @Override
    public void restartService( Integer serviceid )
    {
        LOG.trace( "Method: restartService called." );


        LOG.trace( "Method: restartService finished." );
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
}
