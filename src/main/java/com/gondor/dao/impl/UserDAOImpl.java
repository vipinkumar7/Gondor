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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gondor.dao.UserDao;
import com.gondor.model.User;


/**
 * @author Vipin Kumar
 * @created 22-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Repository
public class UserDAOImpl implements UserDao
{


    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( UserDAOImpl.class );

    @Autowired
    private SessionFactory sessionFactory;


    public UserDAOImpl()
    {

    }


    public UserDAOImpl( SessionFactory sessionFactory )
    {

        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public List<User> list()
    {
        @SuppressWarnings ( "unchecked") List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
            .createCriteria( User.class ).setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).list();

        return listUser;
    }


    @Transactional
    public void saveOrUpdate( User user )
    {
        sessionFactory.getCurrentSession().saveOrUpdate( user );
    }


    @Transactional
    public void delete( int id )
    {
        User userToDelete = new User();
        userToDelete.setId( id );
        sessionFactory.getCurrentSession().delete( userToDelete );
    }


    @Transactional
    public User get( int id )
    {
        LOG.debug( "searching user id ="+id );
        String hql = "from User where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery( hql );

        @SuppressWarnings ( "unchecked") List<User> listUser = (List<User>) query.list();

        if ( listUser != null && !listUser.isEmpty() ) {
            return listUser.get( 0 );
        }

        return null;
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.UserDao#changeRole(int, int)
     */
    @Override
    public void changeRole( int id, int roleId )
    {
        LOG.trace("Method: changeRole called.");
        
        
        LOG.trace("Method: changeRole finished.");
    }

}
