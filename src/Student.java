
public class Student implements Comparable
{
	private String myName;
	private String myId;
	
	public Student(String name, String id)
	{
		myName = name;
		myId= id;
	}
	
	public int compareTo(Object other)
	{
		Student temp = (Student) other;
		return getName().compareTo(temp.getName());
	}

	public String getName()
	{
		return myName;
	}

	public String getId()
	{
		return myId;
	}
	
	public void setId(String id)
	{
		myId = id;
	}
	
	public boolean equals(Object other)
	{
		if(compareTo(other)==0)
		{
			return true;
		}
		return false;
	}
	
}
