/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Graph class implemented as adjacency list
 * 
 * @author Tomasz Gebarowski <gebarowski@gmail.com>
 */
public class Graph {
    
    public enum Colors {
        WHITE,
        GREY,
        BLACK
    }
    
    /**
     * Node representation in a Graph
     */
    public class Node {
 
        public int value;
        
        public Colors color; /**< Node color */
        public int distance; /**< Distance to root */
        public Node path;  /**< Previous node on path */
        
        
        /**
         * Create new Node and initialize it with value
         * 
         * @param value 
         */
        public Node(int value) {
            this.color = Graph.Colors.WHITE;
            this.distance = Integer.MAX_VALUE;
            this.path = null;
            this.value = value;
        }
        
        /**
         * Print node content
         */
        public void print() {
            System.out.println(toString());
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        
        @Override
        public boolean equals(Object obj) {
            return toString().equals(obj.toString());
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 59 * hash + this.value;
            return hash;
        }
    }
    
    
    private HashMap<Node, LinkedList<Node>> mVertices; /**< List of adjacent nodes for each vertex */
    
    /**
     * Graph object constructor
     */
    public Graph() {
        mVertices = new HashMap<Node, LinkedList<Node>>();
    }
    
    
    /**
     * Load Graph content from a file
     * File must have the following syntax to map the graph below
     * 
     * 1 2 3
     * 2 3
     * 3 1
     * 
     * 1 -> 2 -> 3
     * <--------->
     * 
     * @param path Path to file with graph content
     * @return True when graph was loaded successfully
     */
    public boolean loadFromFile(InputStream stream) {
        
        boolean result = true;
        
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
            String line;
             
            /* Read list of neighbours for each vertex */
            while ( (line = buffer.readLine()) != null) 
            {
                String[] vertices = line.split(" ");
                
                Node keyVertex = new Node(-1);
                
                if (vertices.length > 0) {
                    keyVertex.value = Integer.parseInt(vertices[0]);
                }
                
                if (keyVertex.value > 0) {
                    for (String v : vertices) {
                        Node v2 = new Node(Integer.valueOf(v).intValue());
                        
                        if (!v2.equals(keyVertex)) {
                            setConnection(keyVertex, v2);
                        }
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
            result = false;
        }
        
        return true;
    }
    
    /**
     * Returns a set of all vertices in graph
     * @return Set<Integer>
     */
    public Set<Node> getVertices() {
        return mVertices.keySet();
    }
    
    /**
     * Returns a set of all adjacent vertices for specified vertex
     * 
     * @param vertex Vertex for which adjacency list is returned
     * @return Set<Integer>
     */
    public LinkedList<Node> getVerticesFor(Node vertex) {
        return mVertices.get(vertex);
    }
    
    /**
     * Return number of vertices in a graph
     * @return Vertex count
     */
    public int getVertexCount() {
        return mVertices.keySet().size();
    }
    
    /**
     * Check if vertices are connected (A->B)
     * @param a Vertice A
     * @param b Vertice B
     */
    public boolean isConnected(Node a, Node b) {
        
        if (!mVertices.containsKey(a)) {
            return false;
        }
        
        LinkedList<Node> vertices = mVertices.get(a);
        if (vertices != null) {
            for (Node v : vertices) {
                if (v.equals(b)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Set connection (A->B) between vertices
     * @param a Vertice A
     * @param b Vertice B
     */
    public void setConnection(Node a, Node b) {
        
        if (!mVertices.containsKey(a)) {
            mVertices.put(a, new LinkedList<Node>());
        }
        mVertices.get(a).add(b);
    }
    
}
