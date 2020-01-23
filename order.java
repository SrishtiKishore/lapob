package paraballo;

import javax.persistence.*;


@Table(name="orderlist")
@Entity
public class order {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="order_seq")
	@SequenceGenerator(name="order_seq",allocationSize=1,initialValue=1)
	private  int id;	
	private String email;
	private int pid;
	private int type;

	public order() {}
	
	
public order( String email, int pid, int type) {
		super();
		this.email = email;
		this.pid = pid;
		this.type = type;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getpid() {
		return pid;
	}
	public void setpid(int pid) {
		this.pid = pid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	
}
