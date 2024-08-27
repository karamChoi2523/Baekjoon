import java.util.Scanner;

public class Main {
	static int answer = 0;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				map[i][j] = sc.nextInt();
		
		game(0);
		System.out.println(answer);
	}

	private static void game(int cnt) {
		if(cnt==5) {
			findMax();
			return;
		}
		
		int[][] copy = new int[map.length][map[0].length];
		for(int i=0;i<map.length;i++)
			copy[i] = map[i].clone();
		
		for(int i=0;i<4;i++) {
			move(i);
			game(cnt+1);
			
			for(int j=0;j<map.length;j++)
				map[j] = copy[j].clone();
		}
	}

	private static void move(int direction) {
		switch(direction) {
		case 0:	//상
			for(int i = 0; i < map.length; i++) {
                int index = 0;	//값 넣을 곳
                int block = 0;	//최근 블록 수
                for(int j = 0; j < map.length; j++) {
                    if(map[j][i] != 0) {
                        if(block == map[j][i]) {
                            map[index - 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                        else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index++;
                        }
                    }
                }
            }
			break;
		case 1:	//하
			for(int i = 0; i < map.length; i++) {
                int index = map.length-1;
                int block = 0;
                for(int j = map.length-1; j >= 0; j--) {
                    if(map[j][i] != 0) {
                        if(block == map[j][i]) {
                            map[index + 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                        else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index--;
                        }
                    }
                }
            }
			break;
		case 2:		//좌
			for(int i = 0; i < map.length; i++) {
                int index = 0;
                int block = 0;
                for(int j = 0; j < map.length; j++) {
                    if(map[i][j] != 0) {
                        if(block == map[i][j]) {
                            map[i][index - 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index++;
                        }
                    }
                }
            }
			break;
		case 3:	//우
			for(int i = 0; i < map.length; i++) {
                int index = map.length - 1;
                int block = 0;
                for(int j = map.length - 1; j >= 0; j--) {
                    if(map[i][j] != 0) {
                        if(block == map[i][j]) {
                            map[i][index + 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index--;
                        }
                    }
                }
            }
			break;
		}
	}
	public static void findMax() {
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map.length; j++)
                answer = Math.max(answer, map[i][j]);
    }
}
