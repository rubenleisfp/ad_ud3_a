package ad.ud3_a.solid.inyeccion.solution;

import java.math.BigDecimal;
import java.util.List;

import ad.ud3_a.solid.inyeccion.problem.repository.EmployeeDao;
import ad.ud3_a.solid.inyeccion.problem.repository.model.Employee;
import ad.ud3_a.solid.inyeccion.problem.service.EmployeeService;

public class EmployeeServiceSolutionImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public EmployeeServiceSolutionImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	@Override
	public List<Employee> getEmployeesWithLessSalary(BigDecimal salaryCondition) throws Exception {
		return this.employeeDao.getEmployeesWithLessSalary(salaryCondition);
	}

	@Override
	public String getEmployeesWithLessSalarySeparatedWithCommas(BigDecimal salaryCondition) throws Exception {
		StringBuilder sb = new StringBuilder();
		List<Employee> employeesWithLessSalary = this.getEmployeesWithLessSalary(salaryCondition);
		for (Employee e : employeesWithLessSalary) {
			sb.append(e.getName());
			sb.append(";");
		}
		return sb.toString();
	}

}
