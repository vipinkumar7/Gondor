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

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author Vipin Kumar
 * @created 08-Aug-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Controller
public class ExceptionHandlingController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ExceptionHandlingController.class );


    @ResponseStatus ( value = HttpStatus.NOT_FOUND, reason = "entity not found")
    public void entityNotFound()
    {
        LOG.error( "Entity not found" );

    }
}
