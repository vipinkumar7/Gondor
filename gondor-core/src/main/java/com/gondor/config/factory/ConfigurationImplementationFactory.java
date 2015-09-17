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
package com.gondor.config.factory;

import org.springframework.beans.factory.annotation.Autowired;

import com.gondor.config.strategy.ConfigurationStrategy;
import com.gondor.config.strategy.impl.HadoopConfigStrategy;
import com.gondor.config.strategy.impl.HbaseConfigStrategy;
import com.gondor.config.strategy.impl.HiveConfigStrategy;
import com.gondor.config.strategy.impl.ZookeeperConfigStrategy;
import com.gondor.model.orm.ServiceType;


/**
 * @author Vipin Kumar
 * @created 17-Sep-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class ConfigurationImplementationFactory
{

    //TODO
    /*  This has to be implemented by configuring factory bean in application context  
     *@Bean ( name = "configImplFacory")
    public void getServiceLocator( ServiceLocatorFactoryBean serviceLocatorFactoryBean )
    {
        serviceLocatorFactoryBean.setServiceLocatorInterface( ConfigurationImplementationFactory.class );

    } 
     */


    @Autowired
    HadoopConfigStrategy hadoopConfigStrategy;

    @Autowired
    HbaseConfigStrategy hbaseConfigStrategy;

    @Autowired
    HiveConfigStrategy hiveConfigStrategy;

    @Autowired
    ZookeeperConfigStrategy zookeeperConfigStrategy;


    ConfigurationStrategy getConfigurationImplementation( ServiceType serviceType )
    {
        switch ( serviceType ) {
            case HDFS:
                return hadoopConfigStrategy;
            case HBASE:
                return hbaseConfigStrategy;
            case HIVE:
                return hiveConfigStrategy;
            case ZOOKEEPER:
                return zookeeperConfigStrategy;
            default:
                return null;
        }

    }
}
