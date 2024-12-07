package com.jfsd.exam.DemoConsole;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ClientDemo 
{
  public static void main(String args[])
  {
	  Scanner sc = new Scanner(System.in);
	  ClientDemo demo = new ClientDemo();
	  
	  boolean flag = true;
	  int ch;
	  while(flag)
	  {
		  System.out.println("1.Insert 2.Update 3.View by id 4.Exit");
		  ch=sc.nextInt();
		  
		  switch(ch)
		  {
		  case 1:
			  demo.addDepartment();
			  break;
		  case 2:
			  demo.updateDepartment();
		      break;
		  case 3:
			  demo.viewDepartmentByid();
			  break;
		  case 4:
			  flag = false;
			  break;
			  
		  }
	  }
  }
  
  public void addDepartment()
  {
	  Scanner sc = new Scanner(System.in);
      System.out.println("Enter Department Name:");
      String dname = sc.next();
      System.out.println("Enter Department Location");
      String location = sc.next();
      System.out.println("Enter Department HOD:");
      String hname = sc.next();
      
      Department d = new Department();
      
    
      d.setDname(dname);
      d.setLocation(location);
      d.setHname(hname);
      
      SessionFactory sf = new Configuration().configure().buildSessionFactory();
      Session se = sf.openSession();
      
      se.getTransaction().begin();
      se.persist(d);
      se.getTransaction().commit();
      
      System.out.println("Data inserted successfully");
      se.close();
      sf.close();
  }
  
  public void updateDepartment()
  {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter Department ID:");
      int deptid = sc.nextInt();
      
      System.out.println("Enter Department Name to update:");
      String name = sc.next();
	  System.out.println("Enter Department Location to update:");

      String location = sc.next();
      
      SessionFactory sf = new Configuration().configure().buildSessionFactory();
      Session se = sf.openSession();
      
      Department d = se.find(Department.class, deptid);
	  
      d.setDname(name);
      d.setLocation(location);
      
      se.getTransaction().begin();
      se.merge(d);
      se.getTransaction().commit();
      
      System.out.println("Department record updated successfully");
      se.close();
      sf.close();
      
  }
  
  public void viewDepartmentByid()
  {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Enter Department ID:");
      int deptid = sc.nextInt();
      
      SessionFactory sf = new Configuration().configure().buildSessionFactory();
      Session se = sf.openSession();
      
      Department d = se.find(Department.class, deptid);
      
      System.out.println("Department ID: "+d.getDeptid());
      System.out.println("Department Name: "+d.getDname());
      System.out.println("Department Location: "+d.getLocation());
      System.out.println("Department Hod Name: "+d.getHname());
      
  }
}
