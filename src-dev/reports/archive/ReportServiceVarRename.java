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

package reports.archive;

import com.hp.hpl.jena.query.Query ;
import com.hp.hpl.jena.query.QueryFactory ;
import com.hp.hpl.jena.sparql.algebra.Algebra ;
import com.hp.hpl.jena.sparql.algebra.Op ;

import org.openjena.atlas.lib.StrUtils ;

public class ReportServiceVarRename
{
    public static void main(String[] args)
    {
        String qs = StrUtils.strjoinNL("SELECT DISTINCT ?s",
                                       "{ SERVICE <http://dbpedia.org/sparql>",
                                       "    { SELECT ?s { ?s <http://xmlns.com/foaf/0.1/knows> ?o . } limit 10 }",
                                       "}") ;
        Query query = QueryFactory.create(qs) ;
        Op op = Algebra.compile(query) ;
        Op op2 = Algebra.optimize(op) ;
        System.out.println(op) ;
        System.out.println(op2) ;
        System.exit(0) ;
    }

}