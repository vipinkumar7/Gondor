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

import java.util.ArrayList;
import java.util.List;


/**
 * @author Vipin Kumar
 * @created 08-Jul-2015
 * 
 * This is tree implementation of all the services and their respective parents
 * 
 */
public enum ServiceType
{

    SERVICE( null ),

    HDFS( SERVICE ), NAMENODE( HDFS ), SECONDARY_NAMENODE( HDFS ), DATANODE( HDFS ),

    YARN( SERVICE ), RESOURCEMANAGER( YARN ), NODEMANAGER( YARN ),

    HIVE( SERVICE ), HIVE_METASTORE( HIVE ), HIVE_SERVER2( HIVE ),

    HBASE( SERVICE ), HBASE_REGION_SERVER( HBASE ), HBASE_MASTER( HBASE );

    private ServiceType parent = null;

    private List<ServiceType> children = new ArrayList<ServiceType>();


    /**
     * 
     */
    private ServiceType( ServiceType parent )
    {
        this.parent = parent;
        if ( this.parent != null ) {
            this.parent.addChild( this );
        }
    }


    private void addChild( ServiceType child )
    {
        this.children.add( child );
    }


    public ServiceType parent()
    {
        return parent;
    }


    public ServiceType[] children()
    {
        return children.toArray( new ServiceType[children.size()] );
    }


    public ServiceType[] allChildren()
    {
        List<ServiceType> list = new ArrayList<ServiceType>();
        addChildren( this, list );
        return list.toArray( new ServiceType[list.size()] );
    }


    private static void addChildren( ServiceType root, List<ServiceType> list )
    {
        list.addAll( root.children );
        for ( ServiceType child : root.children ) {
            addChildren( child, list );
        }
    }


    public boolean is( ServiceType other )
    {
        if ( other == null ) {
            return false;
        }

        for ( ServiceType osType = this; osType != null; osType = osType.parent() ) {
            if ( other == osType ) {
                return true;
            }
        }
        return false;
    }


    public static void main( String[] args )
    {
        List<ServiceType> type = ServiceType.HDFS.children;
        for ( ServiceType t : type )
            System.out.println( t.name() );

    }

}
