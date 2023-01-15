import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	
	private final List<Vertex> vertices = new ArrayList<Vertex>();
	private final List<Edge> edges = new ArrayList<Edge>();
	
	public void printAdjacencyMatrix() {
		
		int[][] adjacencyMatrix = this.calculateAdjacencyMatrix();
		StringBuilder builder = new StringBuilder();
		
		for (int[] row : adjacencyMatrix) {
			builder.append(Arrays.toString(row)).append("\n");
		}
		
		System.out.println(builder.toString());
	}
	
	private int[][] calculateAdjacencyMatrix() {

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