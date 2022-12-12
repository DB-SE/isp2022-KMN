import java.util.List;

import interfaces.EdgeDecorator;
import interfaces.IEdge;
import interfaces.IGraphSearch;
import interfaces.IVertex;
import loader.PluginLoader;
import supertypes.AGraph;

public class Main {

	public static void main(String[] args) {
		
		AGraph graph = PluginLoader.load(AGraph.class).get(0);
		
		// add vertices
		for(int i=0; i<10; i++) {
			IVertex vertex = newVertex();
			graph.addVertex(vertex);
		}
		
		// add edges
		List<IVertex> vertices = graph.getVertices();
		for (int i = 0; i < 9; i++) {
			IEdge edge = newEdge();
			edge.setEdge(vertices.get(i), vertices.get(i+1));
			graph.addEdge(edge);
			
			if (i%2 == 0) {
				edge = newEdge();
				edge.setEdge(vertices.get(4), vertices.get(9-i));
				
				// edge weights, if edges exist
				if (PluginLoader.load(EdgeDecorator.class).size() > 0) {
					EdgeDecorator dec = PluginLoader.load(EdgeDecorator.class).get(0);
					dec.setDecorator(5);
					edge.addDecorator(dec);
				}
				
				graph.addEdge(edge);
			}
		}
		vertices.forEach(v -> System.out.println(v.getValue()));
		System.out.println("------");
		graph.getEdges().forEach(e -> System.out.println(e.getOriginVertex().getValue()));
		
		// test
		graph.printAdjacencyMatrix();
		
		// test searches
		for (IGraphSearch algo : PluginLoader.load(IGraphSearch.class)) {
			System.out.println("---");
			algo.setGraph(graph);
			algo.calculcate(vertices.get(0), true);
		}
	}
	
	
	// scuffed but best I could think of to get a hold of multiple instances :/
	private static IVertex newVertex() {
		try {
			return PluginLoader.load(IVertex.class).get(0).getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private static IEdge newEdge() {
		try {
			return PluginLoader.load(IEdge.class).get(0).getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}