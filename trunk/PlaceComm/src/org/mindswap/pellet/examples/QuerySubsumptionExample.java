// Copyright (c) 2006 - 2008, Clark & Parsia, LLC. <http://www.clarkparsia.com>
// This source code is available under the terms of the Affero General Public License v3.
//
// Please see LICENSE.txt for full license terms, including the availability of proprietary exceptions.
// Questions, comments, or requests for clarification: licensing@clarkparsia.com

package org.mindswap.pellet.examples;

import java.util.Iterator;

import org.mindswap.pellet.KnowledgeBase;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.mindswap.pellet.query.Query;
import org.mindswap.pellet.query.QueryEngine;
import org.mindswap.pellet.query.QueryParser;
import org.mindswap.pellet.query.QueryResultBinding;
import org.mindswap.pellet.query.QueryResults;

import aterm.ATermAppl;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;

/**
 * Example program to demonstrate the query subsumption (query containment)
 * capabilities of Pellet. Query subsumption service reports if the answers to a
 * query would be contained in the answers of another query. It is similar to
 * concept subsumption service but applies to conjunctive queries. The examples
 * in this sample program show both concept subsumption and concept equivalence
 * services. The examples also show how to get the mapping between query
 * variables if the subsumption holds.
 * 
 * @author Evren Sirin
 */
public class QuerySubsumptionExample {
	//String			ont		= "http://owldl.com/ontologies/family.owl";
    String			ont		= "http://www.tuannguyen.mobi/ontologies/family.owl";
	String			family	= "http://www.example.org/family#";
	String			prefix	= "PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
									+ "PREFIX family: <" + family + ">\r\n" + "SELECT * { ";
	String			suffix	= " }";
	KnowledgeBase	kb;
	QueryParser		parser;

	public static void main(String[] args) throws Exception {
		new QuerySubsumptionExample().run();
	}

	public QuerySubsumptionExample() {
		OntModel model = ModelFactory.createOntologyModel( PelletReasonerFactory.THE_SPEC );
		model.read( ont );
		model.prepare();
		
		kb = ((PelletInfGraph) model.getGraph()).getKB();
		parser = QueryEngine.createParser();
	}

	public Query query(String queryStr) {
		return parser.parse( prefix + queryStr + suffix, kb );
	}

	public void run() {
		example1();

		example2();

		example3();

		example4();
	}

	/**
	 * Simple query subsumption similar to standard concept subsumption. Every
	 * Male is a Person so query 1 is subsumed by query 2. The converse is
	 * obviously not true.
	 */
	public void example1() {
		Query q1 = query( "?x a family:Male ." );
		Query q2 = query( "?x a family:Person ." );

		System.out.println( "Example 1" );
		System.out.println( "=========" );
		System.out.println( "Query 1: " + q1.toString( false ) );
		System.out.println( "Query 2: " + q2.toString( false ) );
		System.out.println();
		System.out
				.println( "Query 1 is subsumed by query 2: " + QueryEngine.isSubsumedBy( q1, q2 ) );
		System.out
				.println( "Query 2 is subsumed by query 1: " + QueryEngine.isSubsumedBy( q2, q1 ) );
		System.out.println();
	}

	/**
	 * Another example of subsumption. First query asks for all people married
	 * to Male individuals which is subsumed by the second query which asks for
	 * all Females.
	 */
	public void example2() {
		Query q3 = query( "?x family:isMarriedTo ?y . ?y rdf:type family:Male" );
		Query q4 = query( "?x a family:Female ." );

		System.out.println( "Example 2" );
		System.out.println( "=========" );
		System.out.println( "Query 3: " + q3.toString( false ) );
		System.out.println( "Query 4: " + q4.toString( false ) );
		System.out.println();
		System.out
				.println( "Query 3 is subsumed by query 4: " + QueryEngine.isSubsumedBy( q3, q4 ) );
		System.out
				.println( "Query 4 is subsumed by query 3: " + QueryEngine.isSubsumedBy( q4, q3 ) );
		System.out.println();
	}

	/**
	 * Example showing query equivalence. The subproperty relation between
	 * hasFather and hasParent properties would normally establish subsumption
	 * in one way but due to cardinality restrictions defined in the ontology
	 * two queries end up being equivalent,
	 */
	public void example3() {
		Query q5 = query( "?x family:hasFather ?y . " );
		Query q6 = query( "?x family:hasParent ?y . ?y a family:Male ." );

		System.out.println();
		System.out.println( "Example 3" );
		System.out.println( "=========" );
		System.out.println( "Query 5: " + q5.toString( false ) );
		System.out.println( "Query 6: " + q6.toString( false ) );
		System.out.println();
		System.out
				.println( "Query 5 is subsumed by query 6: " + QueryEngine.isSubsumedBy( q5, q6 ) );
		System.out
				.println( "Query 6 is subsumed by query 5: " + QueryEngine.isSubsumedBy( q5, q6 ) );

		System.out.println( "Query 5 is equivalent to query 6: "
				+ QueryEngine.isEquivalent( q5, q6 ) );
		System.out.println();
	}

	/**
	 * The subsumption in this example holds because of the subproperty relation
	 * between hasBrother and hasSibling. however, The second query uses the
	 * variable name ?z instead of the the variable name ?y used in the first
	 * query. The query subsumption algorithm finds the mapping between query
	 * variables.
	 */
	public void example4() {
		Query q7 = query( "?x a family:Female; family:hasBrother ?y . " );
		Query q8 = query( "?x a family:Female; family:hasSibling ?z ." );

		System.out.println( "Example 4" );
		System.out.println( "=========" );
		System.out.println( "Query 7: " + q7.toString( false ) );
		System.out.println( "Query 8: " + q8.toString( false ) );
		System.out.println();
		System.out
				.println( "Query 7 is subsumed by query 8: " + QueryEngine.isSubsumedBy( q7, q8 ) );

		System.out.print( "Subsumption mappings: " );
		QueryResults mappings = QueryEngine.getSubsumptionMappings( q7, q8 );		
		QueryResultBinding mapping = mappings.get( 0 );
		for( Iterator<?> j = q8.getVars().iterator(); j.hasNext(); ) {
			ATermAppl var = (ATermAppl) j.next();
			System.out.print( var.getArgument( 0 ) + " -> " + mapping.getValue( var ) );
			if( j.hasNext() )
				System.out.print( ", " );
		}
		System.out.println();		
		System.out.println();
	}
}
