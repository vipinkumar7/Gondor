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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@ApiModel ( "Cluster")
@Entity
@Table ( name = "CLUSTERS")
public class Cluster
{
    /**
     * 
     */

    private Integer id;

    private String name;
    private boolean isActive;


    private Set<Host> hosts;


    /**
     * 
     */
    public Cluster()
    {
        super();
    }


    /**
     * @return the id
     */
    @JsonIgnore
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "CLUSTER_ID")
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
     * @return the name
     */
    @ApiModelProperty ( position = 1, required = true, dataType = "String")
    @Column ( name = "CLUSTER_NAME", unique = true, nullable = false)
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
     * @return the hosts
     */
    @JsonIgnore
    @OneToMany ( fetch = FetchType.LAZY)
    @JoinColumn ( name = "HOST_ID")
    public Set<Host> getHosts()
    {
        return hosts;
    }


    /**
     * @param hosts the hosts to set
     */
    public void setHosts( Set<Host> hosts )
    {
        this.hosts = hosts;
    }


    /**
     * @return the isActive
     */
    @ApiModelProperty ( position = 2, required = false)
    @Column ( name = "IS_ACTIVE")
    public boolean isActive()
    {
        return isActive;
    }


    /**
     * @param isActive the isActive to set
     */
    public void setActive( boolean isActive )
    {
        this.isActive = isActive;
    }


}
