/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst.model;

import mhst.model.Graph.Node;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tomasz Gebarowski <gebarowski@gmail.com>
 */
public class GraphTest {

    
    public GraphTest() {
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
    public void testLoadFromFile() {
        
        Graph graph = new Graph();
        
        if (!graph.loadFromFile(getClass().getResourceAsStream("data/graph1.txt"))) {
            fail("Could not load graph from file");
        }
        
    }
    
    @Test
    public void testIsConnected() {
        
        Graph graph = new Graph();
        
        if (!graph.loadFromFile(getClass().getResourceAsStream("data/graph1.txt"))) {
            fail("Could not load graph from file");
        }
        
        if (!graph.isConnected(graph.new Node(1), graph.new Node(2))) {
            fail("(1,2) not connected but should");
        }
        if (!graph.isConnected(graph.new Node(1), graph.new Node(3))) {
            fail("(1,3) not connected but should");
        } 
        if (!graph.isConnected(graph.new Node(2), graph.new Node(3))) {
            fail("(2,3) not connected but should");
        }        
        if (graph.isConnected(graph.new Node(3), graph.new Node(4))) {
            fail("(3,4) not connected but should");
        }
    }
}
