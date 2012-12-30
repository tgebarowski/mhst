/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst;

import java.util.LinkedList;
import java.util.Queue;
import mhst.model.Graph;
import mhst.model.Graph.Node;

/**
 * Breadth First Search
 * @author Tomasz Gebarowski <gebarowski@gmail.com>
 * 
 * Pseudo code:
 * 
 * BFS(in:V,Adj,k,out:π,d)
 * {
 *   foreach(u ∈ V \ {k})
 *   {
 *      color[u] := white;
 *      d[u] := ∞;
 *      d[u] := NIL;
 *   } 
 *   color[k] := gray;
 *   d[k] := 0;
 *   π[k] := NIL;
 *   Q := [ k ];
 * 
 *   while(Q ̸= ∅) {
 * 
 *    u :=	Head(Q);
 *    foreach(v ∈ Adj [u])
 *    {
 *       if(color[v] = white) { 
 *          color[v] := gray;
 *          d[v] := d[u] + 1;
 *          π[v] := u;
 *          Enqueue(Q, v);
 *       }
 *    }
 *    Dequeue(Q);
 *    color[u] := black;
 *    }
 * }
 * 
 */
public class BFS {

    Graph mGraph;
    
    /**
     * Create Breadth First Search object
     * @param g Graph on which BFS is performed
     */
    public BFS(Graph g) {
        mGraph = g;
    }
    
    /**
     * Perform BFS search
     */
    public void run(Node root) {
        
        Queue<Node> q = new LinkedList();

        root.color = Graph.Colors.GREY;
        
        q.offer(root);

        while (!q.isEmpty()) {
            
            Node u = q.peek();
            LinkedList<Node> adjList = mGraph.getVerticesFor(u);
            
            if (adjList != null) {
                for (Node vv : adjList) {
                    
                    if (vv.color == Graph.Colors.WHITE) {
                        vv.color = Graph.Colors.GREY;
                        vv.distance = vv.distance + 1;
                        vv.path = u;
                        q.offer(vv);
                    }
                }
            }
            q.poll();
            
            u.color = Graph.Colors.BLACK;
        }
    }
}
