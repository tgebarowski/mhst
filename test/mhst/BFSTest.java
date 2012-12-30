/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst;

import mhst.model.Graph;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomaszgebarowski
 */
public class BFSTest {
    
    public BFSTest() {
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
    public void testRun() {
        
        Graph graph = new Graph();

        if (!graph.loadFromFile(getClass().getResourceAsStream("model/data/graph1.txt"))) {
            fail("Could not load graph from file");
        }
        
        BFS bfs = new BFS(graph);
        
        /* Run from node: 1 */
        bfs.run(graph.new Node(1));
        
    }
}
