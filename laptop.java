package paraballo;

import javax.persistence.Table;
import javax.persistence.Entity;

import javax.persistence.Id;


@Table(name="laptop")
@Entity
public class laptop {
	@Id
	private int id;
	private String name;
	private String os;
	private String processor_speed;
	private String ram;
	private String brand;
	private String architecture;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getProcessor_speed() {
		return processor_speed;
	}
	public void setProcessor_speed(String processor_speed) {
		this.processor_speed = processor_speed;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getArchitecture() {
		return architecture;
	}
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}
	public laptop() {}
	
	public laptop(int id, String name, String os, String processor_speed, String ram, String brand,
			String architecture) {
		super();
		this.id = id;
		this.name = name;
		this.os = os;
		this.processor_speed = processor_speed;
		this.ram = ram;
		this.brand = brand;
		this.architecture = architecture;
	}
	

	
}
