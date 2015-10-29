package dijkstra_astar;

public class Dijkstra {
	
	
	public static void main(String[] args) {
		
		DNode a = new DNode("a");
		DNode x2= new DNode("x2");
		DNode x3 = new DNode("x3");
		DNode x4 = new DNode("x4");
		DNode x5 = new DNode("x5");
		DNode x6 = new DNode("x6");
		DNode x7 = new DNode("x7");
		DNode x8 = new DNode("x8");
		DNode x9 = new DNode("x9");
		DNode x10 = new DNode("x10");
		DNode x11 = new DNode("x11");
		DNode b = new DNode("b");
		
		a.addEdge(x2, 162);
		a.addEdge(x7, 82);

		x2.addEdge(x4, 92);
		x2.addEdge(x3, 102);
		
		x7.addEdge(x3, 125);
		x7.addEdge(x8, 177);
		
		x3.addEdge(x5, 152);
		
		x4.addEdge(x5, 89);
		
		x8.addEdge(x9, 188);
		x8.addEdge(x5, 146);
		
		x5.addEdge(x11, 179);
		x5.addEdge(x6, 151);
		
		x9.addEdge(x6, 120);
		x9.addEdge(x10, 107);
		
		x10.addEdge(x6, 111);
		x10.addEdge(b, 80);
		
		x6.addEdge(b, 79);
		
		x11.addEdge(b, 111);
		
		// Hausaufgabe: Dijkstra zum Laufen bringen
		// Klasse BinaryHeap, wenn man besseren d-Wert findet steigt der Knoten auf im Heap! nicht implementiert in BinaryHeap
		// rise Funktion nicht implementiert
		// 1. neuer d-Wert wird gesetzt
		// 2. methode Build-Heap baut kompletten Heap auf
		
		
	}
	
	
	

}
