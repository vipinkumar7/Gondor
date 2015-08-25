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
package com.gondor.dao;

import java.util.List;

import com.gondor.model.orm.Instance;
import com.gondor.model.orm.ServiceType;
import com.gondor.model.orm.SimpleConfiguration;


/**
 * @author Vipin Kumar
 * @created 25-Aug-2015
 * 
 * <p>
 * An Instance is the smallest part of service which can't be divided further in any processes
 * It can be assumed as a child process
 * </p>
 */
public interface InstanceDao
{


    /**
     * 
     * @param instanceId
     * @return
     * Check the status for all the Instances running under this service and this service
     */
    public String getStatus( Integer instanceId );


    /**
     * Get Instance Type on id
     * @param instanceId
     * @return
     */
    public ServiceType getInstanceType( Integer instanceId );


    /**
     * 
     * @param serviceType
     * @param hostId
     * <p>check if particular service exists   on host</p>
     */
    public Instance getInstanceIfExists( ServiceType serviceType, Integer serviceId );


    /**
     * 
     * @param instanceId
     * <p>check the state of instance</p>
     */
    public Instance getInstanceIfExists( Integer instanceId );


    /**
     * check state of instance
     * @param instanceId
     * @return
     */
    public boolean checkState( Integer instanceId );


    /**
     * 
     * @param instanceId
     * @return
     */
    public List<SimpleConfiguration> getAllConfig( int instanceId );


    /**
     * 
     * @param serviceType
     * @param hostId
     * @return
     * 
     * <p>
     * Start the instance of particular type
     *</p>
     */
    public void startInstance( Integer instanceId );


    /**
     * Stop the instance with this ID
     * @param serviceid
     */
    public void stopInstance( Integer instanceId );


    /**
     * 
     * @param serviceType
     * <p>
     * create the instance of particular type
     * </p>
     */
    public Integer createNewInstance( ServiceType serviceType, Integer serviceId );


}
