import java.util.List;
import java.util.stream.Collectors;

import interfaces.IEdge;
import interfaces.IVertex;
import supertypes.AGraph;

public class BaseGraph extends AGraph {
	
	BaseGraph() {
		// pass
	}
	
	@Override
	public void addEdge(IEdge edge) {
		this.edges.add(edge);
	}

	@Override
	public void addVertex(IVertex vertex) {
		this.vertices.add(vertex);
	}

	@Override
	public int[][] calculateAdjacencyMatrix() {

		int[][] matrix = new int[this.vertices.size()][this.vertices.size()];
		
		for (int i = 0; i < this.vertices.size(); i++) {
			
			IVertex origin = this.vertices.get(i);
			List<IEdge> outgoingEdges = this.edges
					.stream()
					.filter(e -> e.getOriginVertex() == origin)
					.collect(Collectors.toList());
			
			for (IEdge e : outgoingEdges) {
				int targetIndex = this.vertices.indexOf(e.getTargetVertex());
				matrix[i][targetIndex] = e.getValue();
			}
		}
		
		return matrix;
	}
}
