package dijkstra_astar;

import java.util.ArrayList;

public class DNode implements Comparable {

	String name;
	boolean complete = false;
	int distance;
	int heuristic;
	
	double x;
	double y;
	
	
	int heapIndex;
	
	
	ArrayList<DNode> edges = new ArrayList<DNode>();
	ArrayList<Integer> weights = new ArrayList<Integer>();
	
	DNode origin;
	int weight2Origin;
	
	
	public DNode(String name){
		this.name = name;
		this.distance = Integer.MAX_VALUE;
		this.weight2Origin = Integer.MAX_VALUE;
	}
	
	public void setCoords(double x, double y){
		this.x = x;
		this.y= y;
	}
	
	//x y im constructor setzen
	
	
	
	//nicht mehr benötigt
	public static double calcHeuristic(DNode node, DNode target){
		
		double v1 = target.x - node.x;
		double v2 = target.y - node.y;
		
		double luftlinie = Math.sqrt(v1*v1+v2*v2);
		
		luftlinie*=100;
		
		node.heuristic = (int) luftlinie;
		
		return luftlinie;
	}
	
	
	//heuristic und distance auf double ändern
	public static int calcWeight(DNode nodeA, DNode nodeB){
		
		
		double v1 = nodeA.x - nodeB.x;
		double v2 = nodeA.x - nodeB.x;
		
		return (int) (100*Math.sqrt(v1*v1+v2*v2));
	}
	
	
	
	

	public int compareTo(Object o) {
		
		DNode node = (DNode) o;
		
		if(distance < node.distance ){
			return -1;
		}else if(distance == node.distance){
			return 0;
		}else{
			return 1;
		}
	}
	
	
	
	
	void addEdge(DNode otherNode, int weight){
		
		
		if(!(edges.contains(otherNode))){
			
			edges.add(otherNode);
			weights.add(weight);
			
			if(!(otherNode.edges.contains(this))){
				
				otherNode.edges.add(this);
				otherNode.weights.add(weight);
				
			}else{
				System.out.println("Node already connected!");
			}

		}else{
			System.out.println("Node already connected!");
		}
		
		
		
		
	}

	
	
	
}
