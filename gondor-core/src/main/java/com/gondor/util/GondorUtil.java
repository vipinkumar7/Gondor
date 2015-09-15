/**
 *  * Copyright (c) 2015 Gondor. 
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

import java.util.ArrayList;
import java.util.Collection;


/**
 * @author Vipin Kumar
 * @created 15-Sep-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class GondorUtil
{
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( GondorUtil.class );


    /**
     * 
     */
    public static <E> Collection<E> makeCollection( Iterable<E> iter )
    {
        LOG.trace( "Method: makeCollection called." );
        Collection<E> list = new ArrayList<E>();
        for ( E e : iter ) {
            list.add( e );
        }
        LOG.trace( "Method: makeCollection finished." );
        return list;
    }


}
