package ivan.petrov.main.bean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DependencyBean {
	// representation of the relations between the edges
	private Map<String, List<String>> adjacencyMap;
	// keep all edges
	private Set<String> edges;

	public DependencyBean() {
		adjacencyMap = new HashMap<>();
		edges = new HashSet<>();
	}

	public DependencyBean(Map<String, List<String>> adjacencyMap, Set<String> edges) {
		super();
		this.adjacencyMap = adjacencyMap;
		this.edges = edges;
	}

	public Map<String, List<String>> getAdjacencyMap() {
		return adjacencyMap;
	}

	public void setAdjacencyMap(Map<String, List<String>> adjacencyMap) {
		this.adjacencyMap = adjacencyMap;
	}

	public Set<String> getEdges() {
		return edges;
	}

	public void setEdges(Set<String> edges) {
		this.edges = edges;
	}

}
