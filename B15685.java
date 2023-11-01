import java.util.ArrayList;
import java.util.Scanner;

public class B15685 {
	private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;
    private static final int LENGTH = 101;
    
    private static boolean[][] map = new boolean[LENGTH][LENGTH];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
		
			draw(x, y, getDirections(d,g));
		}
		System.out.println(getNumberOfSquares());
	}
	//방향 구하기(0->,1|^,2<-,3|)
	public static ArrayList<Integer> getDirections(int d, int g) {
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(d);
 
        for(int i=0;g>0;i++,g--) {
        	for (int j = directions.size() - 1; j >= 0; j--) {
                int direction = (directions.get(j) + 1) % 4;
                directions.add(direction);
            }
        }
        return directions;
    }
	//꼭짓점
	public static void draw(int x, int y, ArrayList<Integer> directions) {
        map[x][y] = true;
 
        for (int direction : directions) {
            switch (direction) {
                case RIGHT:
                    map[++x][y] = true;
                    break;
                case UP:
                    map[x][--y] = true;
                    break;
                case LEFT:
                    map[--x][y] = true;
                    break;
                case DOWN:
                    map[x][++y] = true;
                    break;
            }
        }
    }
	//정사각형
	private static int getNumberOfSquares() {
        int count = 0;
 
        for (int x=0;x<LENGTH-1;x++) {
            for (int y=0;y<LENGTH-1;y++) {
                if (map[x][y] && map[x + 1][y] && map[x][y + 1] && map[x + 1][y + 1])
                    count++;
            }
        }
 
        return count;
    }

}
