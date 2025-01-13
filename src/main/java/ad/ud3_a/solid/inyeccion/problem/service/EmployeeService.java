package ad.ud3_a.solid.inyeccion.problem.service;

import java.math.BigDecimal;
import java.util.List;

import ad.ud3_a.solid.inyeccion.problem.repository.model.Employee;

/**
 * Capa de servicio/negocio, donde se realiza la algoritmia de nuestra aplicacion
 */
public interface EmployeeService {
	
	/**
	 * Devuelve los empleados con salario menor que el recibido como argumento
	 * 
	 * @param salaryCondition
	 * @return
	 * @throws Exception
	 */
	List<Employee> getEmployeesWithLessSalary(BigDecimal salaryCondition) throws Exception;
	
	/**
	 * Devuelve un String con  los nombre de los empleados separados por ; cuyo salario
	 * sea menor que el recibido como argumento
	 * 
	 * @param salaryCondition
	 * @return
	 * @throws Exception
	 */
	String getEmployeesWithLessSalarySeparatedWithCommas(BigDecimal salaryCondition) throws Exception;


}
