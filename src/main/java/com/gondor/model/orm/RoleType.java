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
package com.gondor.model.orm;

/**
 * @author Vipin Kumar
 * @created 24-Jun-2015
 * 

 * each user is responsible for a cluster management 
 * 
 * ADMIN all Privileges(Start ,Stop ,Change)
 * USER  only viewer
 * Controller (only change)
 *  
 */
public enum RoleType
{
    ADMIN, USER, CONTROLLER
}
