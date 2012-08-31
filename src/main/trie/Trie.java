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
public class Trie {
    private Node root;
    private NameMap contactDetails;
    /**
     Constructor for the Trie class.
     */
    public Trie(){
        root = new Node(' ',null);
        contactDetails = new NameMap();
    }
    /**
     * Method to insert phone number into the Trie DS.
     * @param s is the phone number to be stored
     * @param name is the name of the person
     */
    public void insert(String s,String name){
        Node current = root;
        int length = s.length();
        if(length == 0){
            current.marker = true;
            
        }
        if(!search(s)){        
            for(int i =0;i<length;i++){
                Node child = current.subNode(s.charAt(i));
            
                if(child!=null){
                    current = child;
                }else{                    
                    current.child.add(new Node(s.charAt(i), current));                    
                    current = current.subNode(s.charAt(i));
                }
            
                if(i==length-1){
                    current.marker = true;
                    contactDetails.setDetails(current, name, length);
                }
            }
        }
    }
    /**
     * Method to search a phone number in the Trie. 
     * @param s is the phone number to be searched
     * @return true if phone number is found else returns false
     */
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
    /**
     * Method to get the name of the person if a phone number is given
     * @param s is the phone number for which the name is to be found
     * @return null if no name is there or the name of the person
     */
    public String getName(String s){
        Node current = root;
        int length = s.length();
        while(current != null){
            for(int i=0;i<length;i++){
                if(current.marker == true){
                   HashMap<String, Integer> details = contactDetails.getDetails(current);
                   String name = details.keySet().iterator().next().toString();
                   return name;
                }
                current = current.subNode(s.charAt(i));
                if(current == null){
                    return null;
                }
            }
        }
        return null;
    }
    /**
     * Method to get the phone number if name is given
     * @param name is the name for which the phone number is to be found
     * @return null if no number is found or the corresponding number
     */
    public ArrayList<String> getNumber(String name){
        ArrayList<HashMap<Node, Integer>> result = contactDetails.getNameMap(name);
        ArrayList<String> numbers = new ArrayList<String>();
        if(result.size()>0){
            for(Iterator<HashMap<Node, Integer>> it = result.iterator();it.hasNext();){
                HashMap<Node, Integer> temp = it.next();
                if(temp.size()>0){
                    Node current = (Node)temp.keySet().iterator().next();
                    int length = temp.get(current);
                    int i = 0;
                    String phone = "";
                    while(i<length){
                        phone += current.content;
                        i += 1;
                        current = current.parent;
                    }
                    String ph = new StringBuffer(phone).reverse().toString();
                    numbers.add(ph);               
                }
            }
        }
        return numbers;
    }
}
