import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Player implements Comparable<Player>{
	int level;
	String name;
	
	public Player(int l, String n) {
		level = l;
		name = n;
	}
	
	public String print() {
		return level+" "+name+"\n";
	}

	@Override
	public int compareTo(Player o) {
		return this.name.compareTo(o.name);
	}
}

class Room{
	int level;
	TreeSet<Player> players;
	
	public Room(int level) {
		this.level = level;
		players = new TreeSet<>();
	}
}
public class B20006 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Room> list = new ArrayList<>();
		
		for(int idx=0;idx<p;idx++) {
			st = new StringTokenizer(bf.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			if(!check(m, list, level, name)) {
				Room room = new Room(level);
				room.players.add(new Player(level, name));
				list.add(room);
			}
		}
		solution(m, list);
	}

	private static boolean check(int m, ArrayList<Room> list, int level, String name) {
		if(list.isEmpty())
			return false;
		
		for(Room room : list) {
			if(room.players.size()==m)
				continue;
			if(Math.abs(level-room.level)<=10) {
				room.players.add(new Player(level, name));
				return true;
			}
		}
		return false;
	}
	
	private static void solution(int m, ArrayList<Room> list) {
		StringBuilder sb = new StringBuilder();
		for(Room room : list) {
			if(room.players.size()==m)
				sb.append("Started!");
			else
				sb.append("Waiting!");
			sb.append("\n");
			
			for(Player player : room.players)
				sb.append(player.print());
		}
		
		System.out.print(sb.toString());
	}
}
