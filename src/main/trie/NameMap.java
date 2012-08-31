/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Jagdish
 */
public class NameMap {
    
    HashMap<Node, HashMap<String, Integer>> details;
    
    public NameMap(){
        details = new HashMap<Node, HashMap<String, Integer>>();
    }
    
    public void setDetails(Node node, String name, int length){
        if(!details.containsKey(node)){
            HashMap<String, Integer> temp = new HashMap<String, Integer>();
            if(!temp.containsKey(name)){
                temp.put(name, length);
            }
            details.put(node, temp);
        }
    }
    
    public HashMap<String, Integer> getDetails(Node node){
        if(details.containsKey(node)){
            return details.get(node);
        }
        return null;
    }
    
    public ArrayList<HashMap<Node, Integer>> getNameMap(String name){
        ArrayList result = new ArrayList<HashMap<Node, Integer>>();
        for(Iterator<Node> it = details.keySet().iterator();it.hasNext();){
            Node temp = it.next();
            HashMap<String, Integer> names = details.get(temp);
            for(Iterator<String> iter = names.keySet().iterator();iter.hasNext();){
                String nm = iter.next();
                if(nm.equals(name)){
                    HashMap<Node, Integer> t = new HashMap<Node, Integer>();
                    if(!t.containsKey(temp)){
                        t.put(temp, names.get(nm));
                    }
                    result.add(t);
                }
            }
        }
        return result;
    }
}
