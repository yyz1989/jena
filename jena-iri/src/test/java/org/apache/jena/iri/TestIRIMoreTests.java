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

package org.apache.jena.iri;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class TestIRIMoreTests {

	@Test
	public void testRelativizeFrag1() {
		IRIFactory f = IRIFactory.jenaImplementation();
		IRI base = f.create("http://example.org/somefolder/mybase.rdf");
		IRI frag = f.create("http://example.org#foo");
		IRI rel = base.relativize(frag);
		assertEquals(frag,rel);
//		System.err.println(rel.toString());
		IRI back = base.resolve(rel);
		assertEquals(frag,back);
	}

	@Test
	public void testRelativizeFrag2() {
		IRIFactory f = IRIFactory.jenaImplementation();
		IRI base = f.create("http://example.org/somefolder/mybase.rdf");
		IRI frag = f.create("http://example.org/#foo");
		IRI rel = base.relativize(frag);
		assertEquals("/#foo",rel.toString());
		IRI back = base.resolve(rel);
		assertEquals(frag,back);
	}

	@Test
	public void testXPointer() {
		IRIFactory f = IRIFactory.jenaImplementation();
		IRI base = f.create("http://example.org/");
		IRI frag = base.resolve("http://eg.com/test.txt#xpointer(/unit[5])");
		Iterator<Violation> it = frag.violations(false);
        assertTrue(it.hasNext()) ;

//		while (it.hasNext()) {
//			System.err.println(it.next().getLongMessage());
//		}
		
	}

	@Test
	public void testNotIDN() {
		IRIFactory f = IRIFactory.jenaImplementation();
		IRI base = f.create("http://example.org/");
		IRI frag = base.resolve("outbind://4-00000000C45F478BF9F2A048A7A59DE"+
				"3AE35F7230700D3E3AEE226D20A49A390BCD779EC5D4700"+
				"00003DB3650000D3E3AEE226D20A49A390BCD779EC5D470"+
					"00001182DB0000/www.uconnectevent.org");
		Iterator <Violation>it = frag.violations(false);
		assertTrue(it.hasNext()) ;
		
//		while (it.hasNext()) {
//			System.err.println(it.next().getLongMessage());
//		}
		
	}
}
