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
package com.gondor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gondor.dao.UserDao;
import com.gondor.model.orm.User;


/**
 *
 * @author Vipin Kumar
 * @created 22-Jun-2015
 *
 * TODO: Write a quick description of what the class is supposed to do.
 *
 */
@Controller
public class AdminController
{

    @Autowired
    private UserDao userDao;


    @RequestMapping ( value = "/rest/users", method = RequestMethod.GET)
    public @ResponseBody User getDummyEmployee()
    {
        List<User> listUsers = userDao.list();
        return listUsers.get( 0 );
    }


    @RequestMapping ( "/")
    public ModelAndView handleRequest() throws Exception
    {
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView( "UserList" );
        model.addObject( "userList", listUsers );
        return model;
    }


    @RequestMapping ( value = "/new", method = RequestMethod.GET)
    public ModelAndView newUser()
    {
        ModelAndView model = new ModelAndView( "UserForm" );
        model.addObject( "user", new User() );
        return model;
    }


    @RequestMapping ( value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser( HttpServletRequest request )
    {
        int userId = Integer.parseInt( request.getParameter( "id" ) );
        User user = userDao.get( userId );
        ModelAndView model = new ModelAndView( "UserForm" );
        model.addObject( "user", user );
        return model;
    }


    @RequestMapping ( value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser( HttpServletRequest request )
    {
        int userId = Integer.parseInt( request.getParameter( "id" ) );
        userDao.delete( userId );
        return new ModelAndView( "redirect:/" );
    }


    @RequestMapping ( value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUser( @ModelAttribute User user )
    {
        userDao.saveOrUpdate( user );
        return new ModelAndView( "redirect:/" );
    }


    @RequestMapping ( value = "/saveone", method = RequestMethod.POST)
    public HttpStatus saveUsers( @RequestBody User user )
    {
        userDao.saveOrUpdate( user );
        return HttpStatus.OK;
    }


    @RequestMapping ( value = "/get", method = RequestMethod.GET)
    public @ResponseBody User getUser()
    {
        return userDao.get( 1 );
    }


}
