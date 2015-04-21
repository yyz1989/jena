/*
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

package com.hp.hpl.jena.reasoner.rulesys.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Aggregate tester that runs all the test associated with the rulesys package.
 */

@RunWith(Suite.class)
@SuiteClasses({
    TestConfigVocabulary.class,
    TestGenericRuleReasonerConfig.class,
    TestBasics.class,
    TestBackchainer.class,
    TestBasicLP.class,
    TestLPDerivation.class,
    TestFBRules.class,
    TestGenericRules.class,
    TestRETE.class,
    TestSetRules.class,
    OWLUnitTest.class,
    TestBugs.class,
    TestOWLMisc.class,
    TestCapabilities.class,
    TestComparatorBuiltins.class,
    FRuleEngineIFactoryTest.class,
    ConcurrencyTest.class,
    TestInferenceReification.class,
    TestRestrictionsDontNeedTyping.class
})
public class TestPackage {

}
