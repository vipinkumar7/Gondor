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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gondor.dao.UserDao;
import com.gondor.model.orm.User;
import com.gondor.services.UserManager;


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
    private UserManager usermanager;


    /**
     * 
     * @return
     */
    @RequestMapping ( value = "/rest/users", method = { RequestMethod.GET })
    public @ResponseBody List<User> getAllUsers()
    {
        List<User> listUsers = usermanager.list();
        return listUsers;
    }


    @RequestMapping ( value = "/delete/{userId}", method = RequestMethod.GET)
    public void deleteUser( @PathVariable int userId )
    {
        usermanager.delete( userId );
    }


    @RequestMapping ( value = "/saveone", method = RequestMethod.POST)
    public HttpStatus saveUsers( @RequestBody User user )
    {
        usermanager.saveOrUpdate( user );
        return HttpStatus.OK;
    }


    @RequestMapping ( value = "/get/{userId}", method = RequestMethod.GET)
    public @ResponseBody User getUser( @PathVariable int userId )
    {
        return usermanager.get( userId );
    }


}
