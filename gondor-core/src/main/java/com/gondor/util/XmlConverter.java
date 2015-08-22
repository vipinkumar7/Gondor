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
package com.gondor.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;


/**
 * @author Vipin Kumar
 * @created 09-Jul-2015
 *
 * TODO: Write a quick description of what the class is supposed to do.
 *
 */
public class XmlConverter
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( XmlConverter.class );

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;


    public XmlConverter( Marshaller marshaller, Unmarshaller unmarshaller )
    {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }


    /**
     * @throws IOException
     * @throws XmlMappingException
     *
     */
    public Object convertFromXMLToObject( InputStream inputStream ) throws XmlMappingException, IOException
    {
        LOG.trace( "Method: convertFromXMLToObject called." );

        return getUnmarshaller().unmarshal( new StreamSource( inputStream ) );
    }


    /**
     *
     */
    public void convertFromObjectToXML( Object object, ByteArrayOutputStream stream ) throws IOException
    {
        LOG.trace( "Method: convertFromObjectToXML called." );

        getMarshaller().marshal( object, new StreamResult( stream ) );
        LOG.trace( "Method: convertFromObjectToXML finished." );
    }


    /**
     * @return the marshaller
     */
    public Marshaller getMarshaller()
    {
        return marshaller;
    }


    /**
     * @param marshaller the marshaller to set
     */
    public void setMarshaller( Marshaller marshaller )
    {
        this.marshaller = marshaller;
    }


    /**
     * @return the unmarshaller
     */
    public Unmarshaller getUnmarshaller()
    {
        return unmarshaller;
    }


    /**
     * @param unmarshaller the unmarshaller to set
     */
    public void setUnmarshaller( Unmarshaller unmarshaller )
    {
        this.unmarshaller = unmarshaller;
    }


}
