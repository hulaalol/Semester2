package dijkstra_astar;

import java.util.ArrayList;

public class DNode implements Comparable {

	String name;
	boolean complete = false;
	int distance;
	int heuristic;
	
	
	int heapIndex;
	
	
	ArrayList<DNode> edges = new ArrayList<DNode>();
	ArrayList<Integer> weights = new ArrayList<Integer>();
	
	DNode origin;
	int weight2Origin;
	
	
	public DNode(String name){
		this.name = name;
		this.distance = Integer.MAX_VALUE;
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
