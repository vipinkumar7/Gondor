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
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gondor.dao.BaseConfigurationDao;
import com.gondor.model.orm.BaseConfiguration;
import com.gondor.model.orm.HdfsSite;


/**
 * @author Vipin Kumar
 * @created 22-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class HdfsSiteDAOImpl implements BaseConfigurationDao
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HdfsSiteDAOImpl.class );


    @Autowired
    private SessionFactory sessionFactory;


    public HdfsSiteDAOImpl()
    {

    }


    public HdfsSiteDAOImpl( SessionFactory sessionFactory )
    {
        this.sessionFactory = sessionFactory;
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.PropertiesDao#list()
     */
    @Override
    @Transactional
    public List<BaseConfiguration> list( int baseConfigId )
    {
        LOG.trace( "Method: list called." );
        @SuppressWarnings ( "unchecked") List<BaseConfiguration> listpro = (List<BaseConfiguration>) sessionFactory
            .getCurrentSession().createCriteria( HdfsSite.class ).setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).list();

        return listpro;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#getConfig(int)
     */
    @Override
    public BaseConfiguration getConfig( int baseConfigId )
    {
        LOG.trace( "Method: getConfig called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#changeConfig(int, java.lang.String)
     */
    @Override
    public boolean changeConfig( int baseConfigId, String configName )
    {
        LOG.trace( "Method: changeConfig called." );

        return false;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.BaseConfigurationDao#removeConfig(int, java.lang.String)
     */
    @Override
    public boolean removeConfig( int baseConfigId, String configName )
    {
        LOG.trace( "Method: removeConfig called." );

        return false;

    }


}
