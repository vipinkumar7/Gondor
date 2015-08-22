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

/**
 * @author Vipin Kumar
 * @created 08-Aug-2015
 * 
 * Different types of Configuration objects
 * 
 */
public enum ConfiguartionType
{
    HDFS_SITE( 0, HdfsSite.class ), CORE_SITE( 1, CoreSite.class ), MAPRED_SITE( 2, MapredSite.class ), HIVE_SITE( 3,
        HiveSite.class ), YARN_SITE( 4, YarnSite.class );

    private int key;
    private Class<? extends BaseConfiguration> value;


    /**
     * 
     */
    private ConfiguartionType( int key, Class<? extends BaseConfiguration> value )
    {
        this.key = key;
        this.value = value;
    }


    /**
     * @return the key
     */
    public int getKey()
    {
        return key;
    }


    /**
     * @param key the key to set
     */
    public void setKey( int key )
    {
        this.key = key;
    }

}
