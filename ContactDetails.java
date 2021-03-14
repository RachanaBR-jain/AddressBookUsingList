public class ContactDetails {

	public String firstName;
	public String lastName; 
	public int phoneNumber;
	public String email;
	String area;
	String city;
	String state;
	int zip;



	public ContactDetails(String firstName, String lastName, String area, String city,String state,int zip,int phoneNumber ,String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName; 
		this.area=area;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phoneNumber=phoneNumber; 
		this.email = email;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state; 
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "ContactDetails--> \n firstName=" + firstName + "\n lastName=" + lastName + "\n phoneNumber=" + phoneNumber
				+ "\n email=" + email + "\n area=" + area + "\n city=" + city + "\n state=" + state + "\n zip=" + zip + "\n";
		
	}
}




