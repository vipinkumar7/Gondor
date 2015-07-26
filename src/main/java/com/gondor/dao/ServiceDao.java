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

import java.util.Set;

import com.gondor.model.orm.BaseConfiguration;
import com.gondor.model.orm.ServiceType;


/**
 * @author Vipin Kumar
 * @created 25-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public interface ServiceDao
{


    /**
     * 
     * @param serviceid
     * @return
     * Check the status for all the Instances running under this service
     */
    public String getStatus( Integer serviceid );


    /**
     * 
     * @param serviceType
     * <p>
     * Start the service of particular type
     * </p>
     */
    public Integer startService( ServiceType serviceType );


    public void stopService( Integer serviceid );


    public void checkService( Integer serviceid );


    /**
     * 
     * @param serviceid
     * @return
     * 
     * <p>Return all the configuration belongs to this Service</p>
     */
    public Set<BaseConfiguration> getAllServiceconfig( Integer serviceid );


    /**
     * 
     * @param serviceid
     * @param configObject
     * @return
     * <p>Change the particular service configuration object </p>
     */
    public boolean changeConfiguration( Integer serviceid, BaseConfiguration configObject );


}