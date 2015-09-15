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
package com.gondor.model.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Entity
@Table ( name = "PROCESSES")
public class Process
{

    /**
     * 
     */


    private int id;
    private int systemPid;


    private Service service;


    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column ( name = "PROCESS_ID")
    public int getId()
    {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId( int id )
    {
        this.id = id;
    }


    /**
     * @return the systemPid
     */
    @Column ( name = "SYSTEM_PID")
    public int getSystemPid()
    {
        return systemPid;
    }


    /**
     * @param systemPid the systemPid to set
     */
    public void setSystemPid( int systemPid )
    {
        this.systemPid = systemPid;
    }


    /**
     * @return the service
     */
    @ManyToOne
    @JoinColumn ( name = "SERVICE_ID")
    public Service getService()
    {
        return service;
    }


    /**
     * @param service the service to set
     */
    public void setService( Service service )
    {
        this.service = service;
    }


}
