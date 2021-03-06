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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import com.gondor.model.orm.SimpleConfiguration;
import com.gondor.model.oxm.Configuration;
import com.gondor.model.oxm.Property;
import com.gondor.repository.SimpleConfRepository;
import com.gondor.util.XmlConverter;


/**
 * @author Vipin Kumar
 * @created 09-Jul-2015
 *
 * TODO: Write a quick description of what the class is supposed to do.
 *
 */
@Component
public class GenericConfigLoader
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( GenericConfigLoader.class );

    private static final String PROPERTIES_FILE_LOCATION = "properties/";

    @Value ( "#{'${list.simple.xml.config.files}'.split(',')}")
    private List<String> simpleXmlConfigFile;

    @Autowired
    private XmlConverter xmlConverter;

    @Autowired
    private SimpleConfRepository simpleConfRepository;


    public GenericConfigLoader()
    {}


    @PostConstruct
    public void loadConfigurations() throws XmlMappingException, IOException
    {
        LOG.trace( "Method: loadConfigurations called." );

        for ( String file : simpleXmlConfigFile ) {
            InputStream input = getClass().getClassLoader().getResourceAsStream( PROPERTIES_FILE_LOCATION + file );
            Configuration genericConfig = (Configuration) xmlConverter.convertFromXMLToObject( input );

            List<SimpleConfiguration> genericConfList = new ArrayList<>();
            Property[] genericProperties = genericConfig.getProperty();
            for ( Property property : genericProperties ) {
                SimpleConfiguration simpleConf = new SimpleConfiguration();
                simpleConf.setProperty( property.getName() );
                simpleConf.setValue( property.getValue() );
                simpleConf.setServiceType( null );//TODO Later this will come from xml
                simpleConf.setFileName( file );
                genericConfList.add( simpleConf );
            }
            simpleConfRepository.save( genericConfList );
            LOG.trace( "Method: loadHdfsSite finished." );
        }
    }


}
