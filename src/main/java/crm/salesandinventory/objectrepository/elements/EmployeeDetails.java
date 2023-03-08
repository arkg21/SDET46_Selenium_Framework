package crm.salesandinventory.objectrepository.elements;

public enum EmployeeDetails 
{
	FIRSTNAME("firstname"),LASTNAME("lastname"),GENDER("gender"),EMAIL("email"),PHONENUMBER("phonenumber"),HIREDDATE("hireddate"),PROVINCE("province");
	private String empname;

	private EmployeeDetails(String empname)
	{
		this.empname=empname;

	}
	public String getTab() 
	{
		return empname;
	}
}
