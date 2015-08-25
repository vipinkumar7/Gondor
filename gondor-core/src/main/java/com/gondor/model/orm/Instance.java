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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Vipin Kumar
 * @created 25-Aug-2015
 * 
 * <p>
 * Instances can be  child of service or another instance of it running on another host
 * 
 * eg. DATANAODE is instance of HDFS service and its child also and it can have mode than one instance 
 * running on cluster  
 * </p>
 */
@Entity
@Table ( name = "INSTANCE")
public class Instance implements Serializable
{


    /**
     * 
     */
    private static final long serialVersionUID = 7745270069870881802L;
    private int id;
    private ServiceType name;

    @ManyToOne
    @JoinColumn ( name = "SERVICE_ID")
    private Service service;


    /**
     * @return the name
     */
    @Column ( name = "INSTANCE_NAME")
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
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column ( name = "INSTANCE_ID")
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
     * @return the service
     */
    @Column ( name = "SERVICE_ID")
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
