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
package com.gondor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vipin Kumar
 * @created 23-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Entity
@Table(name="RESOURCES")
public class Resource implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -8644773993023277569L;

    private int id;
    
    private String name;
    
    @Enumerated(EnumType.STRING)
    private ResourceType type;
    /**
     * @return the id
     */
    
    @Id
    @GeneratedValue
    @Column(name = "RESOURCE_ID")
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
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName( String name )
    {
        this.name = name;
    }

    /**
     * @return the type
     */
    public ResourceType getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType( ResourceType type )
    {
        this.type = type;
    }
}
