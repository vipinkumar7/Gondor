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
 * @created 16-Sep-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Entity
@Table ( name = "INSTANCE_CONFIGURATION")
public class InstanceConfiguration
{
    private Integer id;
    private String property;
    private String value;

    private ResourceType resourceType;

    private Service service;


    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column ( name = "INSTANCE_CONF_ID")
    public Integer getId()
    {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId( Integer id )
    {
        this.id = id;
    }


    /**
     * @return the property
     */
    @Column ( name = "PROPERTY", columnDefinition = "varchar(1000)")
    public String getProperty()
    {
        return property;
    }


    /**
     * @param property the property to set
     */
    public void setProperty( String property )
    {
        this.property = property;
    }


    /**
     * @return the value
     */
    @Column ( name = "VALUE", columnDefinition = "varchar(1000)")
    public String getValue()
    {
        return value;
    }


    /**
     * @param value the value to set
     */
    public void setValue( String value )
    {
        this.value = value;
    }


    /**
     * @return the resourceType
     */
    @Column ( name = "RESOURCE_TYPE")
    public ResourceType getResourceType()
    {
        return resourceType;
    }


    /**
     * @param resourceType the resourceType to set
     */
    public void setResourceType( ResourceType resourceType )
    {
        this.resourceType = resourceType;
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
