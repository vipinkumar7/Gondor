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

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gondor.dao.SimpleConfigurationDao;
import com.gondor.model.orm.SimpleConfiguration;
import com.gondor.model.orm.ServiceType;


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

    /**
     * @param sessionFactory
     */
    @Autowired
    public ConfigurationDAOImpl( SessionFactory sessionFactory )
    {
        super( sessionFactory );
    }


    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ConfigurationDAOImpl.class );


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#getConf()
     */
    @Override
    public List<SimpleConfiguration> getAllConf( ServiceType serviceType )
    {
        LOG.trace( "Method: getConf called." );
        @SuppressWarnings ( "unchecked") List<SimpleConfiguration> hdfsSiteConfig = getCurrentSession()
            .createCriteria( SimpleConfiguration.class ).setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).list();

        return hdfsSiteConfig;


    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#changeConfig(int, java.lang.String)
     */
    @Override
    public boolean changeConfig( int baseConfigId, String property, String value )
    {
        LOG.trace( "Method: changeConfig called." );

        String hql = "from HdfsSite where id= " + baseConfigId;
        Query query = getCurrentSession().createQuery( hql );
        @SuppressWarnings ( "unchecked") List<SimpleConfiguration> lHdfsSites = query.list();
        if ( lHdfsSites != null && !lHdfsSites.isEmpty() ) {
            SimpleConfiguration obj = lHdfsSites.get( 0 );
            if ( obj.getProperty().equals( property ) )
                obj.setValue( value );
        }
        getCurrentSession().saveOrUpdate( lHdfsSites.get( 0 ) );
        return true;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#removeConfig(int, java.lang.String)
     */
    @Override
    public boolean removeConfig( int baseConfigId, String property )
    {
        LOG.trace( "Method: removeConfig called." );

        //TODO has to check for property
        SimpleConfiguration hdfsSite = new SimpleConfiguration();
        hdfsSite.setId( baseConfigId );
        getCurrentSession().delete( hdfsSite );
        return true;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#saveConfigs(com.gondor.model.orm.BaseConfiguration)
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


    @Override
    @Transactional
    public void deleteAllConfig()
    {
        LOG.trace( "Method: deleteConfig called." );

        getCurrentSession().createQuery( "delete from HdfsSite" ).executeUpdate();

        LOG.trace( "Method: deleteConfig finished." );
    }


}
