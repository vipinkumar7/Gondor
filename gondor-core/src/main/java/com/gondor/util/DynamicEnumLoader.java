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

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import sun.reflect.ConstructorAccessor;
import sun.reflect.FieldAccessor;
import sun.reflect.ReflectionFactory;


/**
 * @author Vipin Kumar
 * @created 17-Sep-2015
 * 
 * This class is written for Dynamically loading services as enums   
 * 
 */
@Component
@SuppressWarnings ( "restriction")
public class DynamicEnumLoader
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( DynamicEnumLoader.class );

    private static ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();


    private static void setFailsafeFieldValue( Field field, Object target, Object value ) throws NoSuchFieldException,
        IllegalAccessException
    {

        // let's make the field accessible
        field.setAccessible( true );

        // next we change the modifier in the Field instance to
        // not be final anymore, thus tricking reflection into
        // letting us modify the static final field
        Field modifiersField = Field.class.getDeclaredField( "modifiers" );
        modifiersField.setAccessible( true );
        int modifiers = modifiersField.getInt( field );

        // blank out the final bit in the modifiers int
        modifiers &= ~Modifier.FINAL;
        modifiersField.setInt( field, modifiers );

        FieldAccessor fa = reflectionFactory.newFieldAccessor( field, false );
        fa.set( target, value );
    }


    private static void blankField( Class<?> enumClass, String fieldName ) throws NoSuchFieldException, IllegalAccessException
    {
        for ( Field field : Class.class.getDeclaredFields() ) {
            if ( field.getName().contains( fieldName ) ) {
                AccessibleObject.setAccessible( new Field[] { field }, true );
                setFailsafeFieldValue( field, enumClass, null );
                break;
            }
        }
    }


    private static void cleanEnumCache( Class<?> enumClass ) throws NoSuchFieldException, IllegalAccessException
    {
        blankField( enumClass, "enumConstantDirectory" ); // Sun (Oracle?!?) JDK 1.5/6
        blankField( enumClass, "enumConstants" ); // IBM JDK
    }


    private static ConstructorAccessor getConstructorAccessor( Class<?> enumClass, Class<?>[] additionalParameterTypes )
        throws NoSuchMethodException
    {
        Class<?>[] parameterTypes = new Class[additionalParameterTypes.length + 2];
        parameterTypes[0] = String.class;
        parameterTypes[1] = int.class;
        System.arraycopy( additionalParameterTypes, 0, parameterTypes, 2, additionalParameterTypes.length );
        return reflectionFactory.newConstructorAccessor( enumClass.getDeclaredConstructor( parameterTypes ) );
    }


    private static Object makeEnum( Class<?> enumClass, String value, int ordinal, Class<?>[] additionalTypes,
        Object[] additionalValues ) throws Exception
    {
        Object[] parms = new Object[additionalValues.length + 2];
        parms[0] = value;
        parms[1] = Integer.valueOf( ordinal );
        System.arraycopy( additionalValues, 0, parms, 2, additionalValues.length );
        return enumClass.cast( getConstructorAccessor( enumClass, additionalTypes ).newInstance( parms ) );
    }


    /**
     * Add an enum instance to the enum class given as argument
     *
     * @param <T> the type of the enum (implicit)
     * @param enumType the class of the enum to be modified
     * @param enumName the name of the new enum instance to be added to the class.
     */
    @SuppressWarnings ( "unchecked")
    public static <T extends Enum<?>> void addEnum( Class<T> enumType, String enumName, T newEnum )
    {

        // 0. Sanity checks
        if ( !Enum.class.isAssignableFrom( enumType ) ) {
            throw new RuntimeException( "class " + enumType + " is not an instance of Enum" );
        }

        // 1. Lookup "$VALUES" holder in enum class and get previous enum instances
        Field valuesField = null;
        Field[] fields = newEnum.getClass().getDeclaredFields();
        for ( Field field : fields ) {
            if ( field.getName().contains( "$VALUES" ) ) {
                valuesField = field;
                break;
            }
        }
        AccessibleObject.setAccessible( new Field[] { valuesField }, true );

        try {

            // Copy it 
            T[] previousValues = (T[]) valuesField.get( enumType );
            List<T> values = new ArrayList<T>( Arrays.asList( previousValues ) );

            // 3. build new enum
            T newValue = (T) makeEnum( enumType, // The target enum class
                enumName, // THE NEW ENUM INSTANCE TO BE DYNAMICALLY ADDED
                values.size(), new Class<?>[] { newEnum.getClass() }, // could be used to pass values to the enum constuctor if needed
                new Object[] { newEnum } ); // could be used to pass values to the enum constuctor if needed

            //. add new value
            values.add( newValue );

            // Set new values field
            setFailsafeFieldValue( valuesField, null, values.toArray( (T[]) Array.newInstance( enumType, 0 ) ) );

            // Clean enum cache
            cleanEnumCache( enumType );

        } catch ( Exception e ) {
            e.printStackTrace();
            throw new RuntimeException( e.getMessage(), e );
        }
    }


    /**
     * Load New enum from database here
     */

    @PostConstruct
    public void loadService()
    {

        LOG.debug( "Dynamically adding new Enums" );
        // Dynamically add 
        //addEnum( ServiceType.class, "ZOOKEEPER", ServiceType.SERVICE );       
    }

}
