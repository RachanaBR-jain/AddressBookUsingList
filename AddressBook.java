import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface iContactDetails{
	public  void addDetails();

}


public class AddressBook implements iContactDetails{

	static ArrayList<ContactDetails> list = new ArrayList<ContactDetails>();
	static Scanner sc = new Scanner(System.in);

	@Override 
	public  void addDetails()
	{

		System.out.println("Enter FirstName");
		String firstName=sc.next();
		System.out.println("Enter LastName");
		String lastName=sc.next();
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
		System.out.println(list);
	}

	public static String editDetails() {

		String name1;
		System.out.println("Enter First Name of Details to be Edited: ");
		name1 = sc.next();
		String state = null;
		int zip = 0;
		String city = null;
		String area = null;
		Address address2=new Address(area,city,state,zip);
		if (name1.equals(list.get(0).getFirstName())) {

			System.out.println("Enter FirstName");
			list.get(0).setFirstName(sc.next());
			System.out.println("Enter LastName");
			list.get(0).setLastName(sc.next());
			System.out.println("Enter Area");
			address2.setArea(sc.next());
			System.out.println("Enter City");
			address2.setCity(sc.next());
			System.out.println("Enter State");
			address2.setState(sc.next());
			System.out.println("Enter zip");
			address2.setZip(sc.nextInt());
			System.out.println("Enter PhoneNumber"); 
			list.get(0).setPhoneNumber(sc.nextInt());
			System.out.println("Enter Email");
			list.get(0).setEmail(sc.next());

			System.out.println(list.get(0));
			return "Edited"; 
		}else{
			return "Name Not Available in List";
		} 
	}

	public static String deleteDetails() {

		System.out.println("Enter First Name of Details to be deteted: ");
		String name2 = sc.next();

		if (name2.equals(list.get(0).getFirstName())) {
			list.remove(0);
			return "Deleted"; 
		}else{
			return "Name Not Available in List";
		} 
	}

	public static void main(String[] args){

		AddressBook person=new AddressBook();
		System.out.println("Welcome To Address Book Problem");
		Scanner sc=new Scanner(System.in); 

		System.out.println("Number no of list of person to be added in AddressBook");
		int numOfPerson=sc.nextInt();

		for (int i = 1; i <= numOfPerson; i++) { 

			System.out.println("Enter of details of person: "+i);
			person.addDetails();
		}

		System.out.println("Do to need to edit the exiting user details Y / N? ");
		char edit=sc.next().toUpperCase().charAt(0);

		if (edit=='Y') {
			System.out.println(editDetails()); 
		}else{
			System.out.println("Done");
		}

		System.out.print("Do you want to Delete That Contact ? (y/n)");
		char delete=sc.next().toUpperCase().charAt(0); 
		if (delete=='Y'){
			System.out.println(deleteDetails());
		}else{
			System.out.println("Done");
		}

		for(int j=0; j<list.size(); j++)
			System.out.println(list.get(j));

		sc.close();

	}
}




