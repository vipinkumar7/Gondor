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
package com.gondor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gondor.model.orm.Bundle;
import com.gondor.services.DeploymentManager;


/**
 * @author Vipin Kumar
 * @created 25-Aug-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Controller
@RequestMapping ( value = "/gondor/deploy")
public class DeploymentController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( DeploymentController.class );


    private DeploymentManager deploymentManager;


    @RequestMapping ( value = "/{hostId}", method = RequestMethod.POST)
    public boolean deploy( @PathVariable Integer hostID, @RequestBody Bundle bundle )
    {
        LOG.trace( "Method: deploy called." );
        return deploymentManager.deploy( hostID, bundle );
    }

}
