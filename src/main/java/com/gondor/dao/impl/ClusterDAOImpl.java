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
package com.gondor.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gondor.dao.ClusterDao;
import com.gondor.model.orm.Host;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Repository
public class ClusterDAOImpl implements ClusterDao
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ClusterDAOImpl.class );


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#getStatus(int)
     */
    @Override
    public String getStatus( int clusterId )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#getAllhosts(int)
     */
    @Override
    public List<Host> getAllhosts( int clusterId )
    {
        LOG.trace( "Method: getAllhosts called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#createCluster(java.lang.String)
     */
    @Override
    public void createCluster( String name )
    {
        LOG.trace( "Method: createCluster called." );


        LOG.trace( "Method: createCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#addHostToCluster(int, int)
     */
    @Override
    public void addHostToCluster( int hostId, int clusterId )
    {
        LOG.trace( "Method: addHostToCluster called." );


        LOG.trace( "Method: addHostToCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.ClusterDao#decommissionCluster(int)
     */
    @Override
    public void decommissionCluster( int clusterId )
    {
        LOG.trace( "Method: decommissionCluster called." );


        LOG.trace( "Method: decommissionCluster finished." );
    }
}
