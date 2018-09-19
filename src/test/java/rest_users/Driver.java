package rest_users;

public class Driver {
	
	String driverId;
	String nationality;
	String givenName;
	String familyName;
	String dateOfBirth;
	String url;
	
	public Driver() {
		
	}
	
	public Driver(String driverId, String nationality, String givenName, String familyName, String dateOfBirth,
			String url) {
		super();
		this.driverId = driverId;
		this.nationality = nationality;
		this.givenName = givenName;
		this.familyName = familyName;
		this.dateOfBirth = dateOfBirth;
		this.url = url;
	}
	
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", nationality=" + nationality + ", givenName=" + givenName
				+ ", familyName=" + familyName + ", dateOfBirth=" + dateOfBirth + ", url=" + url + "]";
	}
	
	
	

}
