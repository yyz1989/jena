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

package com.hp.hpl.jena.query.larq;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.hp.hpl.jena.assembler.Assembler;
import com.hp.hpl.jena.assembler.Mode;
import com.hp.hpl.jena.assembler.assemblers.AssemblerBase;
import com.hp.hpl.jena.assembler.exceptions.AssemblerException;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.core.assembler.DatasetAssemblerVocab;
import com.hp.hpl.jena.sparql.util.graph.GraphUtils;

public class AssemblerLARQ extends AssemblerBase implements Assembler
{
    /** Vocabulary
     *     ja:textIndex ....
     */

    static { LARQ.init(); }
    
    @Override
    public Object open(Assembler a, Resource root, Mode mode)
    {
        LARQ.init();

        if ( ! GraphUtils.exactlyOneProperty(root, DatasetAssemblerVocab.pIndex) )
            throw new AssemblerException(root, "Required: exactly one index property" ) ;

        try
        {
            String indexPath = GraphUtils.getAsStringValue(root, DatasetAssemblerVocab.pIndex) ;
            return make(null, indexPath) ;
        } catch (Exception ex)
        {
            throw new ARQLuceneException("Failed to assemble Lucene index", ex) ;
        }
    }
    
    public static IndexLARQ make (Dataset dataset, String indexPath) throws CorruptIndexException, IOException 
    {
        Directory directory = FSDirectory.getDirectory(new File(indexPath)) ;
        IndexReader indexReader = null;
        if ( dataset != null ) {
            IndexWriter indexWriter = new IndexWriter(directory, new StandardAnalyzer());
            IndexBuilderModel larqBuilder = new IndexBuilderString(indexWriter) ; 
            dataset.getDefaultModel().register(larqBuilder);
            for ( Iterator<String> iter = dataset.listNames() ; iter.hasNext() ; ) {
                String g = iter.next() ;
                dataset.getNamedModel(g).register(larqBuilder) ;
            }
            indexReader = IndexReader.open(directory) ;
        } else {
            indexReader = IndexReader.open(directory) ;
        }
        IndexLARQ indexLARQ = new IndexLARQ(indexReader) ;
        LARQ.setDefaultIndex(indexLARQ) ;
        return indexLARQ ;
    }

}