import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	static class Node{
		char val;
		Node left = null;
		Node right = null;
		
		public Node(char v) {
			val = v;
		}
	}
	
	static class Tree{
		Node root;

		public void insertNode(char val, char left, char right) {
			if(root==null) {
				root = new Node(val);
				
				if(left != '.')
					root.left = new Node(left);
				if(right != '.')
					root.right = new Node(right);
			}else {
				searchNode(root, val, left, right);
			}
		}
		private void searchNode(Node node, char target, char left, char right) {
            if(node == null)
                return;
            
			if(node.val == target) {
				if(left != '.')
					node.left = new Node(left);
				if(right != '.')
					node.right = new Node(right);
			}else {
				searchNode(node.left, target, left, right);
				searchNode(node.right, target, left, right);
			}
		}
		//VLR
		void preOrder(Node node) {
			sb.append(node.val);
			
			if(node.left != null) {
				preOrder(node.left);
			}if(node.right != null) {
				preOrder(node.right);
			}
		}
		//LVR
		void inOrder(Node node) {
			if(node.left != null)
				inOrder(node.left);
			sb.append(node.val);
			if(node.right != null)
				inOrder(node.right);
		}
		//LRV
		void postOrder(Node node) {
			if(node.left != null)
				postOrder(node.left);
			if(node.right != null)
				postOrder(node.right);
			sb.append(node.val);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int n = Integer.valueOf(str);
		
		Tree tree = new Tree();
		
		for(int i=0;i<n;i++) {
			str = br.readLine();
			char v = str.split(" ")[0].charAt(0);
			char l = str.split(" ")[1].charAt(0);
			char r = str.split(" ")[2].charAt(0);
			
			tree.insertNode(v, l, r);
		}
		
		tree.preOrder(tree.root);
		System.out.println(sb.toString());
		sb.setLength(0);
		tree.inOrder(tree.root);
		System.out.println(sb.toString());
		sb.setLength(0);
		tree.postOrder(tree.root);
		System.out.println(sb.toString());
		sb.setLength(0);
	}
}
