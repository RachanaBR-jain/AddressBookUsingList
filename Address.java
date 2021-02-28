public class Address {
	String area;
	String city;
	String state;
	int zip;

	public Address(String area,String city, String state, int zip) {
		this.area=area;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public void setArea(String area) {
		this.area = area;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public void setState(String state) {
		this.state = state;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public String getArea() {
		return area;
	}


	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZip() {
		return zip;
	}

	@Override
	public String toString() {
		return "Address --> \n area= "+area+"\n city=" + city + ", \n state=" + state + ", \n zip=" + zip;
	}
}

