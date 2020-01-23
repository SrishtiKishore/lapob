package paraballo;


import javax.persistence.*;

@Table(name="cart")
@Entity

public class cart_tab {
   
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	@SequenceGenerator(name = "cart_seq", allocationSize = 1, initialValue = 1)
    
	private int id1;
	private String email;
	private int id;
	private int type;
	
	public cart_tab() {}
	
	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public cart_tab( String email, int id, int type) {
		super();
		this.email = email;
		this.id = id;
		this.type = type;
	}
	
	
	
	
}
