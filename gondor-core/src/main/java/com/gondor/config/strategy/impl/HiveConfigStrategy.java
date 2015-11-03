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
package com.gondor.config.strategy.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gondor.config.strategy.ConfigurationStrategy;
import com.gondor.model.config.ConfigurationRequest;
import com.gondor.model.orm.SimpleConfiguration;


/**
 * @author Vipin Kumar
 * @created 17-Sep-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Component ( "hiveConfigStrategy")
public class HiveConfigStrategy implements ConfigurationStrategy
{
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HiveConfigStrategy.class );


    /* (non-Javadoc)
     * @see com.gondor.config.strategy.ConfigurationStrategy#init()
     */
    @Override
    public void init()
    {
        LOG.trace( "Method: init called." );


        LOG.trace( "Method: init finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.config.strategy.ConfigurationStrategy#buildConfigurationFiles()
     */
    @Override
    public List<ConfigurationRequest> buildConfigurationFiles()
    {
        LOG.trace( "Method: buildConfigurationFiles called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.config.strategy.ConfigurationStrategy#loadConfigurations()
     */
    @Override
    public List<SimpleConfiguration> loadConfigurations()
    {
        LOG.trace( "Method: loadConfigurations called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.config.strategy.ConfigurationStrategy#clear()
     */
    @Override
    public void clear()
    {
        LOG.trace( "Method: clear called." );


        LOG.trace( "Method: clear finished." );
    }

}
