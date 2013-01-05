/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst;

import java.util.HashMap;
import mhst.model.Graph;
import mhst.model.Graph.Node;
import mhst.model.Tree;

/**
 *
 * @author Tomasz Gebarowski <gebarowski@gmail.com>
 */
public class MHST {
    
    Tree run(Graph graph) {
        
        Tree mhst;
        HashMap<Graph.Node, Integer> eccentricity = new HashMap<Graph.Node, Integer>();
        
        Tree.TreeNode<Integer> rootTree = new Tree.TreeNode<Integer>();
        Node pathTree = null;
        Integer heightTree = Integer.MAX_VALUE;
        
        /* For each vertex in graph */
        for (Node k : graph.getVertices()) {
            eccentricity.put(k, 0);
            
            BFS bfs = new BFS(graph);
        
            /* run BFS on node n */
            bfs.run(k);
            
            /* For each node in graph */
            for (Node u : graph.getVertices()) {
                if (eccentricity.get(k) < u.distance) {
                    eccentricity.put(k, u.distance);
                }
            }
            
            if (eccentricity.get(k) < heightTree) {
                heightTree = eccentricity.get(k);
                rootTree.data = k.value;
                pathTree = k.parent;
            }
        }
        
        mhst = new Tree(rootTree);
        
        return mhst;
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
