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
package com.gondor.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


/**
 * @author Vipin Kumar
 * @created 21-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Component
public class Hdfs_SiteProperties implements InitializingBean
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( Mapred_SiteProperties.class );

    Map<String, String> config = new HashMap<String, String>();


    /* (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception
    {
        LOG.trace( "Method: afterPropertiesSet called." );

        loadInitialProperties();
        LOG.trace( "Method: afterPropertiesSet finished." );
    }


    private void loadInitialProperties()
    {
        config.put( "dfs.namenode.name.dir", "/data/dfs/name" );
        config.put( "dfs.namenode.handler.count", "200" );
        config.put( "dfs.webhdfs.enabled", "true" );
        config.put( "dfs.https.address", "0.0.0.0:50470" );
        config.put( "dfs.https.port", "50470" );
        config.put( "dfs.namenode.http-address", "0.0.0.0:50070" );
        config.put( "dfs.replication", "2" );
        config.put( "dfs.data.dir", "/data/dfs/data" );
        config.put( "dfs.block.size", "134217728" );
        config.put( "dfs.namenode.resource.du.reserved", "13107200" );

    }
}
