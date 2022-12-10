package supertypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.IEdge;
import interfaces.IVertex;

public abstract class AGraph {
	
	protected final List<IVertex> vertices = new ArrayList<>();
	protected final List<IEdge> edges = new ArrayList<>();
	
	public abstract void addEdge(IEdge edge);
	
	public abstract void addVertex(IVertex vertex);
	
	public abstract int[][] calculateAdjacencyMatrix();
	
	public void printAdjacencyMatrix() {
		
		int[][] adjacencyMatrix = this.calculateAdjacencyMatrix();
		StringBuilder builder = new StringBuilder();
		
		for (int[] row : adjacencyMatrix) {
			builder.append(Arrays.toString(row)).append("\n");
		}
		
		System.out.println(builder.toString());
	}
	
	public List<IEdge> getEdges() {
		return this.edges;
	}
	
	public List<IVertex> getVertices() {
		return this.vertices;
	}
}
