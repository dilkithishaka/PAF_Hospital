package com;

import java.sql.*;

import java.util.List;
import db.Database;
import model.HospitalModel;

public class HospitalService {

	/*
	 * Connection con = null;
	 * 
	 * public HospitalService() { String dbURL =
	 * "jdbc:mysql://localhost:3306/hospitaldb"; String dbUname = "root"; String
	 * dbPassword = "root";
	 * 
	 * try { Class.forName("com.mysql.jdbc.Driver"); con = (Connection)
	 * DriverManager.getConnection(dbURL, dbUname, dbPassword);
	 * System.out.println("connected"); } catch (Exception e) { // TODO: handle
	 * exception System.out.println(e); } }
	 */
	// Insert method which insert data to hospital table
	public String insertHospital(String hospitalName, String city, String address, String email, String contactNumber) {
		String output = "";
		try {
			Connection con = Database.connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			String query = " insert into hospital_table(`hospitalID`,`hospitalName`,`city`,`address`,`email`,`contactNumber`)"
					+ " values (?, ?, ?, ?, ?,?)";
			PreparedStatement st = con.prepareStatement(query);

			st.setInt(1, 0);
			st.setString(2, hospitalName);
			st.setString(3, city);
			st.setString(4, address);
			st.setString(5, email);
			st.setString(6, contactNumber);

			st.execute();
			con.close();
			
			String newRecord = viewHospitals();
			output = "{\"status\":\"success\", \"data\": \"" + newRecord + "\"}";
			//output = "Inserted successfully";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the record.\"}"; 
			System.err.println(e.getMessage());
		}
		return output;
	}

	// GetAll inserted Hospital data
	public String viewHospitals() {
		String output = "";
		try {
			Connection con = Database.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// displaying HTML table
			output = "<table border=\"1\"><tr><th>HospitalID</th><th>HospitalName</th><th>city</th><th>address</th><th>email</th><th>contactNumber</th><th>Update</th><th>Delete</th></tr>";
			String query = "select * from hospital_table";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				String hospitalID = Integer.toString(rs.getInt("hospitalID"));
				String hospitalName = rs.getString("hospitalName");
				String city = rs.getString("city");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String contactNumber = rs.getString("contactNumber");

				// Add into the HTML table
				output += "<tr><td>" + hospitalID + "</td>";
				output += "<tr><td><input id=\"hidItemIDUpdate\"name=\"hidItemIDUpdate\"type=\"hidden\" value=\""
						+ hospitalID + "\">" + hospitalID + "</td>";
				output += "<td>" + hospitalName + "</td>";
				output += "<td>" + city + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + contactNumber + "</td>";

				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td> "
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='\""
						+ hospitalID + "\"'>";
				/*
				 * output +=
				 * "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
				 * + "<td><form method=\"post\" action=\"items.jsp\">" +
				 * "<input name=\"btnRemove\" type=\"submit\" value=\"Delete\"class=\"btn btn-danger\">"
				 * + "<input name=\"itemID\" type=\"hidden\" value=\"" + hospitalID + "\">" +
				 * "</form></td></tr>";
				 */

			}
			con.close();
			// Complete the HTML table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the hospital details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Update hospital table
	public String updateHospital(String hospitalID, String hospitalName, String city, String address, String email,
			String contactNumber) {
		String output = "";
		try {
			Connection con = Database.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			String query = "UPDATE hospital_table SET hospitalName=?,city=?,address=?,email=?,contactNumber=? WHERE hospitalID=?";
			PreparedStatement sm = con.prepareStatement(query);

			sm.setInt(1, Integer.parseInt(hospitalID));
			sm.setString(2, hospitalName);
			sm.setString(3, city);
			sm.setString(4, address);
			sm.setString(5, email);
			sm.setString(6, contactNumber);

			sm.execute();
			con.close();

			String newRecord = viewHospitals();
			output = "{\"status\":\"success\", \"data\": \"" + newRecord + "\"}";
			//output = "Updated successfully";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the record.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Delete hospital table
	public String deleteHospital(String hospitalID) {
		String output = "";

		try {
			Connection con = Database.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from hospital_table where hospitalID=?";
			PreparedStatement stmt = con.prepareStatement(query);
			// binding values
			stmt.setInt(1, Integer.parseInt(hospitalID.substring(1, hospitalID.length() - 1)));
			// execute the statement
			stmt.execute();
			con.close();
			String newRecord = viewHospitals();
			output = "{\"status\":\"success\", \"data\": \"" + newRecord + "\"}";
		} catch (Exception e) {
			e.printStackTrace();
			output = "{\"status\":\"error\", \"data\": \"Error while updating the record.\"}";
			System.err.println(e.getMessage());
		}

		return output;
	}

	/*
	 * public HospitalModel searchHospital(int hospitalID) { // TODO Auto-generated
	 * method stub String sql = "SELECT * FROM hospital_table WHERE hospitalID = " +
	 * hospitalID; HospitalModel h = new HospitalModel();
	 * 
	 * try { Statement statement = con.createStatement(); ResultSet result =
	 * statement.executeQuery(sql);
	 * 
	 * while (result.next()) { h.setHospitalID(result.getInt(1));
	 * h.setHospitalName(result.getString(2)); h.setCity(result.getString(3));
	 * h.setAddress(result.getString(4)); h.setEmail(result.getString(5));
	 * h.setContactNumber(result.getString(6));
	 * 
	 * } } catch (Exception e) { // TODO: handle exception System.out.println(e); }
	 * return h; }
	 */

	public List<HospitalModel> viewDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HospitalModel> viewPayments() {
		// TODO Auto-generated method stub
		return null;
	}

	// Insert method which insert data to doctor table
	public String insertDoctor(Integer hospitalID, Integer doctorID) {
		String output = "";
		try {
			Connection con = Database.connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			String query = " insert into doctor_table(`hospitalID`,`doctorID`)" + " values (?, ?)";
			PreparedStatement st = con.prepareStatement(query);

			st.setInt(1, hospitalID);
			st.setInt(2, doctorID);

			st.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// Get Hospital data by ID
	public HospitalModel getHospitalById(String hospitalID) {

		HospitalModel hospital = new HospitalModel();

		try {
			Connection con = Database.connect();

			String query = "select * from hospital_table where hospitalID=?";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(hospitalID));

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				hospital.setHospitalID(Integer.parseInt(hospitalID));
				hospital.setHospitalName(rs.getString("HospitalName").toString());
				hospital.setCity(rs.getString("city"));
				hospital.setAddress(rs.getString("address"));
				hospital.setEmail(rs.getString("email"));
				hospital.setContactNumber(rs.getString("contactNumber"));
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return hospital;
	}

	public HospitalModel getDoctorByHospitalId(String doctorID, String hospitalID) {
		// TODO Auto-generated method stub

		HospitalModel hospital = new HospitalModel();

		try {
			Connection con = Database.connect();

			String query = "select * from doctor_table where doctorID=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(doctorID));

			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				hospital.setDoctorID(Integer.parseInt(doctorID));
				hospital.setHospitalID(Integer.parseInt(hospitalID));

			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return hospital;

	}

	public HospitalModel viewPaymentByHospitalId(int hospitalID) {
		// TODO Auto-generated method stub
		return null;
	}

}
