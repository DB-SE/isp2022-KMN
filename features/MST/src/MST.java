import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import interfaces.IEdge;
import interfaces.IMST;
import interfaces.IVertex;
import supertypes.AGraph;

public class MST implements IMST {

	private AGraph graph;

	public void setGraph(AGraph graph) {
		this.graph = graph;
	}

	@Override
	public AGraph calculate() {
		if (this.graph.getVertices().size() == 0) {
			System.err.println("Cannot perform search on graph of size 0");
			return null;
		}

		return iterativeMST();
	}

	private AGraph iterativeMST() {
		
		final List<IVertex> visited = new ArrayList<>();
		final List<IVertex> vertices = graph.getVertices();
		final List<IEdge> edges = graph.getEdges();
		
		IVertex v=vertices.get(0); //starte mit irgendeinem Punkt
		visited.add(v);
		
		while(visited.size()<vertices.size()){
		List<IEdge> outgoingEdges=new ArrayList<>();
		outgoingEdges=getPossibleEdges(visited);
		IEdge e=findLowestEdge(outgoingEdges);
		
			if(!visited.contains(e.getTargetVertex())) {
			visited.add(e.getTargetVertex());
			} else {
			visited.add(e.getOriginVertex());
			}
		}
		
		return null;
	}

	private IEdge findLowestEdge(List<IEdge> outgoingEdges) {
			int minimum = Integer.MAX_VALUE;
			IEdge lowest=null;
			
			for (IEdge e: outgoingEdges) {
				if(e.getValue()<minimum) {
					minimum=e.getValue();
					lowest=e;
				}
			}
			return lowest;
		
		}

	private List<IEdge> getPossibleEdges(List<IVertex> visited) {
		
	List<IEdge> outgoingEdges = this.graph.getEdges().stream().filter(e -> visited.contains(e.getOriginVertex()) || (e.allowsTwoWayTraversal() && visited.contains(e.getTargetVertex()))).collect(Collectors.toList());

		return outgoingEdges;
	}

}