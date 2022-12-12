import java.util.List;
import java.util.stream.Collectors;

import interfaces.IEdge;
import interfaces.IVertex;
import supertypes.AGraph;

public class BaseGraph extends AGraph {
	
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
			
			for (int j = 0; j < this.vertices.size(); j++) {
				
				final int originIndex = i;
				final int targetIndex = j;
				
				List<IEdge> filter = this.edges.stream()
						.filter(e -> e.getOriginVertex() == this.vertices.get(originIndex) &&
								e.getTargetVertex() == this.vertices.get(targetIndex))
						.collect(Collectors.toList());
				
				if (filter.size() > 0) {
					matrix[i][j] = filter.get(0).getValue();
				}
			}
		}
		
		return matrix;
	}
}
