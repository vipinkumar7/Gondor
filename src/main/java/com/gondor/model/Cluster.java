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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Entity
@Table(name="CLUSTERS")
public class Cluster  implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    
    
    @OneToMany
    @JoinColumn(name="HOST_ID")
    private Hosts host;

    
    /**
     * each user is responsible for a cluster management 
     * 
     * ADMIN all Privileges(Start ,Stop ,Change)
     * USER  only viewer
     * Controller (only change)
     *  
     */
    @OneToMany
    @JoinColumn(name="USER_ID")
    private User user;
    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column(name = "CLUSTER_ID")
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
     * @return the host
     */
    public Hosts getHost()
    {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost( Hosts host )
    {
        this.host = host;
    }

    /**
     * @return the user
     */
    public User getUser()
    {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser( User user )
    {
        this.user = user;
    }

}
