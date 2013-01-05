/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Tree datatype
 * 
 * @author Tomasz Gebarowski <gebarowski@gmail.com>
 */
public class Tree<T> {
    
    private TreeNode<T> mRoot;

    public Tree(T rootData) {
        mRoot = new TreeNode<T>();
        mRoot.data = rootData;
        mRoot.children = new ArrayList<TreeNode<T>>();
    }
    
    /**
     * Add child to parent
     * @param parent Parent to which child is appended
     * @param child Child appended to parent
     */
    public void addNode(TreeNode parent, TreeNode child) {
        parent.children.add(child);
        child.parent = parent;
    }

    public static class TreeNode<T> {
        public T data;
        private TreeNode<T> parent;
        private List<TreeNode<T>> children;
    }
}


