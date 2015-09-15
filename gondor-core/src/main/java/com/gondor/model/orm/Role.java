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
 *          TODO: Write a quick description of what the class is supposed to do.
 */

@Entity
@Table ( name = "ROLES")
public class Role
{

    /**
     * 
     */

    private int id;
    @Enumerated ( EnumType.STRING)
    private RoleType type;


    @Id
    @GeneratedValue
    @Column ( name = "ROLE_ID")
    public int getId()
    {
        return id;
    }


    public void setId( int id )
    {
        this.id = id;
    }


    /**
     * @return the type
     */
    @Column ( name = "ROLE_NAME")
    public RoleType getType()
    {
        return type;
    }


    /**
     * @param type the type to set
     */
    public void setType( RoleType type )
    {
        this.type = type;
    }

}
