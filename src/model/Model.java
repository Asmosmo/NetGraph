/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import fr.ece.fauberte.fakeroute.trace.FakeTraceGenerator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kevin
 */
public class Model {
    

    /**
     * @param dest
     * @param args the command line arguments
     * @throws java.net.UnknownHostException
     */
    public Model(){
    
    }
    
    public void createPng(String adr) throws UnknownHostException, IOException, InterruptedException {
        Process proc;
        FakeTraceGenerator generator;
        generator = new FakeTraceGenerator(adr);

           ArrayList<String> parents = new ArrayList<String>();
        ArrayList<String> children = new ArrayList<String>();
        String dot = new String("digraph mon_graphe {\n");

        BufferedReader buf = new BufferedReader(new StringReader(generator.generate()));
        System.out.println(generator.generate());
        String line = "";
        Pattern ipRegEx = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
        while ((line = buf.readLine()) != null) {
            System.out.println(line);
            Matcher ip = ipRegEx.matcher(line);
            while (ip.find()) {
                children.add(ip.group());
            }
            for (int i = 0; i < parents.size(); i++) {
                for (int j = 0; j < children.size(); j++) {
                    if (parents.get(i).compareTo(children.get(j)) != 0) {
                        System.out.println(parents.get(i) + "->" + children.get(j));
                    }
                    dot = dot + "\"" + parents.get(i) + "\"" + " -> " + "\"" + children.get(j) + "\"" + ";\n";
                }
            }
            parents.clear();
            parents.addAll(children);
            children.clear();
        }
        dot = dot + "}";
        System.out.println(dot);
        try (PrintWriter out = new PrintWriter("dotFile.dot")) {
            
            out.println(dot);   
            out.close();
            proc = Runtime.getRuntime().exec("dot -Tpng dotFile.dot -o graph.png");
            proc.waitFor();
        }
    }
    
}
