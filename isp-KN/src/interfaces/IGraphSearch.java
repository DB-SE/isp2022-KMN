package interfaces;

import java.util.List;

import supertypes.AGraph;

public interface IGraphSearch {
	
	public void setGraph(AGraph graph);

	List<IVertex> calculcate(IVertex startVertex, boolean debug);
}
