package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD_Project {
	void display()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studends","root","Ammus@**312");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM demo");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	void insert()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studends","root","Ammus@**312");
			Scanner s=new Scanner(System.in);
			
			System.out.println("Enter Id:");
			int id=s.nextInt();
			s.nextLine();
			
			System.out.println("Enter Name:");
			String Name=s.nextLine();
			
			System.out.println("Enter Course");
			String Course=s.nextLine();
			
			String sql="INSERT INTO demo(Id,Name,Course)"+"VALUES(?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,id);
			statement.setString(2, Name);
			statement.setString(3, Course);
			
			int rows=statement.executeUpdate();
			
			if(rows>0)
			{
				System.out.println("A new Studens has been Inserted Successfully");
				
			}
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		
		}
	void update()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studends","root","Ammus@**312");
		String sql="UPDATE demo set NAME='sanny' WHERE id=10";
		//Statement statement=con.createStatement();
		PreparedStatement statement=con.prepareStatement(sql);

		int rows=statement.executeUpdate();
		
		if(rows>0)
		{
			System.out.println("The Students Information has been update was successfully");
		}
		
		}
	catch(Exception e)
	{
		System.out.println(e.toString());
			
	}
	}
	void delete()
	{
		try
		{
			
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studends","root","Ammus@**312");
		
		String sql="DELETE From demo WHERE id=11";
		//Statement statement=con.createStatement();
		PreparedStatement statement=con.prepareStatement(sql);

		
		int rows=statement.executeUpdate(sql);  
		if(rows>0)
		{
			System.out.println("The Students Information has been update was successfully");
		}


	}
    
	catch(Exception e)
	{
		System.out.println(e.toString());
			
	}
	}
	

	public static void main(String[] args) {
		CRUD_Project os=new CRUD_Project();
		Scanner s=new Scanner(System.in);
		System.out.println("*****&&&...GRUD PROJECT...&&&*****");
		
		System.out.println(" 1.Display\n 2.Insert\n 3.Update\n 4.Delete\n 5.Exit");
		
		
		while(true)
		{
			
			System.out.println("...&&****🤩🤩!!Enter a Choice🤩🤩!!****&&...");
			
		int Option=s.nextInt();
		switch(Option) 
		{
		case 1:
			System.out.println("@...*****1.Display*****...@");
			
			os.display();
			break;
		case 2:
			System.out.println("@...*****2.Insert*****...@");
			os.insert();
			break;
		case 3:
			System.out.println("@...*****3.Update*****...@");
			os.update();
			break;
		case 4:
			System.out.println("@...*****4.Delete*****...@");
			os.delete();
			break;
		case 5:
			System.out.println("@...****5.Exit of zero****...@");
			default:
				System.out.println("......****!!Choose the current option!!**..");
		}
		}

	}

}
