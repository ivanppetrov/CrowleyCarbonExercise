package ivan.petrov.main.util;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import ivan.petrov.main.bean.DependencyBean;

public class ReaderUtil {
	
	public static DependencyBean readData(InputStream is) {
		Scanner input = new Scanner(is);
		Map<String, List<String>> adjacencyMap = new HashMap<>();
		Set<String> edges = new HashSet<>();
		
		while (!input.hasNext("0")) {
			String vertex = input.next();
			edges.add(vertex);

			String line = input.nextLine();
			if (line.length() > 1) {
				line = line.substring(1);
			}
			List<String> children = Arrays.asList(line.split("\\s+"));
			edges.addAll(children);

			adjacencyMap.put(vertex, children);
		}
		
		return new DependencyBean(adjacencyMap, edges);
	}
}
