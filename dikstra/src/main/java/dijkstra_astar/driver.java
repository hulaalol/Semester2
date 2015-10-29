package dijkstra_astar;

public class driver {

	
	
	
	public static void main(String[] args) {
		
		DNode test1 = new DNode();
		test1.distance=1532;
		
		DNode test2 = new DNode();
		test2.distance=891;
		
		
		System.out.println(test1.compareTo(test2));
		
		
		test1.addEdge(test2,1202);
		System.out.println("test1 connected to test 2");
		
		System.out.println("try connecting test2 to test1");
		test2.addEdge(test1, 1232);
		
		
	}
}
