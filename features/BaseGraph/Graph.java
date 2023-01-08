import java.util.List;
import java.util.ArrayList;


public class Graph extends AGraph {
	
	@Override
	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	@Override
	public void addVertex(Vertex vertex) {
		this.vertices.add(vertex);
	}

	@Override
	public int[][] calculateAdjacencyMatrix() {

		int[][] matrix = new int[this.vertices.size()][this.vertices.size()];
		
		for (int i = 0; i < this.vertices.size(); i++) {
			
			for (int j = 0; j < this.vertices.size(); j++) {
				
				final int originIndex = i;
				final int targetIndex = j;
				
				List<Edge> filter = new ArrayList<Edge>();
				for (Edge e : this.edges) {
					if (e.getOriginVertex() == this.vertices.get(originIndex) &&
								e.getTargetVertex() == this.vertices.get(targetIndex)) {
						filter.add(e);
					}
				}
				
				if (filter.size() > 0) {
					matrix[i][j] = filter.get(0).getValue();
				}
			}
		}
		
		return matrix;
	}
}