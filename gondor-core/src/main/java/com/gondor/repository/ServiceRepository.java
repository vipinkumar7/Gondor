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
import org.springframework.transaction.annotation.Transactional;

import com.gondor.model.orm.InstanceConfiguration;
import com.gondor.model.orm.Service;
import com.gondor.model.orm.ServiceType;


/**
 * @author Vipin Kumar
 * @created 15-Sep-2015
 * 
 * TODO: Write a quick description of what the class is supposed to do.
 * 
 */
@Transactional ( readOnly = true)
public interface ServiceRepository extends JpaRepository<Service, Integer>
{


    @Query ( "SELECT s.name FROM Service s where s.id=:serviceId")
    public ServiceType getServiceType( Integer serviceId );


    @Query ( "SELECT s FROM Service s where s.name=:serviceType and s.host.id=:hostId")
    public Service getServiceIfExists( ServiceType serviceType, Integer hostId );


    @Query ( "SELECT s.running FROM Service s")
    public boolean checkState( Integer serviceId );


    @Modifying
    @Transactional ( readOnly = false)
    @Query ( "UPDATE Service s set s.running=true where s.id=:serviceId")
    public void startService( ServiceType serviceType, Integer hostId );


    @Modifying
    @Transactional ( readOnly = false)
    @Query ( "UPDATE Service s set s.running=false where s.id=:serviceId")
    public void stopService( Integer serviceId );


    @Query ( "SELECT s.instanceConfigs FROM Service s INNER JOIN s.instanceConfigs where s.id =:serviceId")
    public Set<InstanceConfiguration> getAllConfig( Integer serviceId );

}
