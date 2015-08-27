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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gondor.model.orm.SimpleConfiguration;
import com.gondor.services.ConfigurationManager;


/**
 * @author Vipin Kumar
 * @created 25-Aug-2015
 * 
 * Controller responsible for all the configuration related tasks
 * 
 */
@Controller
@RequestMapping ( value = "/gondor/config")
public class ConfigurationController
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ConfigurationController.class );

    @Autowired
    private ConfigurationManager configManager;


    /**
     * 
     * @param simpleConfig
     * @return
     */
    @RequestMapping ( value = "/change", method = RequestMethod.POST)
    public ResponseEntity<String> changeConfig( @RequestBody SimpleConfiguration simpleConfig )
    {
        LOG.trace( "Method: changeConfig called." );
        configManager.updateConfig( simpleConfig );
        return new ResponseEntity<String>( "configuration changed Successfully", HttpStatus.OK );
    }


    /**
     * 
     * @param simpleConfig
     * @return
     */
    @RequestMapping ( value = "/change/list", method = RequestMethod.POST)
    public ResponseEntity<String> changeConfigList( @RequestBody List<SimpleConfiguration> simpleConfig )
    {
        LOG.trace( "Method: changeConfig called." );

        return new ResponseEntity<String>( "all configuration changed Successfully", HttpStatus.OK );

    }


}
