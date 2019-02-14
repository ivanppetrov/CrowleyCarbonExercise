package ivan.petrov.main;

import ivan.petrov.main.bean.DependencyBean;
import ivan.petrov.main.service.DependenciesService;
import ivan.petrov.main.util.ReaderUtil;

/*
 * input
 * 	A B C
	B C E
	C G
	D A F
	E F
	F H
	0
 */
public class Main {

	public static void main(String[] args) {

		// read data and create dependencies structure
		DependencyBean bean = ReaderUtil.readData(System.in);

		DependenciesService service = new DependenciesService(bean);

		service.findDependencies();

		System.out.println("=====Inverse Dependencies=====");

		service.findInverseDependencies();
	}

}
