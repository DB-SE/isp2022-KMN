import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import interfaces.IEdge;
import interfaces.IGraphSearch;
import interfaces.IVertex;
import supertypes.AGraph;

public class DFS implements IGraphSearch {
	
	private final AGraph graph;

	public DFS(AGraph graph) {
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
		
		return iterativeDFS(startVertex, debug);
	}
	
	
	private List<IVertex> iterativeDFS(IVertex startVertex, boolean debug) {
		
		final Stack<IVertex> stack = new Stack<>();
		final List<IVertex> visited = new ArrayList<>();
		
		stack.push(startVertex);
		
		while (!stack.empty()) {
			
			final IVertex top = stack.pop();
			
			if (!visited.contains(top)) {
				
				if (debug) System.out.println(top.toString().concat(" "));
				
				visited.add(top);
				final List<IVertex> neighbours = getNeighboursOf(top);
				
				for (IVertex n : neighbours) {
					stack.push(n);
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
