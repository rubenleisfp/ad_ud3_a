package ad.ud3_a.solid.inyeccion.problem.service.impl;

import java.math.BigDecimal;
import java.util.List;

import ad.ud3_a.solid.inyeccion.problem.repository.EmployeeDao;
import ad.ud3_a.solid.inyeccion.problem.repository.impl.EmployeeJdbcDao;
import ad.ud3_a.solid.inyeccion.problem.repository.model.Employee;
import ad.ud3_a.solid.inyeccion.problem.service.EmployeeService;

public class EmployeeServiceProblemImpl implements EmployeeService {

	//Aqui estamos atados a la implementacion JDBC. 
	// ¿Qué pasa si ahora necesitamos interactuar con el fichero en vez de con la BBDD?
	//Si solo usamos el DAO en esta clase, solo tenemos que cambiar estar linea, pero ¿y si lo usamos en 40 clases?
	//Podriamos mejorarlo con la inyeccion de dependencias. Solo una parte de nuestra app debería crear las instancias de componentes
	//y pasarsela a quien la requiera
	private EmployeeDao employeeDao = new EmployeeJdbcDao();
	
	
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
