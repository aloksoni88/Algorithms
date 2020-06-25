import java.util.LinkedList;
import java.util.Queue;


public class LevelOrderTree {
	

		Node root;
		public LevelOrderTree() {
			root = null;
		}
		
		void printGivenLevelOrder(){
			int height = height(root);
			System.out.println("Height " + height);
			for(int i=1; i<= height; i++){
				printGivenLevelOrder(root, i);
				System.out.println("");
			}
				
		}
		
	
		private int height(Node root){
			if(root == null){
				return 0;
			}else{
		
				int lHeigth = height(root.left);
				int rHeight = height(root.right);
		
				if(lHeigth > rHeight)
					return (lHeigth+1);
				else
					return (rHeight+1);
			}
		}
		
		private void printGivenLevelOrder(Node root, int level){
			if(root == null){
				return;
			}else if(level == 1){
				System.out.print(root.item + " ");
			}else if(level > 1){
				printGivenLevelOrder(root.left, level-1);
				printGivenLevelOrder(root.right, level-1);
			}
		}
		
		private void insetElement(int data){
			root = insert(root,data);
		}
		
		private Node insert(Node root,int data){
			if(root == null){
				root = new Node(data);
			}else if(data <= root.item){
				root.left  = insert(root.left,data);
			}else{
				root.right = insert(root.right,data);
			}
			return root;
		}
		
		public static void printLevelOrderUsingQueue(Node root){
			
			Queue<Node> queue = new LinkedList<Node>();
			
			queue.add(root);
			
			while(!queue.isEmpty()){
				
				Node tempNode = queue.poll();
				System.out.print(tempNode.item + " ");
				
				if(tempNode.left!=null)
					queue.add(tempNode.left);
				

				if(tempNode.right!=null)
					queue.add(tempNode.right);
			}
		}
		
		// Method - 3 : Using Queue (Multiple Lines)
		
			public static void printLevelOrderUsingQueueLineWise(Node root){
				
				if(root == null)
					return;
				
				Queue<Node> queue = new LinkedList<Node>();
				
				queue.add(root);
				
				while(true){
					
					int count = queue.size();
					
					if(count==0)
						break;
					
					while(count>0){
						Node tempNode = queue.poll();
						
						System.out.print(tempNode.item + " ");
						
						if(tempNode.left!=null)
							queue.add(tempNode.left);
						

						if(tempNode.right!=null)
							queue.add(tempNode.right);
						
						count--;
					}
					System.out.println();
				}
			}
			
			private int size(){
				return size(root);
			}
			
			private int size(Node root){
				if(root == null){
					return 0;
				}else{
					return (size(root.left) + 1 + size(root.right));
				}
			}
			
			private int maxDepth(Node root){
				if(root == null){
					return 0;
				}else{
					int lDepth = maxDepth(root.left);
					int rDepth = maxDepth(root.right);
					
					if(lDepth > rDepth){
						return lDepth+1;
					}else{
						return rDepth +1;
					}
				}
				
			}
			
			private void preorderTraversal(Node root){
				if(root == null){
					return;
				}else{
					System.out.print(root.item + " ");
					preorderTraversal(root.left);
					preorderTraversal(root.right);
				}
			}
			
			private void inorderTraversal(Node root){
				if(root == null){
					return;
				}else{
					preorderTraversal(root.left);
					System.out.print(root.item + " ");
					preorderTraversal(root.right);
				}
			}
			
			private void postorderTraversal(Node root){
				if(root == null){
					return;
				}else{
					preorderTraversal(root.left);
					preorderTraversal(root.right);
					System.out.print(root.item + " ");
				}
			}
			
			private void deleteNode(Node root){
				if(root == null){
					return;
				}else{
					deleteNode(root.left);
					deleteNode(root.right);
					System.out.println("Deleted Node : " + root.item);
					root = null;
				}
			}
	
	public static void main(String[] args){
		LevelOrderTree levelOrderTree = new LevelOrderTree();
		levelOrderTree.root = new Node(1);
		levelOrderTree.root.left = new Node(2);
		levelOrderTree.root.right = new Node(3);
		levelOrderTree.root.left.left = new Node(4);
		levelOrderTree.root.left.right = new Node(5);
		levelOrderTree.root.right.left = new Node(6);
		levelOrderTree.root.left.left.left = new Node(7);
		levelOrderTree.root.left.left.right = new Node(8);
		levelOrderTree.root.right.left.right = new Node(9);
		
		/*for(int i=1; i<= 10; i++){
			levelOrderTree.insetElement(i);
		}*/
		levelOrderTree.printGivenLevelOrder();
		
		levelOrderTree.printLevelOrderUsingQueue(levelOrderTree.root);
		//levelOrderTree.printLevelOrderUsingQueueLineWise(levelOrderTree.root);
		
		System.out.println();
		System.out.println("Size of tree : " + levelOrderTree.size());
		System.out.println("Max depth of tree: " + levelOrderTree.maxDepth(levelOrderTree.root));
		
		System.out.print("Preorder traversal : ");
		levelOrderTree.preorderTraversal(levelOrderTree.root);
		System.out.println();
		System.out.print("Inorder traversal : ");
		levelOrderTree.inorderTraversal(levelOrderTree.root);
		System.out.println();
		System.out.print("PostOrder traversal : ");
		levelOrderTree.postorderTraversal(levelOrderTree.root);
		System.out.println();
		
		levelOrderTree.deleteNode(levelOrderTree.root.right);
		levelOrderTree.printGivenLevelOrder();
		
		
	}
}
