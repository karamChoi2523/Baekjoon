import java.util.Arrays;
import java.util.Comparator;

//회의실 배정
public class LimitCamera {
	public static int solution(int[][] routes) {
		int answer = 0;

		Arrays.sort(routes, (o1,o2)->o1[1]-o2[1]);

		int preEnd=-30001;

		//안 겹치는 개수를 찾으면 된다
		for(int i=0;i<routes.length;i++) {
			if(preEnd<routes[i][0]) {
				preEnd = routes[i][1];
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[][] routes = {{15,20},{5,14},{13,18},{3,5}};

		System.out.println(solution(routes));
	}
}
