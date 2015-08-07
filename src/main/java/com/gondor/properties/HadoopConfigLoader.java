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

import com.gondor.dao.BaseConfigurationDao;
import com.gondor.model.orm.HdfsSite;
import com.gondor.model.oxm.Configuration;
import com.gondor.model.oxm.Property;
import com.gondor.util.XmlConverter;


/**
 * @author Vipin Kumar
 * @created 09-Jul-2015
 *
 * TODO: Write a quick description of what the class is supposed to do.
 *
 */
@Component
public class HadoopConfigLoader
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HadoopConfigLoader.class );

    private static final String PROPERTIES_FILE_LOCATION = "properties/";

    @Value ( "${hdfs.file.name}")
    private String hdfsFileName;

    @Autowired
    private XmlConverter xmlConverter;

    @Autowired
    private BaseConfigurationDao<HdfsSite> hdfsSiteDAOImpl;


    public HadoopConfigLoader()
    {}


    @PostConstruct
    public void loadHdfsSite() throws XmlMappingException, IOException
    {
        LOG.trace( "Method: loadHdfsSite called." );
        InputStream input = getClass().getClassLoader().getResourceAsStream( PROPERTIES_FILE_LOCATION + hdfsFileName );
        Configuration hdfsConfig = (Configuration) xmlConverter.convertFromXMLToObject( input );

        List<HdfsSite> hdfsSites = new ArrayList<>();
        Property[] hdfsProperties = hdfsConfig.getProperty();
        for ( Property property : hdfsProperties ) {
            HdfsSite hdfsSite = new HdfsSite();
            hdfsSite.setProperty( property.getName() );
            hdfsSite.setValue( property.getValue() );
            hdfsSites.add( hdfsSite );
        }

        hdfsSiteDAOImpl.saveConfigs( hdfsSites );
        LOG.trace( "Method: loadHdfsSite finished." );
    }


}
