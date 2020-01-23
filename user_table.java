package paraballo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Table(name = "user_details")
@Entity
public class user_table {

	private String password;
	private String mobile;
	private String name;
	@Id
	private String email;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public user_table() {
		
	}
	public user_table(String name,  String email, String password, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}
	

}
