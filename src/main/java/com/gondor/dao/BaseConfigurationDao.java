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

import com.gondor.model.orm.BaseConfiguration;


/**
 * @author Vipin Kumar
 * @created 22-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public interface BaseConfigurationDao
{

    /**
     * 
     * @param serviceId
     * @return
     * get all the configuration related to this service id
     */
    public List<BaseConfiguration> list( int serviceId );


    /**
     * 
     * @param baseConfigId
     * @return
     * get the configuration for this config id
     */
    public BaseConfiguration getConfig( int baseConfigId );


    /**
     * 
     * @param baseConfigId
     * @param configName
     * @return
     * 
     * change the  configuration  of given name in the Configuration file 
     */
    public boolean changeConfig( int baseConfigId, String configName );


    /**
     * 
     * @param baseConfigId
     * @param configName
     * @return
     */
    public boolean removeConfig( int baseConfigId, String configName );
}
