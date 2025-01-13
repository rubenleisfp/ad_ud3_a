package ad.ud3_a.solid.inyeccion.problem;

import java.math.BigDecimal;

import ad.ud3_a.solid.inyeccion.problem.service.EmployeeService;
import ad.ud3_a.solid.inyeccion.problem.service.impl.EmployeeServiceProblemImpl;

public class AppServiceProblem {

	EmployeeService employeeService = new EmployeeServiceProblemImpl();


	public static void main(String[] args) {
		AppServiceProblem appService = new AppServiceProblem();;
		try {
			appService.procesar();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void procesar() throws Exception {
		String employeesWithLessSalarySeparatedWithCommas = employeeService.getEmployeesWithLessSalarySeparatedWithCommas(new BigDecimal(30000));
		System.out.println("employeesWithLessSalarySeparatedWithCommas: " + employeesWithLessSalarySeparatedWithCommas);
	}

}
