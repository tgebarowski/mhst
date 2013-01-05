/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mhst;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import mhst.model.Graph;
import mhst.model.Tree;

/**
 * MHST application
 * @author Tomasz Gebarowski <gebarowski@gmail.com>
 */
public class MhstApp {
    
    
    /**
     * Parse command line arguments and display help screen if needed
     * @param args 
     */
    public static boolean parseArguments(String[] args, String inFile, String outFile) {
        
        boolean status = false;
        
        if (args.length == 2) {
            inFile = args[0];
            outFile = args[1];
            status = true;
        }
        else
        {
            System.out.println("Minimal height spanning tree");
            System.out.println("Usage: ./mhst input-graph output-tree");
        }
        return status;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String inFile = "", outFile = "";
        
        if (!parseArguments(args, inFile, outFile))
            return;
        
        MHST mhst = new MHST();
        Graph inGraph = new Graph();
        InputStream stream;
        
        try {
            stream = new FileInputStream(new File(inFile));
            
            if (inGraph.loadFromFile(stream))
            {
                Tree t = mhst.run(inGraph);
                
                t.dumpToFile(new File(inFile));
            }
   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MhstApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
