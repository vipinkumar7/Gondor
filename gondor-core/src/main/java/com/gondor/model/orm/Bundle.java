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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Vipin Kumar
 * @created 10-Jul-2015
 * 
 * <p>
 * This class Represents  the different application to be deployed in cluster 
 * (generally tar balls binary files)  
 * either Url should be defined for downloading application or localPath from where to copy  
 * </p>
 */

@Entity
@Table ( name = "BUNDLE")
public class Bundle implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 3960950866242237876L;

    private String name;

    private int id;

    private String localPath;

    private String url;


    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column ( name = "BUNDLE_ID")
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
     * @return the localPath
     */
    @Column ( name = "LOCAL_PATH")
    public String getLocalPath()
    {
        return localPath;
    }


    /**
     * @param localPath the localPath to set
     */
    public void setLocalPath( String localPath )
    {
        this.localPath = localPath;
    }


    /**
     * @return the url
     */
    @Column ( name = "URL")
    public String getUrl()
    {
        return url;
    }


    /**
     * @param url the url to set
     */
    public void setUrl( String url )
    {
        this.url = url;
    }


    /**
     * @return the name
     */
    @Column ( name = "BUNDLE_NAME")
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


}
