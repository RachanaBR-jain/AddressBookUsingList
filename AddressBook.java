import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

interface iContactDetails{
	public void addDetails();
	public void editDetails();
	public void deleteDetails();
	public void create_mulipleAddressBook();


}


public  class AddressBook implements iContactDetails{ 

	static ArrayList<ContactDetails> list = new ArrayList<ContactDetails>();
	static Map<String,AddressBook> map = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	public static String firstName;
	public static String lastName;


	public boolean checkDuplicateName()
	{

		System.out.println("Enter FirstName");
		firstName=sc.next();
		System.out.println("Enter LastName");
		lastName=sc.next();

		for(int i=0;i<list.size();i++)
		{
			if(firstName.equals(list.get(i).getFirstName()) && lastName.equals(list.get(i).getLastName())) 
				System.out.println("your name is already in list, Please press option 2 to edit the list");
			selectInput();
			return true;
		}
		return false;
	}

	@Override 
	public  void addDetails()
	{

		if(!checkDuplicateName())
		{

			System.out.println("Enter Area");
			String area=sc.next(); 
			System.out.println("Enter CityName");
			String city=sc.next();
			System.out.println("Enter StateName");
			String state=sc.next();
			System.out.println("Enter ZipCode");
			int zip=sc.nextInt();
			System.out.println("Enter PhoneNumber");
			int phoneNumber=sc.nextInt();
			System.out.println("Enter Email");
			String email=sc.next();
			Address address1=new Address(area,city,state,zip);
			list.add( new ContactDetails(firstName, lastName, address1, phoneNumber, email));
		}
		System.out.println(list);
	} 

	public void editDetails() {

		String name1;
		System.out.println("Enter First Name of Details to be Edited: ");
		name1 = sc.next();
		String state = null;
		int zip = 0;
		String city = null;
		String area = null;
		Address address2=new Address(area,city,state,zip);
		for(int i=0; i<list.size(); i++) 
		{
			if (name1.equals(list.get(i).getFirstName())) {

				System.out.println("Enter FirstName");
				list.get(i).setFirstName(sc.next());
				System.out.println("Enter LastName"); 
				list.get(i).setLastName(sc.next());
				System.out.println("Enter Area");
				address2.setArea(sc.next()); 
				System.out.println("Enter City");
				address2.setCity(sc.next());
				System.out.println("Enter State");
				address2.setState(sc.next()); 
				System.out.println("Enter zip");
				address2.setZip(sc.nextInt());
				System.out.println("Enter PhoneNumber"); 
				list.get(i).setPhoneNumber(sc.nextInt());
				System.out.println("Enter Email");
				list.get(i).setEmail(sc.next());

				System.out.println(list.get(i));
				System.out.println("edited");
			}else{
				System.out.println( "Name Not Available in List");

			}
		}
	}

	public void  deleteDetails() {

		System.out.println("Enter First Name of Details to be deteted: ");
		String name = sc.next();
		for(int i=0;i<=list.size();i++)
		{
			if (name.equals(list.get(i).getFirstName())) {
				list.remove(i);
				System.out.println("Deleted"); 
			}else{
				System.out.println("Name Not Available in List");
			} 
		}

	}

	public void create_mulipleAddressBook()
	{
		System.out.println("----- new AddressBook------");
		System.out.println("Enter name of new address book"); 
		String addressbook_name = sc.next();
		AddressBook addressBook  = new AddressBook();
		map.put(addressbook_name, addressBook); 
		System.out.println("new address book added -->"+addressbook_name);  
	} 

	public  void show_AddressBooks(){
		System.out.println("Available address books are");
		for(int j=0; j<map.size(); j++)
		{   
			System.out.println("_____________________________________________");
			System.out.println("list of person in AddressBook are");
			System.out.println(list.get(j));
		}
	}

	public void selectInput()
	{
		System.out.println("0-Add Address book \n1- Add contact \n2-Edit contact \n3-delete contact \n4- view all contacts. \n5-Exit");
		System.out.print("\nEnter choice: ");
		int  choice=sc.nextInt();

		switch(choice){
		case 0:
			create_mulipleAddressBook(); 
			selectInput();
			break;
		case 1:
			addDetails();
			selectInput();
			break;
		case 2:
			editDetails();
			selectInput();
			break;
		case 3:
			deleteDetails();
			selectInput();
			break;
		case 4: 
			show_AddressBooks();
			break;
		case 5:
			System.out.println("Thankyou for Details");
			break;
		default:
			System.out.println("Invalid input");
			selectInput();
		}

	} 

	public static void main(String[] args) {

		AddressBook person=new AddressBook();
		System.out.println("Welcome To Address Book Problem");
		person.selectInput();

	}
} 






