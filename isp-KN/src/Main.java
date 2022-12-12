import java.util.List;

import interfaces.IEdge;
import interfaces.IVertex;
import loader.PluginLoader;
import supertypes.AGraph;

public class Main {

	public static void main(String[] args) {
		
		IVertex origin=null;
		IVertex target=null;
		
		List<IEdge> edges = PluginLoader.load(IEdge.class);
		List<AGraph> graphs = PluginLoader.load(AGraph.class);
		
		for(int i=0; i<10; i++) {
			List<IVertex> vertices = PluginLoader.load(IVertex.class);
			for(IVertex v: vertices) {
				if(i==2) {
					origin=v;
				} else if(i==8) {
					target=v;
				}
				for(AGraph g: graphs) {
					g.addVertex(v);
				}
			}
		}
		
		for(IEdge e: edges) {
			e.setEdge(origin, target);
			for(AGraph g: graphs) {
				g.addEdge(e);
			}
		}
		
		for(AGraph g: graphs) {
			g.printAdjacencyMatrix();
		}
		
		

	}

}
