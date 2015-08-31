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
import java.util.List;


/**
 * @author Vipin Kumar
 * @created 28-Aug-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class Node<T>
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( Node.class );

    private T vertex;

    private List<Edge<T>> edges;

    private Node<T> parent;

    private boolean isVisited;


    /**
     * 
     */
    public Node( T vertex )
    {
        this.vertex = vertex;
        this.edges = new ArrayList<Edge<T>>();
    }


    public boolean addEdge( Node<T> that )
    {
        if ( hasEdge( that ) )
            return false;
        Edge<T> newEdge = new Edge<T>( this, that );
        return edges.add( newEdge );
    }


    public boolean removeEdge( Node<T> that )
    {
        List<Edge<T>> ledges = findEdge( that );
        if ( !ledges.isEmpty() )
            return edges.removeAll( ledges );
        return false;
    }


    /**
     * @param that
     * @return
     */
    public boolean hasEdge( Node<T> that )
    {
        LOG.trace( "Method: hasEdge called." );

        return ( !findEdge( that ).isEmpty() );

    }


    /**
     * @param that
     * @return
     */
    private List<Edge<T>> findEdge( Node<T> that )
    {
        LOG.trace( "Method: findEdge called." );
        List<Edge<T>> lEdges = new ArrayList<Edge<T>>();
        for ( Edge<T> e : edges ) {
            if ( e.isBetween( this, that ) )
                lEdges.add( e );
        }
        return lEdges;

    }


    /**
     * @return
     */
    public int getEdgeCount()
    {
        LOG.trace( "Method: getEdgeCount called." );

        return edges.size();

    }


    public boolean isVisited()
    {
        return isVisited;
    }


    /**
     * @return the parent
     */
    public Node<T> getParent()
    {
        return parent;
    }


    /**
     * @param parent the parent to set
     */
    public void setParent( Node<T> parent )
    {
        this.parent = parent;
    }


    /**
     * @param isVisited the isVisited to set
     */
    public void setVisited( boolean isVisited )
    {
        this.isVisited = isVisited;
    }


    /**
     * @return the edges
     */
    public List<Edge<T>> getEdges()
    {
        return edges;
    }


    /**
     * @return the vertex
     */
    public T getVertex()
    {
        return vertex;
    }


    /**
     * @param vertex the vertex to set
     */
    public void setVertex( T vertex )
    {
        this.vertex = vertex;
    }


}
