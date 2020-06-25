package com.datastructure;

import java.util.LinkedList; 
import java.util.Queue; 
public class GFG { 
       
    /* A binary tree node has key, pointer to  
    left child and a pointer to right child */
    static class Node { 
        int key; 
        Node left, right; 
          
        // constructor 
        Node(int key){ 
            this.key = key; 
            left = null; 
            right = null; 
        } 
    } 
    static Node root; 
    static Node temp = root; 
    static Node lastNode = null;
      
    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp) 
    { 
        if (temp == null) {
            return; 
        }
       
        lastNode = temp;
        inorder(temp.left); 
        System.out.print(temp.key+" "); 
        inorder(temp.right); 
    } 
       
    /*function to insert element in binary tree */
    static void delete(Node temp, int key) 
    { 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(temp); 
       
        // Do level order traversal until we find 
        // an empty place.  
        while (!q.isEmpty()) { 
            temp = q.peek(); 
            q.remove(); 
            if (temp.key == key) { 
            	Node newNode = new Node(lastNode.key);
            	newNode.left = temp.left;
                temp.right = temp.right;
                temp = null;
                lastNode = null;
                break; 
            } 
            if(temp.left != null){
            	q.add(temp.left);
            }
            if(temp.right != null){
            	q.add(temp.right);
            }
        } 
    } 
    
    private static void deleteNode(Node root, int key){
    	Queue<Node> q = new LinkedList<Node>(); 
        q.add(root); 
        
        while (!q.isEmpty()) { 
        	root = q.peek(); 
            q.remove(); 
            
            if(root.key == key){
            	
            }
           
        }
    }
       
    // Driver code 
    public static void main(String args[]) 
    { 
        root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.left.right = new Node(13); 
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8); 
       
        System.out.print( "Inorder traversal before deletion:"); 
        inorder(root); 
       
        int key = 11; 
        delete(root, key); 
       
        System.out.print("\nInorder traversal after deletion:"); 
        inorder(root); 
    } 
} 
