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
package com.gondor.model.orm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Entity
@Table ( name = "SERVICES")
public class Service
{


    /**
     * 
     */
    private int id;

    @Type ( type = "numeric_boolean")
    private boolean isRunning;

    @Enumerated ( EnumType.STRING)
    private ServiceType name;


    private Host host;

    private Set<InstanceConfiguration> instanceConfigs;


    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column ( name = "SERVICE_ID")
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
     * @return the host
     */
    @ManyToOne
    @JoinColumn ( name = "HOST_ID")
    public Host getHost()
    {
        return host;
    }


    /**
     * @param host the host to set
     */
    public void setHost( Host host )
    {
        this.host = host;
    }


    /**
     * @return the name
     */
    /**
     * @return the name
     */
    @Column ( name = "SERVICE_NAME")
    public ServiceType getName()
    {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName( ServiceType name )
    {
        this.name = name;
    }


    /**
     * @return the isRunning
     */
    @Column ( name = "STATE")
    public boolean isRunning()
    {
        return isRunning;
    }


    /**
     * @param isRunning the isRunning to set
     */
    public void setRunning( boolean isRunning )
    {
        this.isRunning = isRunning;
    }


    /**
     * @return the instanceConfigs
     */
    @OneToMany ( fetch = FetchType.LAZY)
    @JoinColumn ( name = "INSTANCE_CONF_ID")
    public Set<InstanceConfiguration> getInstanceConfigs()
    {
        return instanceConfigs;
    }


    /**
     * @param instanceConfigs the instanceConfigs to set
     */
    public void setInstanceConfigs( Set<InstanceConfiguration> instanceConfigs )
    {
        this.instanceConfigs = instanceConfigs;
    }


}
