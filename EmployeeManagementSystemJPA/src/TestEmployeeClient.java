import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDaoImpl;

import com.cg.ems.bean.*;

public class TestEmployeeClient 
{
	static EmployeeDaoImpl empDao=new EmployeeDaoImpl();
	static Employee emp=new Employee();
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) 
	{
		int choice=0;

		// TODO Auto-generated method stub

		System.out.println("what do u want to do?");
		System.out.println("1:add Emp\t2:Fetch all emp\n");
		System.out.println("3:search emp by id\t 4: search emp by name\n");
		System.out.println("5: delete emp\t 6: update emp\n");
		System.out.println("enter ur choice");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:addEmp();
		break;
		case 2: showEmpInfo();
		break;
		case 3: getEmpById();
		break;
		case 4: getEmpByName();
		break;
		case 5:deleteEmp();
		break;
		case 6:updateEmp();
		break;
		default: System.exit(0);
		}



	}

	private static void updateEmp() {
		// TODO Auto-generated method stub
		Employee emp3=empDao.updateEmpl(2, "hari", 2500);
		System.out.println("updated : "+emp3);

	}

	private static void deleteEmp() {
		// TODO Auto-generated method stub
		System.out.println("record deleted for : "+empDao.deleteEmp(1));
		System.out.println("Deleted 1 empId");

	}

	private static void getEmpByName() {
		// TODO Auto-generated method stub

	}

	private static void getEmpById() {
		// TODO Auto-generated method stub

	}

	private static void showEmpInfo() {
		// TODO Auto-generated method stub
		List<Employee> emList=empDao.fetchAllEmp();
		Iterator<Employee> it=emList.iterator();
		System.out.println("EmpId\t\t\t EMPNAME\t\t\t EMPSAL");
		System.out.println("------------------------------------------------------------");
		while(it.hasNext())
		{
			Employee tempEmpl=it.next();
			System.out.println(tempEmpl.getEmpId()+"\t\t"+tempEmpl.getEmpName()+"\t\t"+tempEmpl.getEmpSal());
		}

	}

	private static void addEmp() {
		// TODO Auto-generated method stub

		System.out.println("Enter Employee ID:");
		int eid=sc.nextInt();
		System.out.println("Enter Employee Name:");
		String enm=sc.next();
		System.out.println("Enter Employee salary:");
		Float esal=sc.nextFloat();

		//Employee emp=new Employee();
		emp.setEmpId(eid);
		emp.setEmpName(enm);
		emp.setEmpSal(esal);
		Employee empl=empDao.addEmployee(emp);
		System.out.println("Data Inserted in the table "+empl);

	}
}
