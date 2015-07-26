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

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.gondor.dao.ServiceDao;
import com.gondor.model.orm.BaseConfiguration;
import com.gondor.model.orm.ServiceType;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Repository
public class ServiceDAOImpl implements ServiceDao
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ServiceDAOImpl.class );


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
    public Integer startService( ServiceType serviceType )
    {
        LOG.trace( "Method: startService called." );

        return 0;
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#stopService(java.lang.Integer)
     */
    @Override
    public void stopService( Integer serviceid )
    {
        LOG.trace( "Method: stopService called." );


        LOG.trace( "Method: stopService finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#checkService(java.lang.Integer)
     */
    @Override
    public void checkService( Integer serviceid )
    {
        LOG.trace( "Method: checkService called." );


        LOG.trace( "Method: checkService finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#getAllServiceconfig(java.lang.Integer)
     */
    @Override
    public Set<BaseConfiguration> getAllServiceconfig( Integer serviceid )
    {
        LOG.trace( "Method: getAllServiceconfig called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ServiceDao#changeConfiguration(java.lang.Integer, com.gondor.model.orm.BaseConfiguration)
     */
    @Override
    public boolean changeConfiguration( Integer serviceid, BaseConfiguration configObject )
    {
        LOG.trace( "Method: changeConfiguration called." );

        return false;

    }
}
