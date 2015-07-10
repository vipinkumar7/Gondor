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
package com.gondor.services.impl;

import org.springframework.stereotype.Service;

import com.gondor.model.orm.Host;
import com.gondor.services.HostManager;


/**
 * @author Vipin Kumar
 * @created 23-Jun-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */

@Service ( "hostManager")
public class HostManagerImpl implements HostManager
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( HostManagerImpl.class );


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#decomminsionHost(int, int)
     */
    @Override
    public void decomminsionHost( int hostId )
    {
        LOG.trace( "Method: decomminsionHost called." );


        LOG.trace( "Method: decomminsionHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#createHost(java.lang.String)
     */
    @Override
    public void createHost( String hostname )
    {
        LOG.trace( "Method: createHost called." );


        LOG.trace( "Method: createHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#validateHost(java.lang.String)
     */
    @Override
    public void validateHost( String hostname )
    {
        LOG.trace( "Method: validateHost called." );


        LOG.trace( "Method: validateHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#isHostExists(int)
     */
    @Override
    public boolean isHostExists( int hostId )
    {
        LOG.trace( "Method: isHostExists called." );

        return false;

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getHost(int)
     */
    @Override
    public Host getHost( int hostId )
    {
        LOG.trace( "Method: getHost called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getHost(java.lang.String)
     */
    @Override
    public Host getHost( String hostname )
    {
        LOG.trace( "Method: getHost called." );

        return null;

    }
}
