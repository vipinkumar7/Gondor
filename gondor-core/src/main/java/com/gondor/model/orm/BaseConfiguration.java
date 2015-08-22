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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


/**
 * @author Vipin Kumar
 * @created 22-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@MappedSuperclass
@Inheritance ( strategy = InheritanceType.JOINED)
public abstract class BaseConfiguration implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 5487484778854686415L;


    private int id;
    private String property;
    private String value;
    private String description;


    @Id
    @GeneratedValue
    @Column ( name = "CONF_ID")
    public int getId()
    {
        return id;
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
     * 
     * @param id
     */
    public void setId( int id )
    {
        this.id = id;
    }


    /**
     * @param value the value to set
     */
    public void setValue( String value )
    {
        this.value = value;
    }


    /**
     * @return the description
     */
    @Column ( name = "DESCRIPTION", nullable = true, columnDefinition = "varchar(1000)")
    public String getDescription()
    {
        return description;
    }


    /**
     * @param description the description to set
     */
    public void setDescription( String description )
    {
        this.description = description;
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

}
