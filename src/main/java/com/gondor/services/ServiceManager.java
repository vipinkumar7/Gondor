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

import java.util.Set;

import com.gondor.model.orm.BaseConfiguration;
import com.gondor.model.orm.ServiceType;


/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public interface ServiceManager
{

    public void startService( ServiceType serviceType );


    public void stopService( ServiceType serviceType );


    public void restartService( ServiceType serviceType );


    public void checkService( ServiceType serviceType );


    public Set<BaseConfiguration> getAllServiceconfig( ServiceType serviceType );


    public String getServiceConfig( String property, String value, Class<? extends BaseConfiguration> configObject );


    public boolean changeConfiguration( ServiceType serviceType, String property, String value,
        Class<? extends BaseConfiguration> configObject );
}
