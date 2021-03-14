import java.util.*;
import java.util.stream.*;

public  class AddressBook implements iContactDetails{ 

	static ArrayList<ContactDetails> list = new ArrayList<ContactDetails>();
	static Map<String,AddressBook> map = new HashMap<>();

	public static Map<String, String> dictionaryCity=new HashMap<>();
	public static Map<String, String> dictionaryState=new HashMap<>();

	public static Map<Integer,String> cityCount = new HashMap<>();
	public static Map<Integer,String> stateCount = new HashMap<>();


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
			{
				return true;
			}
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
			list.add( new ContactDetails(firstName, lastName, area,city,state,zip, phoneNumber, email));
			System.out.println(list);
		} 
	} 

	@Override
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

	@Override
	public void  deleteDetails() {

		System.out.println("Enter First Name to be deleted from Details: ");
		String name = sc.next();
		for(int i=0;i<list.size();i++)
		{
			if (checkDuplicateName()) {
				list.remove(i);
				System.out.println("Deleted"); 
			}else{
				System.out.println("Name Not Available in List");

			} 
		}

	}

	@Override
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
		for(int j=0; j<list.size(); j++)
		{   
			System.out.println("_____________________________________________");
			System.out.println("list of person in AddressBook are");
			System.out.println(list.get(j));
			System.out.println("_____________________________________________");
		}
	}

	@Override
	public void search_personByState() {

		System.out.println("Enter State Name you need to search");
		String state = sc.next();
		list.forEach(i -> list.stream()
				.filter(address -> i.getState().equals(state))
				.forEach(System.out::println));
	}

	@Override
	public void search_personByCity() {

		System.out.println("Enter City Name you need to serach");
		String city = sc.next();
		list.forEach(i -> list.stream()
				.filter(address -> i.getCity().equals(city))
				.forEach(System.out::println));
	}

	@Override
	public void viewPersonBasedOnCity() {
		for (ContactDetails address: list)
		{
			String name = address.getFirstName() + " " + address.getLastName();
			dictionaryCity.put(name, address.getCity());
		}

		System.out.println("Enter City");
		String city= sc.next();
		for (Map.Entry<String, String> searchCity : dictionaryCity.entrySet())
			if (city.equals(searchCity.getValue()))
				System.out.println("Name " + searchCity.getKey()); 
	}
	@Override
	public  void viewPersonBasedOnState() {
		for (ContactDetails address1: list)
		{
			String name = address1.getFirstName()  + " " + address1.getLastName();
			dictionaryCity.put(name, address1.getState());
		}

		System.out.println("Enter State");
		String state= sc.next();
		for (Map.Entry<String, String> serachState : dictionaryCity.entrySet())
			if (state.equals(serachState.getValue()))
				System.out.println("Name " + serachState.getKey());
	}

	@Override
	public void getCityCount() 
	{		
		int city_count=0;
		for (ContactDetails address: list)
		{
			city_count++;
			cityCount.put(city_count,address.getCity());
		}
		cityCount.entrySet().stream().count();
		cityCount.entrySet().stream().forEach(city-> System.out.println("city_name " +city.getValue()+ " Number of person:"+ city.getKey()));
	}

	@Override
	public  void getStateCount() {
		int state_count=0;
		for (ContactDetails address: list) {
			state_count++;
			stateCount.put(state_count,address.getState());
		}
		stateCount.entrySet().stream().count();
		stateCount.entrySet().stream().forEach(state-> System.out.println("city_name " +state.getValue()+ " Number of person:"+ state.getKey()));
	}

	public void sort_name()  
	{
		/*for(int i=0;i<=(list.size()-1);i++)
		{
			for (int j = 0; j <( list.size()-1); j++)
			{
				if (list.get(j).getFirstName().compareTo(list.get(j+1).getFirstName())>0)
				{
					String temp = list.get(j).firstName;
					list.get(j).firstName= list.get(j+1).firstName;
					list.get(j+1).firstName = temp;
					System.out.println(list.get(j).getFirstName()+" "+list.get(j+1).getFirstName());
				} 
			}
		} */

		Comparator<ContactDetails> compareByName = Comparator
				.comparing(ContactDetails::getFirstName)
				.thenComparing(ContactDetails::getLastName);

		List<ContactDetails> sortedList = list.stream()
				.sorted(compareByName)
				.collect(Collectors.toList());
		System.out.println(sortedList);
	}
	public void sort_ByCity() 
	{
		Comparator<ContactDetails> compareByCity = Comparator
				.comparing(ContactDetails::getCity);

		List<ContactDetails> sortedListByArea = list.stream()
				.sorted(compareByCity)
				.collect(Collectors.toList());
		System.out.println(sortedListByArea);
	}

	public void sort_ByState() 
	{
		Comparator<ContactDetails> compareByState = Comparator
				.comparing(ContactDetails::getState);

		List<ContactDetails> sortedListByState = list.stream()
				.sorted(compareByState)
				.collect(Collectors.toList());
		System.out.println(sortedListByState);
	}

	public void sort_ByZip() 
	{
		Comparator<ContactDetails> compareByZip = Comparator
				.comparing(ContactDetails::getZip);

		List<ContactDetails> sortedListByZip = list.stream()
				.sorted(compareByZip)
				.collect(Collectors.toList());
		System.out.println(sortedListByZip);
	}

	public void sort()
	{
		System.out.println("Sort List based on \n1--->name \n2--->City \n3--->State \n4--->Zip ");
		System.out.print("\nEnter choice to sort : ");
		int  choice=sc.nextInt();
		switch(choice){
		case 1: sort_name();
		break;
		case 2: sort_ByCity();
		break;
		case 3: sort_ByState();
		break;
		case 4: sort_ByZip(); 
		break;
		default: System.out.println("Invalid choice");
		}
	}


	public void selectInput() 
	{
		System.out.println("0-Add Address book \n1-Add contact \n2-Edit contact \n3-Delete contact "
				+ "\n4-View all contacts \n5-Search person by state "
				+ "\n6-Search person by city  \n7-View person based on city  \n8-View person based on State"
				+ "\n9-count person based on city \n10-Count person based on state \n11-sortBasedOb->city/state/zip based on name, \n12-Exit");

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
			selectInput();
			break;
		case 5:
			search_personByState();
			selectInput();
			break;
		case 6:
			search_personByCity();
			selectInput(); 
			break;
		case 7:
			viewPersonBasedOnCity();
			selectInput(); 
			break;

		case 8:
			viewPersonBasedOnState();
			selectInput();
			break;

		case 9:
			getCityCount();
			selectInput();
			break;

		case 10:
			getStateCount();
			selectInput();
			break;	

		case 11: 
			sort();
			selectInput();
			break;
		case 12:
			System.out.println("Thankyou for Details");
			break;
		default:
			System.out.println("Invalid input");
			selectInput();
		}
	}
}

