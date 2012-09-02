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
    
    public Node(){ }
    
    /**
     * Constructor to create a Node
     * @param c is the character to be stored in the Node
     * @param current is the parent node to the Node that is going to be created
     */
    public Node(char c, Node current){
        child = new LinkedList<Node>();
        marker = false;
        parent = current;
        content = c;
    }
    /**
     * Method that returns the corresponding sub node of the current node
     * @param c is the content value of the sub node
     * @return null if the node is not found or returns the corresponding sub node
     */
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
    /**
     * 
     * @param child
     * @return 
     */
    public Node getParent(Node child){
        if(child!=null){
            return child.parent;
        }
        return null;
    }
}
