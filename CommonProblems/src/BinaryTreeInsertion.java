import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeInsertion {
	Node root;
	
	public BinaryTreeInsertion() {
		root = null;
	}
	
	private void insetData(int data){
		if(root == null){
			root = new Node(data);
			return;
		}
		
		Queue<Node> nodeList = new LinkedList<Node>();
		nodeList.add(root);
		
		while(true){
			Node node = nodeList.poll();
			
			if(node.left == null){
				node.left = new Node(data);
				return;
			}
			
			if(node.right == null){
				node.right = new Node(data);
				return;
			}
			
			nodeList.add(node.left);
			nodeList.add(node.right);
		}
	}
	
	private void levelOrderTraversal(){
		Queue<Node> nodeList  = new LinkedList<Node>();
		nodeList.add(root);
		while(!nodeList.isEmpty()){
			Node node = nodeList.poll();
			System.out.print(node.item + " ");
			
			if(node.left != null){
				nodeList.add(node.left);
			}
			if(node.right != null){
				nodeList.add(node.right);
			}
		}
	}
	
	private void inorderTraversal(Node root){
		if(root == null){
			return;
		}
		
		inorderTraversal(root.left);
		System.out.print(root.item + " ");
		inorderTraversal(root.right);
	}
	
	private void preorderTraversal(Node root){
		if(root == null){
			return;
		}
		
		System.out.print(root.item + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	private void postorderTraversal(Node root){
		if(root == null){
			return;
		}
		
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.item + " ");
	}
	
	public static void main(String[] args){
		BinaryTreeInsertion binaryTreeInsertion = new BinaryTreeInsertion();
		for(int i=0; i<10; i++){
			binaryTreeInsertion.insetData(i+1);
		}
		
	
		System.out.print("Level order Traversal : ");
		binaryTreeInsertion.levelOrderTraversal();
		System.out.println();
		System.out.print("Inorder Traversal : ");
		binaryTreeInsertion.inorderTraversal(binaryTreeInsertion.root);
		System.out.println();
		System.out.print("Preorder Traversal : ");
		binaryTreeInsertion.preorderTraversal(binaryTreeInsertion.root);
		System.out.println();
		System.out.print("Postorder Traversal : ");
		binaryTreeInsertion.postorderTraversal(binaryTreeInsertion.root);
		
	}
}


/*class Node{
	int item;
	Node left,right;
	
	public Node(int item) {
		this.item = item;
		left = right = null;
	}
}*/
