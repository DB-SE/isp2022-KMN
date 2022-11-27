package iopl.sheet3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterators.AbstractSpliterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Base graph implementation based on the graph examples from the second
 * lecture.
 */
class Graph {

	protected int vertexCount = 0;
	protected final List<Edge> edges = new ArrayList<>();
	protected final List<Vertex> vertices = new ArrayList<>();
	
	//#if WeightedGraph 
//@	private static double DEFAULT_WEIGHT = 1;
//@	public static void setDefaultWeight(double defaultWeight) {
//@
//@		Graph.DEFAULT_WEIGHT = defaultWeight;
//@	}
	//#endif

	Graph() {
	}
	

	Graph(List<Edge> e, List<Vertex> v) {
		this.edges.addAll(e);
		this.vertices.addAll(v);
		this.vertexCount = this.vertices.size();
	}

	

	/**
	 * Adds two vertices and an edge in-between.
	 *
	 * @param vertex1ID graph id of vertex 1
	 * @param vertex2ID vertex graph id of vertex 2
	 * @return The edge between vertex 1 and vertex 2
	 * @throws NoSuchElementException if the given vertex ids are not present in the
	 *                                graph
	 */
	Edge addEdge(int vertex1ID, int vertex2ID) throws NoSuchElementException {

		Vertex v1 = this.vertices.stream().filter(v -> v.getId() == vertex1ID).findFirst().orElseThrow();
		Vertex v2 = this.vertices.stream().filter(v -> v.getId() == vertex2ID).findFirst().orElseThrow();

		if (!contains(v1, this.vertices)) {
			this.vertices.add(v1);
		}
		if (!contains(v2, this.vertices)) {
			this.vertices.add(v2);
		}

		Edge edge = this.createEdge(v1, v2);
		this.edges.add(edge);
		return edge;
	}
	//#if WeightedGraph 
//@	
//@	Edge addEdge(int vertex1ID, int vertex2ID, double weight) {
//@		Edge e = this.addEdge(vertex1ID, vertex2ID);
//@		e.setWeight(weight);
//@		return e;
//@	}
//@
//@	
//@	
//@	protected Edge createEdge(Vertex v1, Vertex v2) {
//@
//@		return new Edge(v1, v2, Graph.DEFAULT_WEIGHT);
//@	}
	//#endif
	
	//#if !WeightedGraph 
		protected Edge createEdge(Vertex v1, Vertex v2) { 
	
			return new Edge(v1, v2);
		}
		//#endif

	// template
	Vertex addVertex() {
		var temp = new Vertex(this.vertexCount);
		this.vertices.add(temp);
		this.vertexCount++;
		return temp;
	}
	
	//#if LabeledGraph 
//@	Vertex addVertex(String label) {
//@		var temp = new Vertex(this.vertexCount);
//@		temp.setLabel(label);
//@		this.vertices.add(temp);
//@		this.vertexCount++;
//@		return temp;
//@		}
	//#endif
	//#if ColoredGraph 
	Vertex addVertex(Color color) {
		var temp = new Vertex(this.vertexCount);
		temp.setColor(color);
		this.vertices.add(temp);
		this.vertexCount++;
		return temp;
		}
	//#endif
	//#if ColoredGraph && LabeledGraph 
//@	Vertex addVertex(Color color, String label) {
//@
//@			var temp = new Vertex(this.vertexCount);
//@			temp.setLabel(label);
//@			temp.setColor(color);
//@			this.vertices.add(temp);
//@			this.vertexCount++;
//@			return temp;
//@			}
	//#endif
	

