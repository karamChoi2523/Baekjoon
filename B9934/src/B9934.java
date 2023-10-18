import java.io.*;
import java.util.*;

public class B9934 {
	static int len=0;
	static int[] input;
	static int index=0;
	
	static ArrayList<Integer>[] list;
	
	static class TreeNode<Integer>{
		private int data;
		public TreeNode<Integer> left;
		public TreeNode<Integer> right;
		
		public TreeNode(TreeNode left, TreeNode right) {
			this.left = left;
			this.right = right;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(bf.readLine());
		list = new ArrayList[k];
		
		for(int i=0;i<k;i++)
			list[i] = new ArrayList<>();
		
		len = (int) (Math.pow(2, k)-1);	//k=4, len = 15
		input = new int[len];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<Math.pow(2, k)-1;i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		
		TreeNode root = new TreeNode(null,null);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		for(int i=0;i<k-1;i++) {	//레벨별로 연결을 미리 만든다
			int qSize = q.size();
			
			for(int j=0;j<qSize;j++) {
				TreeNode parent = q.poll();
				
				TreeNode left = new TreeNode(null, null);
				TreeNode right = new TreeNode(null, null);
				parent.left = left;
				parent.right = right;
				
				q.offer(left);	
				q.offer(right);
			}
		}
		
		//중위순회하면서 레벨별로 저장
		inorder(root, 0);
		
		//출력
		for(ArrayList<Integer> levels : list) {
			for(Integer node : levels)
				System.out.print(node+" ");
			System.out.println();
		}
	}
	
	private static void inorder(TreeNode node, int level) {
		if(node.left != null) inorder(node.left, level+1);
		
		node.data = input[index++];
		list[level].add(node.data);
		
		if(node.right != null) inorder(node.right, level+1);
	}	
}
