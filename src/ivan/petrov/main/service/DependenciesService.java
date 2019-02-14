package ivan.petrov.main.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ivan.petrov.main.bean.DependencyBean;

public class DependenciesService {
	// dependencies structure
	private DependencyBean bean;
	// keep edges that remain to be visited
	private LinkedList<String> queue;
	// keep visited edges
	private Set<String> visited;

	public DependenciesService(DependencyBean bean) {
		this.bean = bean;
		this.queue = new LinkedList<>();
		this.visited = new HashSet<>();
	}

	public void findDependencies() {
		Map<String, List<String>> adjacencyMap = bean.getAdjacencyMap();
		for (String edge : adjacencyMap.keySet()) {
			queue.clear();
			visited.clear();
			queue.add(edge);

			findDependenciesHelper(adjacencyMap, visited, queue);

			System.out.println();
		}
	}

	public void findInverseDependencies() {
		Map<String, List<String>> adjacencyMap = bean.getAdjacencyMap();
		Set<String> edges = bean.getEdges();
		for (String edge : edges) {
			visited.clear();
			System.out.printf("%s ", edge);

			findInverseDependenciesHelper(edge, adjacencyMap, visited);

			System.out.println();
		}

	}

	private void findDependenciesHelper(Map<String, List<String>> adjacencyMap, Set<String> visited,
			LinkedList<String> queue) {
		if (queue.isEmpty()) {
			return;
		} else {
			String vertex = queue.poll();

			if (!visited.contains(vertex)) {
				System.out.printf("%s ", vertex);
				visited.add(vertex);

				if (adjacencyMap.get(vertex) != null) {
					adjacencyMap.get(vertex).forEach(child -> {
						queue.add(child);
					});
				}
			}

			findDependenciesHelper(adjacencyMap, visited, queue);
		}

	}

	private static void findInverseDependenciesHelper(String vertex, Map<String, List<String>> adjacencyMap,
			Set<String> visited) {

		adjacencyMap.forEach((edge, children) -> {
			if (!vertex.equalsIgnoreCase(edge)) {
				if (children.contains(vertex) && !visited.contains(edge)) {
					System.out.printf("%s ", edge);
					visited.add(edge);
					findInverseDependenciesHelper(edge, adjacencyMap, visited);
				}
			}
		});
	}
}
