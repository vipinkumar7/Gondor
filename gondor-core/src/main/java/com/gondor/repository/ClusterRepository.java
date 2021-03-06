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
package com.gondor.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gondor.model.orm.Cluster;
import com.gondor.model.orm.Host;


/**
 * @author Vipin Kumar
 * @created 15-Sep-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Transactional ( readOnly = true)
public interface ClusterRepository extends JpaRepository<Cluster, Integer>
{
    /**
     * 
     * @param clusterId
     * @return
     */
    @Query ( "SELECT a.hosts FROM Cluster a INNER JOIN  a.hosts  where a.id=:clusterId ")
    public Set<Host> getHosts( @Param ( "clusterId") Integer clusterId );


    /**
     * 
     * @param clusterId
     */
    @Modifying
    @Transactional ( readOnly = false)
    @Query ( "UPDATE Cluster c set c.active=false where c.id=:clusterId")
    public void decommissionCluster( @Param ( "clusterId") Integer clusterId );
}
