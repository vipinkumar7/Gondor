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

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Vipin Kumar
 * @created 31-Aug-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
public class TestDependencyGraph
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( TestDependencyGraph.class );


    @Test
    public void testBuildGraph()
    {
        LOG.info( "Build graph test started" );
        UnweightedDirectedGraph<Integer> graph = new UnweightedDirectedGraph<Integer>();
        graph.addNode( 1 );
        graph.addNode( 2 );
        graph.addNode( 3 );
        graph.addNode( 4 );
        graph.addNode( 5 );
        graph.addNode( 6 );
        graph.addEdge( 1, 4 );
        graph.addEdge( 1, 3 );
        graph.addEdge( 1, 2 );
        graph.addEdge( 3, 5 );
        graph.addEdge( 4, 6 );
        graph.addEdge( 4, 3 );
        graph.addEdge( 5, 4 );
        graph.fullBfs();

        List<Integer> allparents = graph.getAllParent( 3 );

        assert allparents.isEmpty() == false;
        for ( Integer parent : allparents )
            System.out.print( parent + "\t" );
    }


    @Test
    public void checkCycle()
    {
        UnweightedDirectedGraph<Integer> graph = new UnweightedDirectedGraph<Integer>();
        graph.addNode( 1 );
        graph.addNode( 2 );
        graph.addNode( 3 );
        graph.addNode( 4 );
        graph.addNode( 5 );
        graph.addNode( 6 );
        graph.addEdge( 1, 4 );
        graph.addEdge( 1, 3 );
        graph.addEdge( 1, 2 );
        graph.addEdge( 3, 5 );
        graph.addEdge( 4, 6 );
        graph.addEdge( 4, 3 );
        graph.addEdge( 5, 4 );
        assertTrue( graph.detectCycle() );
    }
}
