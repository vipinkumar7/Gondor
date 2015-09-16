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
package com.gondor.services;

import java.util.List;

import com.gondor.model.orm.SimpleConfiguration;


/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public interface ConfigurationManager
{


    /**
    *
    * @param baseConfigId
    * @param configName
    * @return
    *
    * change the  configuration  of given name in the Configuration file
    */
    public Integer updateConfig( SimpleConfiguration simpleConfiguration );


    /**
     * update these configuration  
     * @param simpleConfigurations
     * @return
     */
    public void updateConfig( List<SimpleConfiguration> simpleConfigurations );


    /**
     *
     * @param baseConfigId
     * @param configName
     * @return
     */
    public void removeConfig( SimpleConfiguration simpleConfiguration );


    /**
     * @param configList
     * @return
     * Method to save list of configurations
     */
    public void saveConfigs( List<SimpleConfiguration> config );


}
