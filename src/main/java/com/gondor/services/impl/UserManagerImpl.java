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

import com.gondor.dao.UserDao;
import com.gondor.model.User;
import com.gondor.services.UserManager;


/**
 * @author Vipin Kumar
 * @created 25-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Service("userManager")
public class UserManagerImpl implements UserManager
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( UserManagerImpl.class );

    @Autowired
    private UserDao userDao;


    /* (non-Javadoc)
     * @see com.gondor.services.UserManager#list()
     */
    @Override
    public List<User> list()
    {
        LOG.trace( "Method: list called." );

        return userDao.list();

    }


    /* (non-Javadoc)
     * @see com.gondor.services.UserManager#get(int)
     */
    @Override
    public User get( int userId )
    {
        LOG.trace( "Method: get called." );

        return userDao.get( userId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.UserManager#delete(int)
     */
    @Override
    public void delete( int userId )
    {
        LOG.trace( "Method: delete called." );
        userDao.delete( userId );
        LOG.trace( "Method: delete finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.UserManager#changeRole(int, int)
     */
    @Override
    public void changeRole( int userId, int roleId )
    {
        LOG.trace( "Method: changeRole called." );
        userDao.changeRole( userId, roleId );

        LOG.trace( "Method: changeRole finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.UserManager#hasRole(int, int)
     */
    @Override
    public boolean hasRole( int userId, int roleId )
    {
        LOG.trace("Method: hasRole called.");
        
        return false;
        
    }

}
