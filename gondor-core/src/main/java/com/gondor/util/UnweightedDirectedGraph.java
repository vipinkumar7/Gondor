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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;


/**
 * @author Vipin Kumar
 * @created 28-Aug-2015
 * 
 * Graph for Maintaining service relationship and bundle relationship
 * 
 */
public class UnweightedDirectedGraph<T>
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( UnweightedDirectedGraph.class );

    /**
     * A map from nodes to set of outgoing edges
     */
    private final Map<T, Node<T>> mGraph = new HashMap<T, Node<T>>();


    public boolean addNode( T vertex )
    {
        LOG.debug( "adding new node" );
        if ( mGraph.containsKey( vertex ) ) {
            return false;
        }
        mGraph.put( vertex, new Node<T>( vertex ) );
        return true;
    }


    public boolean addEdge( T vertex1, T vertex2 )
    {
        if ( !mGraph.containsKey( vertex1 ) || !mGraph.containsKey( vertex2 ) )
            throw new NoSuchElementException( "object not in graph" );

        return mGraph.get( vertex1 ).addEdge( mGraph.get( vertex2 ) );
    }


    public boolean removeVertex( T vertex )
    {
        if ( !mGraph.containsKey( vertex ) )
            return false;
        Node<T> toRemove = getNode( vertex );
        Collection<Node<T>> nodes = mGraph.values();
        for ( Node<T> node : nodes ) {
            node.removeEdge( toRemove );
        }
        mGraph.remove( vertex );
        return true;
    }


    public boolean removeEdge( T vertex1, T vertex2 )
    {
        if ( !mGraph.containsKey( vertex1 ) || !mGraph.containsKey( vertex2 ) )
            return false;
        return getNode( vertex1 ).removeEdge( getNode( vertex2 ) );
    }


    public int vertexCount()
    {
        return mGraph.keySet().size();
    }


    public int edgeCount()
    {
        int count = 0;
        Collection<Node<T>> allNodes = mGraph.values();
        for ( Node<T> node : allNodes ) {
            count += node.getEdgeCount();
        }
        return count;
    }


    /**
     * @param vertex
     * @return
     */
    private Node<T> getNode( T vertex )
    {
        LOG.trace( "Method: getNode called." );

        return mGraph.get( vertex );

    }


    public boolean containsVertex( T vertex )
    {
        return mGraph.containsKey( vertex );
    }


    public boolean containsEdge( T vertex1, T vertex2 )
    {
        if ( !mGraph.containsKey( vertex1 ) || !mGraph.containsKey( vertex1 ) )
            return false;
        return getNode( vertex1 ).hasEdge( getNode( vertex2 ) );
    }


    public List<T> getAllParent( T vertex )
    {
        if ( !mGraph.containsKey( vertex ) )
            return null;
        Node<T> start = getNode( vertex );
        List<T> parents = new ArrayList<T>();
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add( start );
        while ( !queue.isEmpty() ) {
            Node<T> first = queue.remove();
            if ( first.getParent() != null ) {
                queue.add( first );
                parents.add( first.getVertex() );
            }
        }
        return parents;
    }


    public void bfs( T startVertex )
    {
        if ( !containsVertex( startVertex ) )
            throw new RuntimeException( "vertex not present" );
        clearTrace();
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        Node<T> start = getNode( startVertex );
        queue.add( start );

        while ( queue.isEmpty() ) {
            Node<T> first = queue.remove();
            first.setVisited( true );
            List<Edge<T>> edges = first.getEdges();

            for ( Edge<T> edge : edges ) {
                Node<T> adjacent = edge.getDest();
                if ( !adjacent.isVisited() ) {
                    adjacent.setParent( first );
                    queue.add( adjacent );
                }
            }
        }
    }


    public void clearTrace()
    {
        Iterator<T> itr = mGraph.keySet().iterator();
        while ( itr.hasNext() ) {
            T t = itr.next();
            getNode( t ).setParent( null );
            getNode( t ).setVisited( false );
        }
    }
}
