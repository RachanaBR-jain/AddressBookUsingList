import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface iContactDetails{
	public void addDetails(String firstName, String lastName, Address address,int phoneNumber ,String email);
	
}


public class AddressBook implements iContactDetails{

		private static int numOfPerson;
		private List<ContactDetails> contactDetailsList;
	
		public AddressBook(){
			contactDetailsList = new ArrayList<>();
		}

		@Override 
		public void addDetails(String firstName, String lastName, Address address, int phoneNumber, String email) {
			ContactDetails contactDetails= new ContactDetails(firstName, lastName, address, phoneNumber, email);
			contactDetailsList.add(contactDetails);
			numOfPerson++;
		}
		private void computeDetails(){
			for (int i=0; i<contactDetailsList.size(); i++){
				ContactDetails contactDetails=contactDetailsList.get(i);
				System.out.println(contactDetails);
			}
		}

		public static void main(String[] args){

			System.out.println("Welcome To Address Book Problem");

			Scanner sc=new Scanner(System.in);

			System.out.println("Number no of list of person to be added in AddressBook");
			int numOfPerson=sc.nextInt();
			String name=sc.nextLine();
			AddressBook rachu = new AddressBook();
		
			for (int i = 1; i <= numOfPerson; i++) {

				System.out.println("Enter of details of person: "+i);

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
				Address rachu1=new Address(area,city,state,zip);
				rachu.addDetails(firstName, lastName, rachu1, phoneNumber, email);
				rachu.computeDetails();
			}
		}
	}


			
		//
