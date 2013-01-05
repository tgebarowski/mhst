/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst.model;

import java.io.File;
import mhst.model.Tree.TreeNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tomasz Gebarowski <gebarowski@gmail.com>
 */
public class TreeTest {
    
    public TreeTest() {
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

    /**
     * Test of addNode method, of class Tree.
     */
    @Test
    public void testAddNode() {
        System.out.println("addNode");
        TreeNode<Integer> root = new TreeNode<Integer>(0);
        TreeNode<Integer> c1 = new TreeNode<Integer>(1);      
        TreeNode<Integer> c2 = new TreeNode<Integer>(2);           
        TreeNode<Integer> c3 = new TreeNode<Integer>(3);

        
        Tree t = new Tree(root);
        
        t.addNode(root, c1);
        t.addNode(root, c2);
        t.addNode(c2, c3);        
    }
    
    /**
     * Test of dumpToString method, of class Tree.
     */
    @Test
    public void testDumpToString() {
        System.out.println("dumpToFile");
        TreeNode<Integer> root = new TreeNode<Integer>(0);
        TreeNode<Integer> c1 = new TreeNode<Integer>(1);      
        TreeNode<Integer> c2 = new TreeNode<Integer>(2);           
        TreeNode<Integer> c3 = new TreeNode<Integer>(3);
        
        Tree t = new Tree(root);
        
        t.addNode(root, c1);
        t.addNode(root, c2);
        t.addNode(c2, c3);        
        
        System.out.println(t.dumpToString());
    }

    /**
     * Test of dumpToFile method, of class Tree.
     */
    @Test
    public void testDumpToFile() {
        System.out.println("dumpToFile");
        TreeNode<Integer> root = new TreeNode<Integer>(0);
        TreeNode<Integer> c1 = new TreeNode<Integer>(1);      
        TreeNode<Integer> c2 = new TreeNode<Integer>(2);           
        TreeNode<Integer> c3 = new TreeNode<Integer>(3);
        
        Tree t = new Tree(root);
        
        t.addNode(root, c1);
        t.addNode(root, c2);
        t.addNode(c2, c3);    
        
        t.dumpToFile(new File("out.txt"));
    }
}
