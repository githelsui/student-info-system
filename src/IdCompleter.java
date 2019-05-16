import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IdCompleter
{
	private ArrayList<Student> students;
	private File myFile;
	private JOptionPane frame;

	
	public IdCompleter(String file)
	{
		myFile = new File(file);
		students = new ArrayList<Student>();
		upperCaseArray();
		loadFile(myFile);
		completeId();
	}
	
	public void loadFile(File file)
	{
		try
		{
			Scanner infile = new Scanner(file);
			while(infile.hasNextLine()){
				students.add(new Student(infile.nextLine(),infile.nextLine()));
			}
			infile.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void addStudent(Student stu)
	{
		if(doesStudentExist(stu)==false)
		{	
			students.add(stu);
			sortList();
			try 
			{
				FileWriter fw = new FileWriter(myFile);
				PrintWriter pw = new PrintWriter(fw);
				for(Student s : students)
				{
					pw.print(s.getName());
					pw.print(System.getProperty("line.separator")); 
					pw.print(s.getId());
					pw.print(System.getProperty("line.separator")); 
				}
				
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, "The student [" + stu.getName() +" " + stu.getId() +"] has been added.");
		}
		else{
			JOptionPane.showMessageDialog(frame, "Student with the same ID already exists.");
		}
	}
	
	public ArrayList<Student> findStudent(String name)
	{
		ArrayList<Student> found = new ArrayList<Student>();
		for(int i =0; i < students.size(); i++)
		{
			if(students.get(i).getName().contains(name))
					found.add(students.get(i));
		}
		return found;
	}
	
	public boolean doesStudentExist(Student stu)
	{
		for(int i =0; i < students.size(); i++)
		{
			if(students.get(i).getId().equals(stu.getId()))
				return true;
		}
		return false;
	}
	
	
	
	public void completeId()
	{
		for(int i = 0; i <students.size(); i++)
		{
			String id = students.get(i).getId();
			while(id.length() < 6)
			{
				id = "0" + id;
			}
			students.get(i).setId(id);
		}
	}

	public void removeStudent(Student stu)
	{
		if(doesStudentExist(stu))
		{
			for(int i = (students.size()-1); i >= 0; i--)
			{
				if(students.get(i).getName().equals(stu.getName()) && students.get(i).getId().equals(stu.getId()))
				{
					students.remove(i);
				}
			}
			
			try 
			{
				FileWriter fw = new FileWriter(myFile);
				PrintWriter pw = new PrintWriter(fw);
				for(Student s : students)
				{
					pw.print(s.getName());
					pw.print(System.getProperty("line.separator")); 
					pw.print(s.getId());
					pw.print(System.getProperty("line.separator")); 
				}
				JOptionPane.showMessageDialog(frame, "Student " + stu.getName() + " " + stu.getId() + " has been removed.");
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
		JOptionPane.showMessageDialog(frame, "Student " + stu.getName() + " " + stu.getId() + " does not exist.");
		}
	}
	
	
	public void sortList()
	{
	           for (int outer = 1; outer < students.size(); outer++)
	          {
	            int position = outer;
	            Student key = students.get(position);    
	            while (position > 0 && students.get(position - 1).compareTo(key) > 0)
	            {
	              students.set(position, students.get(position - 1));
	              position--;
	            }
	            students.set(position,  key);
	          }
	        }
	
	public String displayNames()
	{
		String res = "";
		for(int i = 0; i < students.size(); i++)
		{
			res += (students.get(i)).getName().toUpperCase();
			res += "\n";
		}
		return res;
		
	}
	
	public String displayIds()
	{
		String res = "";
		for(int i = 0; i < students.size(); i++)
		{
			res += (students.get(i)).getId();
			res += "\n";
		}
		return res;
		
	}
	
	public ArrayList<Student> getList()
	{
		return students;
	}
	
	public void updateFile()
	{
		try 
		{
			FileWriter fw = new FileWriter(myFile);
			PrintWriter pw = new PrintWriter(fw);
			for(Student s : students)
			{
				pw.print(s.getName());
				pw.print(System.getProperty("line.separator")); 
				pw.print(s.getId());
				pw.print(System.getProperty("line.separator")); 
			}
			JOptionPane.showMessageDialog(frame, "Text file has been updated and saved. I will close now, goodbye!");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public boolean isFileEmpty()
		{
			if(students.size() <= 0)
			{
				return true;
			}
			return false;
		}
		
		private void upperCaseArray()
		{
			for(Student stu: students)
			{
				stu.getName().toUpperCase();
			}
		}
		
	
		
		
	
		
	}

		
	

