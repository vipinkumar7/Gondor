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

import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * @author Vipin Kumar
 * @created 24-Aug-2015
 * 
 * Base class for DAO implementation
 * 
 */
public abstract class BaseDAOImpl
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( BaseDAOImpl.class );

    private SessionFactory sessionFactory;


    /**
     * 
     */

    public BaseDAOImpl( SessionFactory sessionFactory )
    {
        this.sessionFactory = sessionFactory;
    }


    /**
     * 
     */
    protected Session getCurrentSession()
    {
        LOG.trace( "Method: getCurrentSession called." );
        return sessionFactory.getCurrentSession();
    }

}
