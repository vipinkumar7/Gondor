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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gondor.dao.HostDao;
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

    @Autowired
    private HostDao hostDao;


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getStatus(int)
     */
    @Override
    public String getStatus( int hostID )
    {
        LOG.trace( "Method: getStatus called." );

        return hostDao.getStatus( hostID );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getAllHosts()
     */
    @Override
    public List<Host> getAllHosts()
    {
        LOG.trace( "Method: getAllHosts called." );

        return hostDao.getAllHosts();

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getAllServices()
     */
    @Override
    public List<com.gondor.model.orm.Service> getAllServices( int hostId )
    {
        LOG.trace( "Method: getAllServices called." );

        return hostDao.getAllServices( hostId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#cretateHost(com.gondor.model.orm.Host)
     */
    @Override
    public int cretateHost( Host host )
    {
        LOG.trace( "Method: cretateHost called." );

        return hostDao.cretateHost( host );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#decomminsionHost(int)
     */
    @Override
    public void decomminsionHost( int hostId )
    {
        LOG.trace( "Method: decomminsionHost called." );

        hostDao.decomminsionHost( hostId );
        LOG.trace( "Method: decomminsionHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#validateHostAlreadyPresent(java.lang.String)
     */
    @Override
    public Boolean validateHostAlreadyPresent( String hostIdentifier )
    {
        LOG.trace( "Method: validateHostAlreadyPresent called." );

        return hostDao.checkHost( hostIdentifier, false );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#validateHostAlreadyPresent(int)
     */
    @Override
    public Boolean validateHostAlreadyPresent( int hostId )
    {
        LOG.trace( "Method: validateHostAlreadyPresent called." );

        return hostDao.checkHost( hostId, false );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#addHostToCluster(int, int)
     */
    @Override
    public void addHostToCluster( int hostId, int clusterId )
    {
        LOG.trace( "Method: addHostToCluster called." );
        hostDao.addHostToCluster( hostId, clusterId );

        LOG.trace( "Method: addHostToCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#checkIfHostInAnyCluster(java.lang.String)
     */
    @Override
    public Boolean checkIfHostInAnyCluster( String hostIdentifier )
    {
        LOG.trace( "Method: checkIfHostInAnyCluster called." );

        return hostDao.checkHost( hostIdentifier, true );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#checkIfHostInAnyCluster(int)
     */
    @Override
    public Boolean checkIfHostInAnyCluster( int hostId )
    {
        LOG.trace( "Method: checkIfHostInAnyCluster called." );

        return hostDao.checkHost( hostId, true );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getHost(int)
     */
    @Override
    public Host getHost( int hostId )
    {
        LOG.trace( "Method: getHost called." );

        return hostDao.getHost( hostId );

    }


}
