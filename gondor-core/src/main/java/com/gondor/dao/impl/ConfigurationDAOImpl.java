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

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gondor.dao.SimpleConfigurationDao;
import com.gondor.model.orm.SimpleConfiguration;


/**
 * @author Vipin Kumar
 * @created 22-Jun-2015
 *
 * TODO: Write a quick description of what the class is supposed to do.
 *
 */
@Repository
public class ConfigurationDAOImpl extends BaseDAOImpl implements SimpleConfigurationDao
{
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ConfigurationDAOImpl.class );


    /**
     * @param sessionFactory
     */
    @Autowired
    public ConfigurationDAOImpl( SessionFactory sessionFactory )
    {
        super( sessionFactory );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.SimpleConfigurationDao#saveConfigs(java.util.List)
     */
    @Override
    @Transactional
    public void saveConfigs( List<SimpleConfiguration> configs )
    {
        LOG.trace( "Method: saveConfigs called." );
        for ( SimpleConfiguration config : configs ) {
            getCurrentSession().saveOrUpdate( config );
        }

        LOG.trace( "Method: saveConfigs finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.SimpleConfigurationDao#removeConfig(int, java.lang.String)
     */
    @Override
    public boolean removeConfig( int configId, String property )
    {
        LOG.trace( "Method: removeConfig called." );

        SimpleConfiguration simpleConfiguration = (SimpleConfiguration) getCurrentSession().get( SimpleConfiguration.class,
            configId );
        if ( simpleConfiguration.getProperty().equals( property ) ) {
            getCurrentSession().delete( simpleConfiguration );
            return true;
        }
        return false;
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.SimpleConfigurationDao#changeConfig(int, java.lang.String, java.lang.String)
     */
    @Override
    public boolean changeConfig( int configId, String property, String value )
    {
        LOG.trace( "Method: changeConfig called." );

        SimpleConfiguration simpleConfiguration = (SimpleConfiguration) getCurrentSession().get( SimpleConfiguration.class,
            configId );
        if ( simpleConfiguration.getProperty().equals( property ) ) {
            simpleConfiguration.setValue( value );
            return true;
        }
        return false;
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.SimpleConfigurationDao#deleteAllConfig()
     */
    @Override
    @Transactional
    public void deleteAllConfig()
    {
        LOG.trace( "Method: deleteAllConfig called." );

        getCurrentSession().createQuery( "delete from SIMPLECONFIGURATION " ).executeUpdate();
        LOG.trace( "Method: deleteAllConfig finished." );
    }


}