	boolean contains(Vertex v, List<Vertex> list) {
		for (Vertex inList : list) {
			if (inList.getId() == v.getId()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		this.edges.forEach(e -> sb.append(e).append("\n"));

		return sb.toString();
	}

	enum DebugMode {
		On, Off
	}

	enum SearchMode {
		DepthFirstSearch, CycleFinder
	}

	

	public boolean DFS(Vertex startVertex, DebugMode debugPrint, SearchMode searchMode) {
		return DFS(startVertex.getId(), debugPrint, searchMode);
	}

	public boolean DFS(int startId, DebugMode debugPrint, SearchMode searchMode) {
		if (this.vertexCount == 0) { // check graph empty
			if (debugPrint == DebugMode.On) {
				System.out.println("\n" + "Graph needs at least 1 Vertex to perform DFS!");
			}
			return false;
		}

		if (startId >= this.vertexCount) { // check graphindex out of bound
			if (debugPrint == DebugMode.On) {
				System.out.println("\n" + "The Vertex-ID (" + startId
						+ ") needs to be lower than the number of Vertices (" + this.vertexCount + ")!");
			}
			return false;
		}

		boolean visited[] = new boolean[vertexCount]; // create list of all visited vertices, default false

		return DFSrecursive(startId, visited, debugPrint, startId, searchMode);
	}

	private boolean DFSrecursive(int startId, boolean visited[], DebugMode debugPrint, int previousId,
			SearchMode searchMode) {

		/*for (Vertex v : vertices // find vertex in list of vertexes (needed for label)
		) {
			if (v.getId() == startId && debugPrint == DebugMode.On) {

				System.out.print(v + " ");

			}
		}
		entfernt, damit die Kante an sich dargestellt wird
		*/ 

		// mark beforehand so edges pointing towards the same vertex twice is registered
		// as a loop
		visited[startId] = true;

		// check if there is an edge from our current vertex to any of the visited ones
		// (except the most recently visited)
		// it so we detected a loop and must return true
		
		//TODO: REMOVE edgetype & evtl CycleFinder allgemein (mit /#if MST etc) @Michael
		
		/* if (searchMode == SearchMode.CycleFinder) {
			for (int i = 0; i < visited.length; ++i) {
				if (!visited[i] || i == previousId) {
					continue;
				}
				for (Edge e : edges) {
					if ((e.vertices[0].getId() == i && e.vertices[1].getId() == startId) || (e.vertices[1].getId() == i
							&& e.vertices[0].getId() == startId && edgeType == EdgeType.Undirected)) {
						return true;
					}
				}
			}
		}
	*/

// TODO return value

		for (Edge e : edges // check all egdes for current vertex; if found and other vertex not in list of
							// visited -> recursion with that vertex
		) {
			Vertex[] currentVertices = e.getVertices();

			if (currentVertices[0].getId() == startId) {
				if (!visited[currentVertices[1].getId()]) {
					System.out.print(e +"; ");
					var ret = DFSrecursive(currentVertices[1].getId(), visited, debugPrint, startId, searchMode);
					if (searchMode == SearchMode.CycleFinder && ret) {
						return ret;
					}

				}
			}
			//#if UndirectedEdge 
//@			 else if (currentVertices[1].getId() == startId) {
//@				if (!visited[currentVertices[0].getId()]) {
//@					System.out.print(e + "; ");
//@					var ret = DFSrecursive(currentVertices[0].getId(), visited, debugPrint, startId, searchMode);
//@					if (searchMode == SearchMode.CycleFinder && ret) {
//@						return ret;
//@					}
//@				}
//@			}
		//#endif
			

		}
		return false;
	}

//#if DefaultMatrix || WeightedMatrix 
	public void getAdjMatr() {
		
	//#if DefaultMatrix 
	int[][] AdjMatrix=new int[this.vertexCount][this.vertexCount];
	for (Edge e : edges) {
		
		Vertex[] currentVertices = e.getVertices();
		AdjMatrix[currentVertices[0].getId()][currentVertices[1].getId()]=1;
		
		//#if UndirectedEdge 
//@			AdjMatrix[currentVertices[1].getId()][currentVertices[0].getId()]=1;
		//#endif
	}
	//#endif

	//#if WeightedMatrix 
//@	double[][] AdjMatrix=new double[this.vertexCount][this.vertexCount];
//@	for (Edge e : edges) {
//@	
//@			Vertex[] currentVertices = e.getVertices();
//@			var we=(Edge) e;
//@
//@			AdjMatrix[currentVertices[0].getId()][currentVertices[1].getId()]=we.getWeight();
//@			
			//#if UndirectedEdge
//@				AdjMatrix[currentVertices[1].getId()][currentVertices[0].getId()]=we.getWeight();
			//#endif
//@		}
//@	
	//#endif
	
	System.out.println(Arrays.deepToString(AdjMatrix));
	}
	//#endif


//----------------------------------- ab hier schauen


 //#if MST 
//@
//@
//@	/*
//@	 * Returns one possible minimum spanning tree of the current graph, doesn't
//@	 * create copy! All vertices will remain in the same order, edges will be
//@	 * selected to match the following criteria 1. all vertices are connected 2. no
//@	 * cycles (-> subset of connected edges where only the start and the end vertex
//@	 * is the same) - minimum possible sum of weights
//@	 */
//@	public Graph getAMinimumSpanningTree() { //TODO edgetype entfernt und ohne groß nachzudenken code dahingehend angepasst, also check ob das so passt
//@		// This is a brute force algorithm, testing all combinations of edges for
//@		// criteria 1 and 2
//@		// at the end, the candidate with the lowest sum of weights wins, if multiple
//@		// qualify the first that was generated by combination, wins
//@
//@		Stream<List<Edge>> combiStream = combinations(this.edges);
//@
//@		var mst = combiStream.filter((array) -> {
//@			// criteria 1, all vertices connected
//@			var foundVertices = new ArrayList<Vertex>();
//@			for (Edge e : array) {
//@				var we = (Edge) e;
//@				var vertices = we.vertices;
//@				for (Vertex v : vertices) {
//@					if (!foundVertices.contains(v)) {
//@						foundVertices.add(v);
//@					}
//@				}
//@			}
//@			if (foundVertices.size() != this.vertexCount) {
//@				return false;
//@			}
//@			
			//#if UndirectedEdge 
//@				// exit early as further checks only apply to directed graphs
//@				return true;
			//#endif
//@				
//@
//@			// test fully connectedness from any start vertex, as there may only be one
//@			// start point that can reach every vertex
//@			boolean anyFullyConnected = true;
//@			for (Vertex v1 : this.vertices) {
//@				anyFullyConnected = true;
//@				for (Vertex v2 : this.vertices) {
//@					if (v1.getId() == v2.getId()) {
//@						continue;
//@					}
//@					if (!isConnected(v1.getId(), v2.getId())) {
//@						anyFullyConnected = false;
//@						break;
//@					}
//@				}
//@				if (anyFullyConnected) {
//@					break;
//@				}
//@			}
//@			return anyFullyConnected;
//@		}).filter((array) -> {
//@			// criteria 2, no loops
//@			var wg = convertEdgesToWG(array, this.vertices); // so inefficient....
//@			return !wg.DFS(0, Graph.DebugMode.Off, Graph.SearchMode.CycleFinder);
//@		}).min((a, b) -> {
//@			var wa = getWeightOfEdgeList(a);
//@			var wb = getWeightOfEdgeList(b);
//@			if (wa < wb) {
//@				return -1;
//@			}
//@			if (wa > wb) {
//@				return 1;
//@			}
//@			return 0;
//@		});
//@
//@		if (mst.isEmpty()) {
//@			System.out.println("!! Graph has unconnected vertices !!");
//@		}
//@
//@		return convertEdgesToWG(mst.get(), this.vertices);
//@	}
//@
//@	// Only works for directed graphs
//@	// Checks if the two vertices are connected with a continuous chain of edges
//@	private boolean isConnected(int vertexStartIndex, int vertexEndIndex) {
//@		if (this.edges.isEmpty() || this.vertices.isEmpty()) {
//@			return false;
//@		}
//@		boolean edgesVisited[] = new boolean[this.edges.size()];
//@		return isConnectedRecursively(vertexStartIndex, vertexEndIndex, edgesVisited);
//@	}
//@
//@	private boolean isConnectedRecursively(int vertexStartIndex, int vertexEndIndex, boolean[] edgesVisited) {
//@		// check if there is an edge from the changing start index to end index
//@		for (Edge e : this.edges) {
//@			var verts = e.getVertices();
//@			if (verts[0].getId() == vertexStartIndex && verts[1].getId() == vertexEndIndex) {
//@				return true;
//@			}
//@		}
//@
//@		// no direct connection found, check abort condition (all visited)
//@		var allVisited = true;
//@		for (boolean v : edgesVisited) {
//@			if (!v) {
//@				allVisited = false;
//@				break;
//@			}
//@		}
//@		if (allVisited) {
//@			return false;
//@		}
//@
//@		// explore further
//@		for (int i = 0;i<this.edges.size(); i++) {
//@			var verts = this.edges.get(i).getVertices();
//@			if (!edgesVisited[i] && verts[0].getId() == vertexStartIndex) {
//@				edgesVisited[i] = true;
//@				if (isConnectedRecursively(verts[1].getId(), vertexEndIndex, edgesVisited)) {
//@					return true;
//@				}
//@			}
//@
//@		}
//@		return false;
//@	}
//@
//@	private Graph convertEdgesToWG(List<Edge> e, List<Vertex> v) {
//@		var wg = new Graph();
//@		wg.edges.addAll(e);
//@		wg.vertices.addAll(v);
//@		wg.vertexCount = wg.vertices.size();
//@		return wg;
//@	}
//@
//@	private double getWeightOfEdgeList(List<Edge> list) {
//@		double weight = 0;
//@		for (Edge e : list) {
//@			var we = (Edge) e;
//@			weight += we.getWeight();
//@		}
//@		return weight;
//@	}
//@
//@	public double getSumWeight() {
//@		return getWeightOfEdgeList(this.edges);
//@	}
//@
//@	// https://stackoverflow.com/a/37836750
//@	private static <T> Stream<List<T>> combinations(List<T> arr) {
//@		final long N = (long) Math.pow(2, arr.size());
//@		return StreamSupport.stream(new AbstractSpliterator<List<T>>(N, Spliterator.SIZED) {
//@			long i = 1;
//@
//@			@Override
//@			public boolean tryAdvance(Consumer<? super List<T>> action) {
//@				if (i < N) {
//@					ArrayList<T> out = new ArrayList<T>(Long.bitCount(i));
//@					for (int bit = 0; bit < arr.size(); bit++) {
//@						if ((i & (1 << bit)) != 0) {
//@							out.add(arr.get(bit));
//@						}
//@					}
//@					action.accept(out);
//@					++i;
//@					return true;
//@				} else {
//@					return false;
//@				}
//@			}
//@		}, false);
//@	}
	//#endif
}


