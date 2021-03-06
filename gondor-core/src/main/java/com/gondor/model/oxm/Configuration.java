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
@XmlRootElement ( name = "configuration")
public class Configuration implements Serializable
{

    /**
     * Serial Version UID
     */
    private static final long serialVersionUID = -3276825800562169877L;


    @XmlElement ( name = "property")
    private Property[] property;


    /**
     * @return the property
     */
    public Property[] getProperty()
    {
        return property;
    }


    /**
     * @param property the property to set
     */
    public void setProperty( Property[] property )
    {
        this.property = property;
    }


}
