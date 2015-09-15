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
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gondor.model.orm.Host;
import com.gondor.repository.HostRepository;
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
    private HostRepository hostRepository;


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getStatus(int)
     */
    @Override
    public String getStatus( Integer hostID )
    {
        LOG.trace( "Method: getStatus called." );

        return null;

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getAllHosts()
     */
    @Override
    public List<Host> getAllHosts()
    {
        LOG.trace( "Method: getAllHosts called." );

        return hostRepository.findAll();

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getAllServices()
     */
    @Override
    public Set<com.gondor.model.orm.Service> getAllServices( Integer hostId )
    {
        LOG.trace( "Method: getAllServices called." );

        return hostRepository.getServices( hostId );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#cretateHost(com.gondor.model.orm.Host)
     */
    @Override
    public Host cretateHost( Host host )
    {
        LOG.trace( "Method: cretateHost called." );

        return hostRepository.save( host );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#decomminsionHost(int)
     */
    @Override
    public void decomminsionHost( Integer hostId )
    {
        LOG.trace( "Method: decomminsionHost called." );

        hostRepository.decommissionCluster( hostId );
        LOG.trace( "Method: decomminsionHost finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#validateHostNameAlreadyPresent(java.lang.String)
     */
    @Override
    public Boolean validateHostNameAlreadyPresent( String hostName )
    {
        LOG.trace( "Method: validateHostAlreadyPresent called." );

        return hostRepository.getHost( hostName ) == null ? false : true;

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#addHostToCluster(int, int)
     */
    @Override
    public void addHostToCluster( Integer hostId, Integer clusterId )
    {
        LOG.trace( "Method: addHostToCluster called." );
        // hostDao.addHostToCluster( hostId, clusterId );

        LOG.trace( "Method: addHostToCluster finished." );
    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#checkIfHostInAnyCluster(java.lang.String)
     */
    @Override
    public Boolean checkIfHostNameInAnyCluster( String hostIdentifier )
    {
        LOG.trace( "Method: checkIfHostInAnyCluster called." );

        return null;//hostDao.checkHostName( hostIdentifier, true );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#checkIfHostInAnyCluster(int)
     */
    @Override
    public Boolean checkIfHostInAnyCluster( Integer hostId )
    {
        LOG.trace( "Method: checkIfHostInAnyCluster called." );

        return null;//hostDao.checkHost( hostId, true );

    }


    /* (non-Javadoc)
     * @see com.gondor.services.HostManager#getHost(int)
     */
    @Override
    public Host getHost( Integer hostId )
    {
        LOG.trace( "Method: getHost called." );

        return null;//hostDao.getHost( hostId );

    }


}
