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
package com.gondor.model.oxm;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Vipin Kumar
 * @created 09-Jul-2015
 *
 * TODO: Write a quick description of what the class is supposed to do.
 *
 */
@XmlRootElement ( name = "property")
public class Property implements Serializable
{

    /**
     *Serial Version UID
     */
    private static final long serialVersionUID = 1540313373330934649L;

    @XmlElement ( name = "name", required = true)
    private String name;
    @XmlElement ( name = "value", required = true)
    private String value;

    @XmlElement ( name = "description", required = false)
    private String description;


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
     * @return the value
     */
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
     * @return the description
     */
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
}
