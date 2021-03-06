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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Vipin Kumar
 * @created 23-Jun-2015
 * 
 * Host (single machine)
 * 
 */

@Entity
@Table ( name = "HOSTS")
public class Host
{

    private int id;
    private String name;
    private String ip;

    private boolean isActive;


    private Set<Service> services;

    private Cluster cluster;


    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column ( name = "HOST_ID")
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
    @Column ( name = "HOST_NAME", unique = true, nullable = false)
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
     * @return the cluster
     */
    @ManyToOne
    @JoinColumn ( name = "CLUSTER_ID")
    public Cluster getCluster()
    {
        return cluster;
    }


    /**
     * @param cluster the cluster to set
     */
    public void setCluster( Cluster cluster )
    {
        this.cluster = cluster;
    }


    /**
     * @return the ip
     */
    @Column ( name = "HOST_IP")
    public String getIp()
    {
        return ip;
    }


    /**
     * @param ip the ip to set
     */
    public void setIp( String ip )
    {
        this.ip = ip;
    }


    /**
     * @return the isActive
     */
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


    /**
     * @return the services
     */
    @OneToMany ( fetch = FetchType.LAZY)
    @JoinColumn ( name = "SERVICE_ID")
    public Set<Service> getServices()
    {
        return services;
    }


    /**
     * @param services the services to set
     */
    public void setServices( Set<Service> services )
    {
        this.services = services;
    }


}
