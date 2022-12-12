import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import interfaces.IEdge;
import interfaces.IGraphSearch;
import interfaces.IVertex;
import supertypes.AGraph;

public class BFS implements IGraphSearch {
	
	private AGraph graph;

	public void setGraph(AGraph graph) {
		this.graph = graph;
	}
	
	@Override
	public List<IVertex> calculcate(IVertex startVertex, boolean debug) {
		
		if (this.graph.getVertices().size() == 0) {
			System.err.println("Cannot perform search on graph of size 0");
			return null;
		}
		
		if (!this.graph.getVertices().contains(startVertex)) {
			System.err.println("The provided vertex is not part of the graph");
			return null;
		}
		
		return iterativeBFS(startVertex, debug);
	}
	
	
	private List<IVertex> iterativeBFS(IVertex startVertex, boolean debug) {
		
		final Queue<IVertex> queue = new LinkedList<>();
		final List<IVertex> visited = new ArrayList<>();
		
		queue.add(startVertex);
		
		while (!queue.isEmpty()) {
			
			final IVertex top = queue.poll();
			
			if (!visited.contains(top)) {
				
				if (debug) System.out.println(top.toString().concat(" "));
				
				visited.add(top);
				final List<IVertex> neighbours = getNeighboursOf(top);
				
				for (IVertex n : neighbours) {
					queue.add(n);
				}
			}
		}
		
		return visited;
	}


	private List<IVertex> getNeighboursOf(IVertex vertex) {
		
		List<IEdge> outgoingEdges = this.graph.getEdges().stream().filter(e -> e.getOriginVertex() == vertex || (e.allowsTwoWayTraversal() && e.getTargetVertex() == vertex)).collect(Collectors.toList());
		List<IVertex> neighbours = new ArrayList<>();
		
		for (IEdge e : outgoingEdges) {
			if (e.getOriginVertex() == vertex) {
				neighbours.add(e.getTargetVertex());
			}
			else {
				neighbours.add(e.getOriginVertex());
			}
		}
		
		return neighbours;
	}
}