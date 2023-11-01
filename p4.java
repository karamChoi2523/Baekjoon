import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class p4 {
	static class Solution {
		class TreeNode<Integer>{
			private int data;
			public TreeNode<Integer> left;
			public TreeNode<Integer> right;
			
			public TreeNode(TreeNode left, TreeNode right) {
				this.left = left;
				this.right = right;
			}	
		}
		
		String num;
		int index=0;
		ArrayList<Integer>[] list;
		int h;
		int k;
		
	    public int[] solution(long[] numbers) {
	        int[] answer = {};
	        int i=0;
	        answer = new int[numbers.length];
	        
	        for(k=0;k<numbers.length;k++) {
	        	num = changing(numbers[k]);
	        	
	        	String s = "";
	        	for(i=num.length()-1;i>=0;i--) {
	        		s+=num.charAt(i);
	        	}
	        	num = s;
	        	//System.out.println(num);
	        	
	        	index=0;
	        	
	        	h=1;	//레벨
		        while(num.length() > Math.pow(2,h)-1)
		        	h+=1;
		        list = new ArrayList[h+1];
		        for(i=0;i<h+1;i++)
					list[i] = new ArrayList<>();
		        
		        s = "";
		        for(i=0;i<Math.pow(2, h)-1-num.length();i++)
		        	s+="0";
		        num = s+num;	//최종 이진수 문자열
		        
		        TreeNode root = new TreeNode(null,null);
				Queue<TreeNode> q = new LinkedList<>();
				q.add(root);
				
				for(i=0;i<h-1;i++) {	//레벨별로 연결을 미리 만든다
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
				
				inorder(root, 0);
				answer[k]=1;	
				preorder(root, answer);
				System.out.print(answer[k]+" ");
	        }
	        return answer;
	    }
	
	    //이진수로 변환
		public String changing(long num) {
			String s = "";
			
			while(num!=0) {
				s += String.valueOf(num%2);
				num = num/2;
			}
			
			return s;			
		}
		
		public void inorder(TreeNode node, int level) {
			if(node.left != null) inorder(node.left, level+1);
			
			node.data = (int)(num.charAt(index++)-48);
			//System.out.println(node.data);
			list[level].add(node.data);
			
			if(node.right != null) inorder(node.right, level+1);
		}
		
		public void preorder(TreeNode node, int[] answer) {
			if(node != null) {
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
				if(node.left != null) preorder(node.left, answer);
				if(node.right != null) preorder(node.right, answer);
			}
		}
	
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		long[] numbers = {4};
		int[] ans = s.solution(numbers);
	}

}
