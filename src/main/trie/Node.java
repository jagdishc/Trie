/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.trie;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author Jagdish
 */
public class Node {
    char content;
    boolean marker;
    Node parent;
    Collection<Node> child;
    
    public Node(){
        
    }
    
    public Node(char c, Node current){
        child = new LinkedList<Node>();
        marker = false;
        parent = current;
        content = c;
    }
    
    public Node subNode(char c){
        if(child!=null){
            for(Node eachChild:child){
                if(eachChild.content == c){
                    return eachChild;
                }
            }
        }
        return null;
    }
    
    public Node getParent(Node child){
        if(child!=null){
            return child.parent;
        }
        return null;
    }
}
