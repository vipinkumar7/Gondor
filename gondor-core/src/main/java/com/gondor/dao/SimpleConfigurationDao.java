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
package com.gondor.dao;

import java.util.List;

import com.gondor.model.orm.SimpleConfiguration;


/**
 * @author Vipin Kumar
 * @created 22-Jun-2015
 *
 * This is configuration DAO for saving all configuration
 *
 */
public interface SimpleConfigurationDao
{


    /**
     * update this configuration
     * @param simpleConfiguration
     * @return
     */
    public boolean updateConfig( SimpleConfiguration simpleConfiguration );


    /**
     * update these configuration  
     * @param simpleConfigurations
     * @return
     */
    public boolean updateConfig( List<SimpleConfiguration> simpleConfigurations );


    /**
     *
     * @param baseConfigId
     * @param configName
     * @return
     */
    public boolean removeConfig( SimpleConfiguration simpleConfiguration );


    /**
     * @param configList
     * @return
     * Method to save list of configurations
     */
    public void saveConfigs( List<SimpleConfiguration> config );


    public void deleteAllConfig();
}
