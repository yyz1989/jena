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

package com.hp.hpl.jena.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.hp.hpl.jena.util.cache.Cache;
import com.hp.hpl.jena.util.cache.CacheManager;


public class TestCache
    {    
    static String cacheType;

    @BeforeClass
    public static void setUp() {
        cacheType = CacheManager.RAND;
        // cacheType = CacheManager.ENHNODECACHE;
    }
    
    @Test
    public void testCache() {        
        testCacheSimpleReturn(cacheType);
        testFillTheCache(cacheType);
    }

    @Test(expected=Error.class)
    public void testCacheCreation() {
        /* Cache c1 = */ CacheManager.createCache(cacheType, "c1", 100);
        // cache size (1) is too small!
        /* Cache c2 = */ CacheManager.createCache(cacheType, "c2", 1);
    }

    protected void testCacheSimpleReturn(String type) {
        
        int size = 100;
        // this test does not fill the cache
        Cache c1 = CacheManager.createCache(type, "c1", size);
        
        String  k1 = "one";
        String  k2 = k1;
        String  k3 = k2;
        Integer v1 = -1;
        Integer v2 = v1;
        Integer v3 = v2;
        c1.put(k1, v1);

        for (int i=0; i<size; i++) {
            k1 = k2;
            v1 = v2;
            Object o = c1.get(k1);
            assertTrue("expected a hit", o != null);
            assertEquals("should be the expected object", o, v1);
            k2 = k3;
            v2 = v3;
            o = c1.get(k2);
            assertTrue("expected a hit", o != null);
            assertEquals("should be the expected object", o, v2);
            
            k3 = "T" + i;
            v3 = i;
            c1.put(k3,v3);
        }
    }

    protected void testFillTheCache(String type) {
        final int size = 100;
        Cache c1 = CacheManager.createCache(type, "c1", size);
        String[] k = new String[size];
        String[] v = new String[size];
        
        for (int i=0; i<size; i++) {
            k[i] = "K" + i;
            v[i] = "V" + i;
            c1.put(k[i], v[i]);
        }
        
        int count = 0;
        
        for (int i=0; i<size; i++) {
            if (c1.get(k[i]) != null) {
                count++;
            }
        }
        
        assertTrue("too low a hit rate: " + type + " = " + count, 
                                                               count > size/2);
        assertEquals("count puts", size, c1.getPuts());
        assertEquals("count gets", size, c1.getGets());
        assertEquals("count hits", count, c1.getHits());
    }
}
        
