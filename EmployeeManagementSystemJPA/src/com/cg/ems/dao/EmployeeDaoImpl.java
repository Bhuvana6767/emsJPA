package com.cg.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import javax.persistence.TypedQuery;


import com.cg.ems.bean.Employee;
import com.cg.util.JPAUtil;

import java.util.List;

public class EmployeeDaoImpl 
{
	EntityTransaction tran=null;
	EntityManager em=null;
	public EmployeeDaoImpl()
	{
		em=JPAUtil.getEntityManager();
	}
	public Employee addEmployee(Employee empl)
	{
		tran=em.getTransaction();
		tran.begin();
		em.persist(empl);
		tran.commit();
		return empl;
		
	}
	
	public List<Employee> fetchAllEmp()
	{
		String selQry="SELECT emp FROM Employee emp";
		TypedQuery<Employee> myQry=em.createQuery(selQry, Employee.class);
		List<Employee> emplList=myQry.getResultList();
		return emplList;
	}
	public Employee deleteEmp(int EmpId)
	{
		Employee emp=em.find(Employee.class, EmpId);
		tran=em.getTransaction();
		tran.begin();
		em.remove(emp);
		tran.commit();
		return emp;
	}
	public Employee updateEmpl(int EmpId,String neweName,float neweSal)
	{
		//Student st=em.find(Student.class, rno);
		Employee emp=new Employee();
		emp.setEmpId(EmpId);
		emp.setEmpName(neweName);
		emp.setEmpSal(neweSal);
		//st.setStuName(newName);
		tran.begin();
		em.merge(emp);
		tran.commit();
		return emp;
	}
}


