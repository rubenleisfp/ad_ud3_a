package ad.ud3_a.solid.inyeccion.problem.repository.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ad.ud3_a.solid.inyeccion.problem.repository.EmployeeDao;
import ad.ud3_a.solid.inyeccion.problem.repository.model.Employee;


public class EmployeeFileDao implements  EmployeeDao  {

	private String csvFilePath;
	
	public EmployeeFileDao(String filePath) {
		this.csvFilePath = filePath;  
	}

    @Override
    public List<Employee> getAll() throws Exception {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                Employee employee = mapToEmployee(data);
                employees.add(employee);
            }
        } catch (IOException e) {
            throw new Exception("Error reading from CSV file", e);
        }
        return employees;
    }

    @Override
    public Employee getById(Long id) throws Exception {
        List<Employee> employees = getAll();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null; // Return null if not found
    }

    @Override
    public void create(Employee employee) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath, true))) {
            String line = mapToCsvLine(employee);
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new Exception("Error writing to CSV file", e);
        }
    }

    @Override
    public void update(Employee employee) throws Exception {
        List<Employee> employees = getAll();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(employee.getId())) {
                employees.set(i, employee);
                break;
            }
        }
        writeAllEmployees(employees);
    }

    @Override
    public void delete(Long id) throws Exception {
        List<Employee> employees = getAll();
        employees.removeIf(employee -> employee.getId().equals(id));
        writeAllEmployees(employees);
    }

    @Override
    public void deleteAll() throws Exception {
        Files.deleteIfExists(Paths.get(csvFilePath));
    }

    @Override
    public List<Employee> getAllEmployeesBeginA() throws Exception {
        List<Employee> employees = getAll();
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().toUpperCase().startsWith("A")) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    @Override
    public List<Employee> getEmployeesWithLessSalary(BigDecimal salaryCondition) throws Exception {
        List<Employee> employees = getAll();
        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary().compareTo(salaryCondition) < 0) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    @Override
    public Employee findByName(String name) throws Exception {
        List<Employee> employees = getAll();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null; // Return null if not found
    }

    private void writeAllEmployees(List<Employee> employees) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            for (Employee employee : employees) {
                String line = mapToCsvLine(employee);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new Exception("Error writing to CSV file", e);
        }
    }

    private Employee mapToEmployee(String[] data) {
        Employee employee = new Employee();
        employee.setId(Long.parseLong(data[0]));
        employee.setName(data[1]);
        employee.setSalary(new BigDecimal(data[2]));
        String truncatedDateTimeString = data[3].substring(0, 29);
        employee.setCreatedDate(LocalDateTime.parse(truncatedDateTimeString));
        return employee;
    }

    private String mapToCsvLine(Employee employee) {
        return String.format("%d;%s;%s;%s", employee.getId(), employee.getName(),
                employee.getSalary().toString(), employee.getCreatedDate().toString());
    }



}