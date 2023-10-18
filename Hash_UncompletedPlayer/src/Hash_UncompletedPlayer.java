import java.util.Arrays;

public class Hash_UncompletedPlayer {
	static class Solution {
		public String solution(String[] participant, String[] completion) {
			String answer = "";

			if(completion.length==0)
				return participant[0];

			Arrays.sort(participant);
			Arrays.sort(completion);

			for(int i=0;i<completion.length;i++)
				if(!participant[i].equals(completion[i])) {
					return participant[i];
				}

			return answer = participant[participant.length-1];
		}
	}
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};

		String res = new Solution().solution(participant, completion);
		System.out.println(res);
	}

}
