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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gondor.dao.BaseConfigurationDao;
import com.gondor.model.orm.CoreSite;


/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 *
 * TODO: Write a quick description of what the class is supposed to do.
 *
 */
public class CoreSiteDAOImpl extends BaseDAOImpl implements BaseConfigurationDao<CoreSite>
{

    /**
     * @param sessionFactory
     */
    @Autowired
    public CoreSiteDAOImpl( SessionFactory sessionFactory )
    {
        super( sessionFactory );
    }


    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( CoreSiteDAOImpl.class );


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#getConf()
     */
    @Override
    public List<CoreSite> getAllConf()
    {
        LOG.trace( "Method: getConf called." );
        @SuppressWarnings ( "unchecked") List<CoreSite> coreSiteConfig = getCurrentSession().createCriteria( CoreSite.class )
            .setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).list();

        return coreSiteConfig;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#changeConfig(int, java.lang.String, java.lang.String)
     */
    @Override
    public boolean changeConfig( int baseConfigId, String property, String value )
    {
        LOG.trace( "Method: changeConfig called." );
        String hql = "from CoreSite where id= " + baseConfigId;
        Query query = getCurrentSession().createQuery( hql );
        @SuppressWarnings ( "unchecked") List<CoreSite> lcoreSites = query.list();
        if ( lcoreSites != null && !lcoreSites.isEmpty() ) {
            CoreSite obj = lcoreSites.get( 0 );
            if ( obj.getProperty().equals( property ) )
                obj.setValue( value );
        }
        getCurrentSession().saveOrUpdate( lcoreSites.get( 0 ) );
        return true;


    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#removeConfig(int, java.lang.String)
     */
    @Override
    public boolean removeConfig( int baseConfigId, String property )
    {
        LOG.trace( "Method: removeConfig called." );

        CoreSite coreSite = new CoreSite();
        coreSite.setId( baseConfigId );
        getCurrentSession().delete( coreSite );
        return true;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#saveConfigs(com.gondor.model.orm.BaseConfiguration)
     */
    @Override
    public void saveConfigs( List<CoreSite> configs )
    {
        LOG.trace( "Method: saveConfigs called." );
        for ( CoreSite config : configs ) {
            getCurrentSession().saveOrUpdate( config );
        }
        LOG.trace( "Method: saveConfigs finished." );
    }


    @Override
    public void deleteAllConfig()
    {
        LOG.trace( "Method: deleteAllConfig called." );


        LOG.trace( "Method: deleteAllConfig finished." );
    }


}
