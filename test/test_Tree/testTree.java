/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test_Tree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tp1_modelisation_probs.ArbreNAire;

/**
 *
 * @author Admin
 */
public class testTree {
	
	public testTree() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void hello() {
		ArbreNAire arbre = new ArbreNAire("racine");
		arbre.addFils("fils");
		arbre.addFils("fils2");
	}
}
