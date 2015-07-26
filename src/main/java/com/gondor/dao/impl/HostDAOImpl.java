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

import org.springframework.stereotype.Repository;

import com.gondor.dao.HostDao;
import com.gondor.model.orm.Host;


/**
 * @author Vipin Kumar
 * @created 26-Jul-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Repository
public class HostDAOImpl implements HostDao
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HostDAOImpl.class );


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#getStatus(int)
     */
    @Override
    public String getStatus( int hostID )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#cretateHost(java.lang.String)
     */
    @Override
    public void cretateHost( String hostname )
    {
        LOG.trace( "Method: cretateHost called." );


        LOG.trace( "Method: cretateHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#decomminsionHost(int)
     */
    @Override
    public void decomminsionHost( int hostId )
    {
        LOG.trace( "Method: decomminsionHost called." );


        LOG.trace( "Method: decomminsionHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#validateHost(java.lang.String, java.lang.Integer)
     */
    @Override
    public Boolean validateHost( String hostIdentifier, Integer clusterId )
    {
        LOG.trace( "Method: validateHost called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#checkHost(java.lang.String)
     */
    @Override
    public Boolean checkHost( String hostIdentifier )
    {
        LOG.trace( "Method: checkHost called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.dao.HostDao#getHost(int)
     */
    @Override
    public Host getHost( int hostId )
    {
        LOG.trace( "Method: getHost called." );

        return null;

    }
}
