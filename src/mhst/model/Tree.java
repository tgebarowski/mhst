/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of Tree datatype
 * 
 * @author Tomasz Gebarowski <gebarowski@gmail.com>
 */
public class Tree<T> {
    
    private TreeNode<T> mRoot;
    
    /**
     * Tree constructor taking as argument root TreeNode
     * @param node Root of the tree
     */
    public Tree(TreeNode node) {
        mRoot = node;
    }

    /**
     * Tree constructor taking as argument root node value
     * @param rootData 
     */
    public Tree(T rootData) {
        mRoot = new TreeNode<T>(rootData);
        mRoot.mChildren = new ArrayList<TreeNode<T>>();
    }
    
    /**
     * Add child to parent
     * @param parent Parent to which child is appended
     * @param child Child appended to parent
     */
    public void addNode(TreeNode parent, TreeNode child) {
        parent.mChildren.add(child);
        child.mParent = parent;
    }
    
    /**
     * Dump tree to string
     * 
     * Tree:
     *    0
     *   / \
     *   1  2
     *       \ 
     *        3
     * 
     * is mapped to:
     * 
     * 0 1 2
     * 2 3
     * 
     * 
     * @return String representation of tree according to above pattern
     */
    public String dumpToString() {
        return dumpTreeNode(mRoot);
    }
    
    /**
     * Dump tree into file
     * @param file 
     */
    public void dumpToFile(File file) {
        
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
            buffer.write(dumpToString());
            buffer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Dump node to string.
     * Node is printed first, all its children are enumerated as space separated values
     * @param n
     * @return 
     */
    private String dumpTreeNode(TreeNode<T> n) {
        
        String out = "";
        
        if (n.mChildren == null) {
            return out;
        }
        else
        {
            /* Do not print nodes without children */
            if (n.mChildren.size() > 0) {
                out += n.toString();    
            }
            for (TreeNode c : n.mChildren) {
                out += dumpTreeNode(c);
            }
        }
        
        return out;
    }
    

    /**
     * Internal representation of TreeNode
     * @param <T> 
     */
    public static class TreeNode<T> {
        public T data;
        private TreeNode<T> mParent;
        private List<TreeNode<T>> mChildren;
        
        public TreeNode(T d) {
            this.data = d;
            this.mParent = null;
            this.mChildren = new ArrayList<TreeNode<T>>();
        }
        
        
        @Override
        public String toString() {
            String childrenString = "";
            
            for (TreeNode n : this.mChildren) {
                childrenString += " " + n.data.toString();
            } 
            return data.toString() + childrenString + '\n';
        }
    }
}


