package dijkstra_astar;

public class Dijkstra {
	
	
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
		
		DNode[] graph = {a,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,b};
		
		BinaryHeap heap = new BinaryHeap();
		
		//insert all nodes into binaryHeap
		for(DNode node : graph){
			
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

				DNode smallestNode = (DNode) heap.findMin();
				
				//iterate over all edges to nodes that are not completed
				for(int i=0; i<smallestNode.edges.size(); i++){
					
					if(smallestNode.edges.get(i).complete==false){
					int predistance = smallestNode.distance + smallestNode.weights.get(i);
					//predistance + weight

					if (predistance < smallestNode.edges.get(i).distance){
						//expanding
						smallestNode.edges.get(i).distance = predistance;
						smallestNode.edges.get(i).origin = smallestNode;
					}
					}

				}
				
				//set status of node to completed and delete it from heap
				smallestNode.complete = true;
				heap.deleteMin();
				//rearrange Heap in right order
				heap.buildHeap();
				

				//check if b is completed
				
				
					
					
				int counter = 0;
				for(DNode node : graph){
					
					if(node.complete==true){
						counter++;
					}
					
				}
				
				if(counter==graph.length){
					foundWay=true;
				}
					
				
//				
//				if(b.complete){
//					foundWay = true;
//				}

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
