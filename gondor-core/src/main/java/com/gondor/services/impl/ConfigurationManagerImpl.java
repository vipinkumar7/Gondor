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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gondor.model.orm.SimpleConfiguration;
import com.gondor.repository.SimpleConfRepository;
import com.gondor.services.ConfigurationManager;


/**
 * @author Vipin Kumar
 * @created 10-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Service ( "configManager")
public class ConfigurationManagerImpl implements ConfigurationManager
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ConfigurationManagerImpl.class );

    @Autowired
    private SimpleConfRepository simpleConfRepository;


    /* (non-Javadoc)
     * @see com.gondor.services.ConfigurationManager#removeConfig(int, java.lang.String)
     */
    @Override
    public void removeConfig( SimpleConfiguration simpleConfiguration )
    {
        LOG.trace( "Method: removeConfig called." );

        simpleConfRepository.delete( simpleConfiguration );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ConfigurationManager#saveConfigs(java.util.List)
     */
    @Override
    public void saveConfigs( List<SimpleConfiguration> config )
    {
        LOG.trace( "Method: saveConfigs called." );
        simpleConfRepository.save( config );
        LOG.trace( "Method: saveConfigs finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ConfigurationManager#updateConfig(com.gondor.model.orm.SimpleConfiguration)
     */
    @Override
    public Integer updateConfig( SimpleConfiguration simpleConfiguration )
    {
        LOG.trace( "Method: updateConfig called." );
        simpleConfRepository.save( simpleConfiguration );
        return simpleConfiguration.getId();
    }


    /* (non-Javadoc)
     * @see com.gondor.services.ConfigurationManager#updateConfig(java.util.List)
     */
    @Override
    public void updateConfig( List<SimpleConfiguration> simpleConfigurations )
    {
        LOG.trace( "Method: updateConfig called." );

        simpleConfRepository.save( simpleConfigurations );
    }


}
