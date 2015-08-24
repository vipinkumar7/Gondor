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
package com.gondor.exceptions;

/**
 * @author Vipin Kumar
 * @created 08-Aug-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class EntityNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = -8980839607048059094L;


    private String errorMessage;


    /**
     * 
     */
    public EntityNotFoundException( String errorMessage )
    {
        this.errorMessage = errorMessage;
    }


    /**
     * 
     */


    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return errorMessage;
    }


    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage( String errorMessage )
    {
        this.errorMessage = errorMessage;
    }


}
