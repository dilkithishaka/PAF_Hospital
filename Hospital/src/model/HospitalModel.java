package model;

public class HospitalModel {

		private int hospitalID;
		private String hospitalName;
		private String city;
		private String address;
		private String email;
		private String contactNumber;
		private int doctorID;
		
		
		public int getDoctorID() {
			return doctorID;
		}
		public void setDoctorID(int doctorID) {
			this.doctorID = doctorID;
		}
		public int getHospitalID() {
			return hospitalID;
		}
		public void setHospitalID(int hospitalID) {
			this.hospitalID = hospitalID;
		}
		
		public String getHospitalName() {
			return hospitalName;
		}
		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		
		
}
