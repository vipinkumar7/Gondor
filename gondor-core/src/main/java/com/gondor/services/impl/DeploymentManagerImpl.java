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
import com.gondor.model.orm.PackageType;
import com.gondor.services.DeploymentManager;


/**
 * @author Vipin Kumar
 * @created 10-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class DeploymentManagerImpl implements DeploymentManager
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( DeploymentManagerImpl.class );


    /* (non-Javadoc)
     * @see com.gondor.services.DeploymentManager#getHeartbeat(int)
     */
    @Override
    public boolean getHeartbeat( int hostId )
    {
        LOG.trace( "Method: getHeartbeat called." );

        return false;

    }


    /* (non-Javadoc)
     * @see com.gondor.services.DeploymentManager#deploy(int, com.gondor.model.orm.PackageType)
     */
    @Override
    public boolean deploy( int hostID, PackageType packageType )
    {
        LOG.trace( "Method: deploy called." );

        return false;

    }


    /* (non-Javadoc)
     * @see com.gondor.services.DeploymentManager#applyChangedConfig(int, com.gondor.model.orm.BaseConfiguration, java.lang.Class)
     */
    @Override
    public void applyChangedConfig( int clusterId, SimpleConfiguration baseConfiguration,
        Class<? extends SimpleConfiguration> configObject )
    {
        LOG.trace( "Method: applyChangedConfig called." );


        LOG.trace( "Method: applyChangedConfig finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.DeploymentManager#applyChangedConfig(int, int, com.gondor.model.orm.BaseConfiguration, java.lang.Class)
     */
    @Override
    public void applyChangedConfig( int clusterId, int hostId, SimpleConfiguration baseConfiguration,
        Class<? extends SimpleConfiguration> configObject )
    {
        LOG.trace( "Method: applyChangedConfig called." );


        LOG.trace( "Method: applyChangedConfig finished." );
    }
}
