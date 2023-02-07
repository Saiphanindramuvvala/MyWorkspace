package employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class EmployeeTable {
	int empId;
	String fName;
	String lName;
	String project;
	String branch;
	String address;
	int Salary;
	String role;
	public static List<String> names = new ArrayList<String>();
	public EmployeeTable(int empId, String fName, String lName, String project, String branch, String address,
			int salary, String role) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		this.project = project;
		this.branch = branch;
		this.address = address;
		Salary = salary;
		this.role = role;
		names.add(fName);
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "EmployeeTable [empId=" + empId + ", fName=" + fName + ", lName=" + lName + ", project=" + project
				+ ", branch=" + branch + ", address=" + address + ", Salary=" + Salary + ", role=" + role + "]";
	}	
	
	
}

public class Emp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<EmployeeTable> employees= new ArrayList<EmployeeTable>();
		employees.add(new EmployeeTable(1, "Sai", "Phani", "SEI", "TCO", "Chennai", 25000, "dev"));
		employees.add(new EmployeeTable(1, "Ankit", "Chaini", "SEI", "TCO", "Chennai", 25500, "dev"));
		employees.add(new EmployeeTable(1, "Anil", "Naisetty", "SEI", "TCO", "Chennai", 49000, "dev"));
		employees.add(new EmployeeTable(1, "Anil", "Naisetty", "SEI", "TCO", "Chennai", 49000, "dev"));
		employees.add(new EmployeeTable(1, "Anil", "Naisetty", "SEI", "TCO", "Chennai", 49000, "dev"));
		
		Set<String> xemployees = new HashSet<>();
		List<EmployeeTable> listemp = new ArrayList<>();
		
		System.out.println("Using Set ");
		
		for(EmployeeTable emp : employees) {
			if(!xemployees.contains(emp.fName)) {
				xemployees.add(emp.fName);
				listemp.add(emp);
			}
		}
		
		List<EmployeeTable> emps = listemp.stream().sorted((i1,i2)->i1.fName.compareTo(i2.fName)).collect(Collectors.toList());
		
		System.out.println(emps);
		
//		Map<String, List<EmployeeTable>> groupBy= xemployees.stream().distinct().sorted().collect(Collectors.groupingBy(xemployees., Collectors.toList()));

		
		//method 0 to get list of employees
		for(int i=0;i<=2;i++) {
			System.out.println(employees.get(i).getfName());
		}
		
	
		//method 1 to get list of names
		System.out.println("List of employee names are"+EmployeeTable.names);
		
		//method 2 to get list of names
		for (EmployeeTable employee: employees) {
		    System.out.println("The name of employee is " + employee.getfName());
		}
		
//		Map<String, List<EmployeeTable>> groupBy= employees.stream().distinct().collect(Collectors.groupingBy(EmployeeTable::getfName, Collectors.toList()));
//		System.out.println("grouping by:"+groupBy);
	}

}
