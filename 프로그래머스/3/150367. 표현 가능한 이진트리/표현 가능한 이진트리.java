import java.util.*;
class Solution {
    static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(TreeNode left, TreeNode right){
			this.left = left;
			this.right = right;
		}
	}
	
	static ArrayList<Integer>[] list;
	static int index;
    public int[] solution(long[] numbers) {
        int[] answer = {};
        
        answer = new int[numbers.length];
        
        for(int k=0;k<numbers.length;k++) {
        	String num = Long.toBinaryString(numbers[k]);
        	
        	index=0;
        	int h=1;
	        while(num.length() > Math.pow(2,h)-1)
	        	h+=1;
	        list = new ArrayList[h+1];
	        for(int i=0;i<h+1;i++)
				list[i] = new ArrayList<>();
            
            String s = "";
	        for (int i = 0; i < Math.pow(2, h) - 1 - num.length(); i++)
	            s += "0";
	        num = s + num;
	        
        	TreeNode root = new TreeNode(null, null);
        	Queue<TreeNode> q = new ArrayDeque<>();
        	q.add(root);
        	
        	for(int i=1;i<h;i++) {
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
        	
        	inorder(root, 0, num);
        	answer[k] = 1;
        	preorder(root, answer, k);
        }
        
        return answer;
    }
	private static void preorder(TreeNode node, int[] answer, int k) {
		if(node!=null) {
			if(node.data==0) {
				if(node.left!=null && node.left.data==1) {
					answer[k]=0;
					return;
				}
			if(node.right!=null && node.right.data==1) {
				answer[k]=0;
				return;
			}
			}
			if(node.left!=null) preorder(node.left, answer, k);
			if(node.right!=null) preorder(node.right, answer, k);
		}
	}
	private static void inorder(TreeNode node, int level, String num) {
		if(node.left!=null) inorder(node.left, level+1, num);
		
		node.data = (int)(num.charAt(index++)-48);
		list[level].add(node.data);
		
		if(node.right!=null) inorder(node.right, level+1, num);
	}
}