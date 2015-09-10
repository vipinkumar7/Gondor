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

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Vipin Kumar
 * @created 08-Sep-2015
 * 
 * This class will execute Java Script to validate   configuration
 * 
 */
public class ScriptExecuteUtil
{

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( ScriptExecuteUtil.class );


    public static void main( String[] args )
    {
        executeProcedure( "function(){"
            + " print ('data ') }" );
    }


    /**
     * @param string
     */
    private static void executeProcedure( String string )
    {
        LOG.trace( "Method: executeProcedure called." );
        ScriptEngineManager engineManager=new ScriptEngineManager();
        ScriptEngine scriptEngine=engineManager.getEngineByName( "js" );
        try {
            scriptEngine.eval( string );
        } catch ( ScriptException e ) {
            
            LOG.error("ScriptException while performing operation in executeProcedure",e);
        }
        LOG.trace( "Method: executeProcedure finished." );
    }
}
