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

package com.hp.hpl.jena.util.iterator.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;

import com.hp.hpl.jena.rdf.model.test.ModelTestBase;
import com.hp.hpl.jena.util.iterator.*;

public class TestNullIterator extends ModelTestBase
    {
    
    @Test
    public void testHasntNext()
        { assertFalse( NullIterator.instance().hasNext() ); }
    
    @Test
    public void testNextFails()
        { try
            { NullIterator.instance().next(); fail( "should throw NoSuchElementException" ); }
        catch (NoSuchElementException e) { pass(); }
        }
    
    @Test
    public void testAndThenReturnsArgument()
        {
        ExtendedIterator<Object> it = new NiceIterator<>();
        assertSame( it, NullIterator.instance().andThen( it ) );
        }
    }
