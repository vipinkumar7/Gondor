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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Vipin Kumar
 * @created 17-Sep-2015
 * 
 * This class is representation of all base service and their associated 
 * child services 
 * 
 */
@Entity
@Table ( name = "SERVICE_TREE")
public class ServiceTree
{

    private Integer id;

    private String serviceType;

    private Integer parent;


    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column ( name = "SERVICE_TREE_ID")
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
     * @return the serviceType
     */
    @Column ( name = "SERVICE_NAME")
    public String getServiceType()
    {
        return serviceType;
    }


    /**
     * @param serviceType the serviceType to set
     */
    public void setServiceType( String serviceType )
    {
        this.serviceType = serviceType;
    }


    /**
     * @return the parent
     */
    @Column ( name = "SERVICE_PARENT_ID")
    public Integer getParent()
    {
        return parent;
    }


    /**
     * @param parent the parent to set
     */
    public void setParent( Integer parent )
    {
        this.parent = parent;
    }


}
