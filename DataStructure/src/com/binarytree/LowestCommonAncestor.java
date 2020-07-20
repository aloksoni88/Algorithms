package com.binarytree;

public class LowestCommonAncestor {
	
	private Node node;
	private boolean isN1Present, isN2Present;
	
	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
        lca.node = new Node(1); 
        lca.node.left = new Node(2); 
        lca.node.right = new Node(3); 
        lca.node.left.left = new Node(4); 
        lca.node.left.right = new Node(5); 
        lca.node.right.left = new Node(6); 
        lca.node.right.right = new Node(7); 
        
//		lca.node = new Node(1);
//		lca.node.left = new Node(2);
//		lca.node.right = new Node(3);
//		lca.node.left.left = new Node(4);
//		lca.node.left.right = new Node(5);
//		lca.node.right.left = new Node(6);
//		lca.node.right.right = new Node(7);
//		lca.node.left.left.left = new Node(8);
//		lca.node.left.left.right = new Node(9);
		
		int output = lca.findLCA(1,7);
		System.out.println("Output : " + output);
	}
	
	private int findLCA(int n1, int n2) {
		Node resultNode  = findLCA(node,n1, n2);
		if(isN1Present && isN2Present) {
			return resultNode.key;
		}
		return -1;
	}
	
	private Node findLCA(Node node, int n1, int n2) {
		if(node == null) {
			return null;
		}
		
		//we should not return here node because if either of any node does not present in the tree
		//so it will give the answer as present node
//		if(node.key == n1 || node.key == n2) {
//			return node;
//		}
	
		Node tmp = null;
		if(node.key == n1) {
			isN1Present = true;
			tmp = node;
		}
		if(node.key == n2) {
			isN2Present = true;
			tmp = node;
		}
		
		Node lNode = findLCA(node.left, n1, n2);
		Node rNode = findLCA(node.right,n1, n2);
		
		if(tmp != null) {
			return tmp;
		}
	
		
		if(lNode != null && rNode != null) {
			return node;
		}
		
		return lNode != null ? lNode : rNode;
	}
}
