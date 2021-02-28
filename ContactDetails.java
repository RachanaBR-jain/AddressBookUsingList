
public class ContactDetails {

	public String firstName;
	public String lastName; 
	public Address address;
	public int phoneNumber;
	public String email;



	public ContactDetails(String firstName, String lastName, Address address,int phoneNumber ,String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber=phoneNumber;
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	} 


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return " Person details \n FirstName=" + firstName +"\n lastName=" + lastName +"\n address=" + address + "\n phoneNumber="+ phoneNumber+"\n email="+ email;
	}



}




