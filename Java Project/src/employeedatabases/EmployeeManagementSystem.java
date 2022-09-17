package employeedatabases;
import java.util.ArrayList;
import java.util.Scanner;
class Employee 
{
	int id;
	String name;
	String department;
	float salary;
	long contact_no;
	String email_id;
	
	public Employee(int id,String name,String department,float salary,long contactno,String emailid)
	{
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
		this.contact_no=contactno;
		this.email_id=emailid;
		
	}
	
	public String toString()
	{
		return "\nEmployee Details:"+"\nID: "+this.id+"\nName: "+this.name+"\nDepartment: "+this.department
				+"\nSalary: "+this.salary+"\nEmail_Id: "+this.email_id+"\nContact_no: "+this.contact_no;
		
		
	}
}
public class EmployeeManagementSystem 
{
    public static void display(ArrayList<Employee> al)
	{
		System.out.println("\n.......................Employee List........................\n");
		System.out.println(String.format("%-10s%-15s%-20s%-10s%-20s%-10s","ID ","Name ","Department","Salary ","Contact no ","Email id "));
		for(Employee e:al)
		{
			System.out.println(String.format("%-10s%-15s%-20s%-10s%-15s%-10s",e.id,e.name,e.department,e.salary,e.contact_no,e.email_id));
		}
	}

	public static void main(String[] args) 
	{
		int id;
		String name;
		String department;
		float salary;
		long contact_no;
		String email_id;
	    
	    Scanner sc=new Scanner(System.in);
	    ArrayList<Employee> al=new ArrayList<Employee>();

	    
		do
	    {
	    	System.out.println("\n**********Welcome to the Employee Management System***************\n");
	    	System.out.println("1).Add Employee to the database\n"+
	    	                           "2).Search for Employee\n"+
	    			                   "3).Edit Employee datails\n"+
	    	                           "4).Delete Employee datails\n"+
	    			                   "5).Display all Employee working in this company\n"+
	    	                           "6).Exit\n");
	        System.out.println("Enter your choice: ");
	        int ch=sc.nextInt();
	        
	        switch(ch)
	        {
	            case 1:
	        	       System.out.println("\nEnter the following details to ADD list:\n");
	        	       System.out.println("Enter ID: ");
	        	       id=sc.nextInt();
	        	       System.out.println("Enter Name: ");
	        	       name=sc.next();
	        	       System.out.println("Enter Department: ");
	        	       department=sc.next();
	        	       System.out.println("Enter Salary: ");
	        	       salary=sc.nextFloat();
	        	       System.out.println("Enter Email_id: ");
	        	       email_id=sc.next();
	        	       System.out.println("Enter Contantno: ");
	        	       contact_no=sc.nextLong();
	        	       
	        	       al.add(new Employee(id,name,department,salary,contact_no,email_id));
	        	       display(al);
	        	break;
	        	
	            case 2:
	            	   System.out.println("\nEnter the Employee id to search: ");
	            	      id=sc.nextInt();
	            	      int i=0;
	            	      for(Employee e:al)
	            	      {
	            	    	  if(id==e.id)
	            	    	  {
	            	    		  System.out.println(e+"\n");
	            	    		  i++;
	            	    	  }
	            	      }
	            	      if(i==0)
	            	      {
	            	    	  System.out.println("\nEmployee details are not found,\n Please enter a vaild ID");
	            	      }
	           break;
	            case 3:
	            	System.out.println("\nEnter the Employee ID to EDIT the details");
					id = sc.nextInt();
					int j=0;
					for(Employee e: al)
					{
						if(id == e.id)
						{	
							j++;
						do{
							int ch1 =0;
							System.out.println("\nEDIT Employee Details :\n" +
												"1). Employee ID\n" +
												"2). Name\n" +
												"3).Department\n"+
												"4). Salary\n" +
												"5). Contact No.\n" +
												"6). Email-ID\n" +
												"7). GO BACK\n");
							System.out.println("Enter your choice : ");
							ch1 = sc.nextInt();
							switch(ch1)
							{
							case 1: 
								    System.out.println("\nEnter new Employee ID:");
									e.id =sc.nextInt();
									System.out.println(e+"\n");
									break;
							
							case 2:
								    System.out.println("Enter new Employee Name:");
									e.name =sc.next();
									System.out.println(e+"\n");
									break;
									
							case 3: 
								    System.out.println("Enter new Employee Department:");
							        e.department =sc.next();
							        System.out.println(e+"\n");
							        break;
							
							case 4: 
								    System.out.println("Enter new Employee Salary:");
									e.salary =sc.nextFloat();
									System.out.println(e+"\n");
									break;
									
							case 5: 
								    System.out.println("Enter new Employee Contact No. :");
									e.contact_no =sc.nextLong();
									System.out.println(e+"\n");
									break;
									
							case 6: 
								    System.out.println("Enter new Employee Email-ID :");
									e.email_id =sc.next();
									System.out.println(e+"\n");
									break;
									
							case 7: j++;
									break;
									
							default : 
								        System.out.println("\nEnter a correct choice from the List :");
										break;
							
							}
							}
						     while(j==1);
						    }
					     }
					     if(j == 0)
					     {
						    System.out.println("\nEmployee Details are not found, Please enter a valid ID!!");
					     }
				 break;
	            case 4:
	            	System.out.println("\nEnter Employee ID to DELETE from the Database :");
					id = sc.nextInt();
					int k=0;
					try
					{
						for(Employee e: al)
						{
							if(id == e.id)
							{
									al.remove(e);
									display(al);
									k++;
							}
						}
						if(k == 0)
						{
							System.out.println("\nEmployee Details are not found, Please enter a valid ID!!");
						}	
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					
					
		       break;
	            case 5:
	            	System.out.println("Display All Employee Working in this company");
					display(al);
				break;
	            case 6:
	            	
					    System.out.println("\nYou have chosen EXIT !! Saving Files and closing the tool.");
					    sc.close();
						System.exit(0);
				break;
						
				default : 
					System.out.println("\nEnter a correct choice from the List.");
				break;	 
	        }
	    }
	    while(true);

	}

}