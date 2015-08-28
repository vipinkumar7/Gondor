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

/**
 * @author Vipin Kumar
 * @created 28-Aug-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class Edge<T>
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( Edge.class );

    private Node<T> src;
    private Node<T> dest;


    /**
     * 
     */
    public Edge( Node<T> src, Node<T> dest )
    {
        this.src = src;
        this.dest = dest;
    }


    /**
     * @return the src
     */
    public Node<T> getSrc()
    {
        return src;
    }


    /**
     * @param src the src to set
     */
    public void setSrc( Node<T> src )
    {
        this.src = src;
    }


    /**
     * @return the dest
     */
    public Node<T> getDest()
    {
        return dest;
    }


    /**
     * @param dest the dest to set
     */
    public void setDest( Node<T> dest )
    {
        this.dest = dest;
    }


    public boolean isBetween( Node<T> src, Node<T> dest )
    {
        LOG.debug( "Is between called" );
        return ( this.src == src && this.dest == dest );
    }
}
