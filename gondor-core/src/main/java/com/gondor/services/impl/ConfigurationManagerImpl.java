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
package com.gondor.services.impl;

import com.gondor.model.orm.SimpleConfiguration;
import com.gondor.services.ConfigurationManager;


/**
 * @author Vipin Kumar
 * @created 10-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class ConfigurationManagerImpl implements ConfigurationManager
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ConfigurationManagerImpl.class );


    /* (non-Javadoc)
     * @see com.gondor.services.ConfigurationManager#changeConfiguration(java.lang.String, java.lang.String, java.lang.Class)
     */
    @Override
    public void changeConfiguration( String property, String value, Class<? extends SimpleConfiguration> configObject )
    {
        LOG.trace( "Method: changeConfiguration called." );


        LOG.trace( "Method: changeConfiguration finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ConfigurationManager#changeConfiguration(com.gondor.model.orm.BaseConfiguration, java.lang.Class)
     */
    @Override
    public void changeConfiguration( SimpleConfiguration baseObj, Class<? extends SimpleConfiguration> configObject )
    {
        LOG.trace( "Method: changeConfiguration called." );


        LOG.trace( "Method: changeConfiguration finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ConfigurationManager#validateConfiguration(com.gondor.model.orm.BaseConfiguration, java.lang.Class)
     */
    @Override
    public void validateConfiguration( SimpleConfiguration baseObj, Class<? extends SimpleConfiguration> configObject )
    {
        LOG.trace( "Method: validateConfiguration called." );


        LOG.trace( "Method: validateConfiguration finished." );
    }
}
