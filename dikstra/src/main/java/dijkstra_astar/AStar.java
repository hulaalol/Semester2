package dijkstra_astar;

public class AStar {

	
	public static void main(String[] args) {
		
		//if b is marked as completed the shortest way was found
		boolean foundWay = false;

		//build graph
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
		
		
//		a.heuristic=504;
//		x2.heuristic=384;
//		x3.heuristic=373;
//		x4.heuristic=301;
//		x5.heuristic=230;
//		x6.heuristic=79;
//		x7.heuristic=484;
//		x8.heuristic=314;
//		x9.heuristic=156;
//		x10.heuristic=80;
//		x11.heuristic=111;
//		b.heuristic=0;
		
		a.setCoords(4, 10);
		x2.setCoords(8, 11);
		x3.setCoords(7.5, 7);
		x4.setCoords(11.5, 9.5);
		x5.setCoords(14.5, 7);
		x6.setCoords(17, 5);
		x7.setCoords(2, 5);
		x8.setCoords(6, 2.5);
		x9.setCoords(11, 3);
		x10.setCoords(13, 2);
		x11.setCoords(23,8);
		b.setCoords(23, 4);
		
		
		
		
		
		a.addEdge(x2, DNode.calcWeight(a, x2)); 
		a.addEdge(x7, DNode.calcWeight(a, x7)); //kurven

		x2.addEdge(x4, DNode.calcWeight(x2, x4));
		x2.addEdge(x3, DNode.calcWeight(x2, x3));
		
		x7.addEdge(x3, DNode.calcWeight(x7, x3));
		x7.addEdge(x8, DNode.calcWeight(x7, x8));
		
		x3.addEdge(x5, DNode.calcWeight(x3, x5));
		
		x4.addEdge(x5, DNode.calcWeight(x4, x5));
		
		x8.addEdge(x9, DNode.calcWeight(x8, x9));
		x8.addEdge(x5, DNode.calcWeight(x8, x5));
		
		x5.addEdge(x11, DNode.calcWeight(x5, x11));
		x5.addEdge(x6, DNode.calcWeight(x5, x6));
		
		x9.addEdge(x6, DNode.calcWeight(x9, x6));
		x9.addEdge(x10, DNode.calcWeight(x9, x10));
		
		x10.addEdge(x6, DNode.calcWeight(x10, x6));
		x10.addEdge(b, DNode.calcWeight(x10, b));
		
		x6.addEdge(b, DNode.calcWeight(x6, b));
		
		x11.addEdge(b, DNode.calcWeight(x11, b));
		
		

		
		
		//heuristics
//		a.heuristic=504;
//		x2.heuristic=384;
//		x3.heuristic=373;
//		x4.heuristic=301;
//		x5.heuristic=230;
//		x6.heuristic=79;
//		x7.heuristic=484;
//		x8.heuristic=314;
//		x9.heuristic=156;
//		x10.heuristic=80;
//		x11.heuristic=111;
//		b.heuristic=0;
//		
//		a.addEdge(x2, 162);
//		a.addEdge(x7, 82);
//
//		x2.addEdge(x4, 92);
//		x2.addEdge(x3, 102);
//		
//		x7.addEdge(x3, 125);
//		x7.addEdge(x8, 177);
//		
//		x3.addEdge(x5, 152);
//		
//		x4.addEdge(x5, 89);
//		
//		x8.addEdge(x9, 188);
//		x8.addEdge(x5, 146);
//		
//		x5.addEdge(x11, 179);
//		x5.addEdge(x6, 151);
//		
//		x9.addEdge(x6, 120);
//		x9.addEdge(x10, 107);
//		
//		x10.addEdge(x6, 111);
//		x10.addEdge(b, 80);
//		
//		x6.addEdge(b, 79);
//		
//		x11.addEdge(b, 111);
		
		DNode[] graph = {a,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,b};
		
		
		
		
		
		
		
		
		
		BinaryHeap heap = new BinaryHeap();
		
		//insert all nodes into binaryHeap
		for(DNode node : graph){
			
			node.heuristic = DNode.calcWeight(node, b);
			
			//DNode.calcHeuristic(node, b);
			
			try {
				heap.insert(node);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//set startpoint - distance 0
		a.distance=0;
		heap.buildHeap();
		
		
		//expand smallest node in binary heap
		while(foundWay==false){

				DNode smallestNode = (DNode) heap.deleteMin();
				
				//subtract heuristic
				if (!(smallestNode.name.equalsIgnoreCase("a"))){
					smallestNode.distance=smallestNode.distance - smallestNode.heuristic;
				}
				
				
				//iterate over all edges to nodes that are not completed
				for(int i=0; i<smallestNode.edges.size(); i++){
					
					if(smallestNode.edges.get(i).complete==false){
						
						
					int predistance = smallestNode.distance + smallestNode.weights.get(i) + smallestNode.edges.get(i).heuristic;
					//predistance + weight

					if (predistance < smallestNode.edges.get(i).distance){
						//expanding
						smallestNode.edges.get(i).distance = predistance;
						smallestNode.edges.get(i).origin = smallestNode;
						
						
						heap.rise(smallestNode.edges.get(i).heapIndex);
						
					}
					}

				}
				
				//set status of node to completed
				smallestNode.complete = true;

					
//				int counter = 0;
//				for(DNode node : graph){
//					
//					if(node.complete==true){
//						counter++;
//					}
					
//				}
				
				if(b.complete){
					foundWay=true;
				}

		}

		
		//when finished print out the shortest way
		String[] way = new String[graph.length];
		
		//set b as target at the last index of way array
		DNode lastNode = b;
		way[graph.length-1]=b.name;
		
		for(int i=2; i<graph.length-1; i++){
			
			if(lastNode.origin!=null){ 						//check if node has an origin
				way[graph.length-i]=lastNode.origin.name;	//if origin exists, put its name in front of the prior lastNode
				lastNode = lastNode.origin;					//set the origin to the lastNode
				
			}else{ 											//node a --> origin=null (way finished)
				break;
			}

		}
		
		System.out.println("Kürzester Weg - "+b.distance+" Längeneinheiten über:");
		
		for(String s : way){
			
			if(s!=null && (!(s.equalsIgnoreCase("b")))){
				System.out.print(s+" --> ");
			}else if(s!=null){
				System.out.print("b");
			}

		}

	}
	
	
	

}
