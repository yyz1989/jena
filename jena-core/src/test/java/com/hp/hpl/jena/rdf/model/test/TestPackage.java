/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hp.hpl.jena.rdf.model.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Collected test suite for the .model package.
 * 
 * This is the base class for TestPackage implementations.
 * 
 * Model developers should extend this class to implement the package test
 * suite.
 * See TestPackage for example of usage.
 */
@RunWith(Suite.class)
@SuiteClasses({
    TestModelFactory.class, 
    TestSimpleListStatements.class, 
    TestModelPolymorphism.class, 
    TestSimpleSelector.class, 
    TestStatements.class, 
    TestRDFNodes.class, 
    TestReifiedStatements.class, 
    TestIterators.class, 
    TestContains.class, 
    TestLiteralImpl.class, 
    TestResourceImpl.class, 
    TestHiddenStatements.class, 
    TestNamespace.class, 
    TestModelBulkUpdate.class, 
    TestConcurrencyNesting.class,
    TestConcurrencyNesting.class,
    TestConcurrencyNesting.class,
    TestConcurrencyNesting.class,
    TestConcurrencyNesting.class,
    TestConcurrencyNesting.class,
    TestConcurrencyNesting.class,
    TestConcurrencyNesting.class,
    TestConcurrencyParallel.class, 
    TestModelMakerImpl.class, 
    TestModelPrefixMapping.class, 
    TestContainers.class, 
    TestModel.class, 
    TestModelSetOperations.class, 
    TestSelectors.class, 
    TestModelEvents.class, 
    TestReaderEvents.class, 
    TestList.class, 
    TestAnonID.class, 
    TestLiteralsInModel.class, 
    TestRemoveSPO.class, 
    TestListSubjectsEtc.class, 
    TestModelExtract.class, 
    TestModelRead.class, 
    TestPropertyImpl.class, 
    TestRemoveBug.class, 
    TestContainerConstructors.class, 
    TestAltMethods.class, 
    TestBagMethods.class, 
    TestSeqMethods.class, 
    TestAddAndContains.class, 
    TestAddModel.class, 
    TestGet.class, 
    TestListSubjects.class, 
    TestLiterals.class, 
    TestObjects.class, 
    TestResourceMethods.class, 
    TestResources.class, 
    TestStatementMethods.class, 
    TestStatementCreation.class, 
    TestReaders.class, 
    TestObjectOfProperties.class, 
    TestCopyInOutOfModel.class, 
    TestSelectorUse.class
})
public class TestPackage {

}
