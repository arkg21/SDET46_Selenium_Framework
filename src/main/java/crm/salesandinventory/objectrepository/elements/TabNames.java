package crm.salesandinventory.objectrepository.elements;

public enum TabNames 
{

	EMPLOYEE("Employee"),ACCOUNT("Accounts"),TRANSACTION("Transaction"),CUSTOMER("Customer"),POS("POS"),PRODUCT("Product"),SUPPLIER("Supplier");
	private String tabname;

	private TabNames(String tabname)
	{
		this.tabname=tabname;

	}
	public String getTab() 
	{
		return tabname;
	}

}
