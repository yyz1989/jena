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

package com.hp.hpl.jena.tdb.setup;

import com.hp.hpl.jena.tdb.base.block.FileMode ;

/** Store parameters that can be adjusted after a store has been created,
 *  and given different values when the JVM attaches to a store area. 
 *  (They are still fixed for any given database once created in a JVM.) 
 */

public interface StoreParamsDynamic {
    
    /** Store-wide file access mode */ 
    public FileMode getFileMode() ;
    
    /** Block size - must agree with the original creation of the database */ 
    public int getBlockSize() ;

    /** Block read cache (note: mapped files do not have a block cache) */
    public int getBlockReadCacheSize() ;

    /** Block write cache (note: mapped files do not have a block cache) */
    public int getBlockWriteCacheSize() ;
    
    /** Node cache for Node->NodeId. */
    public int getNode2NodeIdCacheSize() ;
    
    /** Node cache for NodeId->Node. Important for SPARQL results. */
    public int getNodeId2NodeCacheSize() ;

    /** Node cache for recording known misses */
    public int getNodeMissCacheSize() ;
}

