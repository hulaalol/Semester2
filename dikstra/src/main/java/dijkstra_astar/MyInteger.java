package dijkstra_astar;

public class MyInteger implements Comparable {
	
	public int value;
	
	public MyInteger(int i)  {
		value = i;
	}

	public int compareTo(Object i) {
		int result = 0;
		if (value == ((MyInteger)i).value) result = 0;
		if (value > ((MyInteger)i).value) result = 1;
		if (value < ((MyInteger)i).value) result = -1;
		return result;
	}
}

