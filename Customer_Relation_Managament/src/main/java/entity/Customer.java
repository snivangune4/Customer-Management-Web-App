package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String first_Name;
	private String last_Name;
	private String email_Address;
	
	public Customer() {
		
	}

	public Customer(String first_Name, String last_Name, String email_Address) {

		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email_Address = email_Address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail_Address() {
		return email_Address;
	}

	public void setEmail_Address(String email_Address) {
		this.email_Address = email_Address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", First_Name=" + first_Name + ", last_Name=" + last_Name + ", email_Address="
				+ email_Address + "]";
	}
	
}
