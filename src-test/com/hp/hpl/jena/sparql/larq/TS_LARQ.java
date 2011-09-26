/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.hpl.jena.sparql.larq;

import junit.framework.TestSuite ;
import org.junit.runner.RunWith ;
import org.junit.runners.Suite ;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
    TestLARQ_Code.class,
    TestLARQ_Script.class
} )

public class TS_LARQ
{
    static public TestSuite suite()
    {
        TestSuite ts = new TestSuite(TS_LARQ.class.getName()) ;
        ts.addTest(TestLARQ_Code.suite()) ;
        ts.addTest(TestLARQ_Script.suite()) ;
        return ts ;
    }
}