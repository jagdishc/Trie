/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.trie;

/**
 *
 * @author Jagdish
 */
public class Trie {
    private Node root;
    
    public Trie(){
        root = new Node(' ');
    }
    
    public void insert(String s,String name){
        Node current = root;
        int length = s.length();
        if(length == 0){
            current.marker = true;
            current.name = name;
        }
        if(!search(s)){        
            for(int i =0;i<length;i++){
                Node child = current.subNode(s.charAt(i));
            
                if(child!=null){
                    current = child;
                }else{
                    current.child.add(new Node(s.charAt(i)));
                    current = current.subNode(s.charAt(i));
                }
            
                if(i==length-1){
                    current.marker = true;
                    current.name = name;
                }
            }
        }
    }
    
    public boolean search(String s){
        Node current = root;
        int length = s.length();
        while(current != null){
            for(int i=0;i<length;i++){
                if(current.subNode(s.charAt(i)) == null){
                    return false;
                }else{
                    current = current.subNode(s.charAt(i));
                }
            }
            
            if(current.marker == true){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    
    public String getName(String s){
        Node current = root;
        int length = s.length();
        while(current != null){
            for(int i=0;i<length;i++){
                if(current.marker == true){
                    return current.name;
                }
                current = current.subNode(s.charAt(i));
                if(current == null){
                    return null;
                }
            }
        }
        return null;
    }
}
