package connection;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		IDepartmentService  service = new DepartmentServiceImp();
		Department dept1 = new Department();
		while(flag)
		{
			System.out.println("WELCOME TO DMS");
			System.out.println("1 - ADD Department");
			System.out.println("2 - UPDATE Department");
			System.out.println("3 - DELETE Department");
			System.out.println("4 - SELECT Department");
			System.out.println("5 - SELECT All");
			System.out.println("0 - EXIT");
			
		int n = sc.nextInt();
			switch(n)
			{
			case 1: 
				System.out.println("Enter dept.no");
				int dno1 = sc.nextInt();
				System.out.println("Enter dept name");
				String dname1 = sc.next();
				System.out.println("Enter location");
				String location1 = sc.next();
				
				dept1.setDno(dno1);
				dept1.setDname(dname1);
				dept1.setLocation(location1);
				if(service.dataValidation(dept1))
				{
					System.out.println("Record inserted "+service.addDept(dept1));
				}
				else
				{
					System.out.println("Invalid data, enter correct data");
				}
				break;
			case 2:
				System.out.println("Enter dept name");
				String dname2 = sc.next();
				System.out.println("Enter location");
				String location2 = sc.next();
				System.out.println("Enter dept.no");
				int dno2 = sc.nextInt();
				
				dept1.setDno(dno2);
				dept1.setDname(dname2);
				dept1.setLocation(location2);
				if(service.dataValidation(dept1))
				{
					System.out.println("Record updated "+service.updateDept(dept1));
				}
				else
				{
					System.out.println("Invalid data, enter correct data");
				}
				break;
			case 3:
				System.out.println("Enter dept.no to delete");
				int dno3 = sc.nextInt();
				System.out.println("deleted record "+service.deleteDeptByNo(dno3));
				if(service.deleteDeptByNo(dno3)==0)
				{
					try
					{
						throw new DeptNotFoundException();
					}
					catch (Exception e)
					{
						System.out.println("Dept no not found, enter valid dept number");
					}
				}
				break;
			case 4:
				System.out.println("Enter dept.no to get data");
				int dno4 = sc.nextInt();
				service.getDeptByNo(dno4);
				if(service.deleteDeptByNo(dno4)==0)
				{
					try
					{
						throw new DeptNotFoundException();
					}
					catch (Exception e)
					{
						System.out.println("Dept no not found, cannot retive record");
					}
				}
				break;
			case 5:
				service.selectAll();
				break;
			case 0:
				System.out.print("you are exited");
				flag = false;
				DBUtil.closeConnection();
				break;
			default :  
			}
		}
	}
}
