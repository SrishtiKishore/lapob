package paraballo;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
  
@Table(name="laptoptab")
@Entity
public class lap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
	@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)

		private int id;
private String NAME;
private String OS;
private String PROCESSOR;
private String RAM;
private String SYS_TYPE;
private String BRAND;
private String PROCESSING_SPEED;
private String architecture;
private String processor_speed;
private String available;
@ManyToOne(optional=false,cascade= {CascadeType.ALL})
@JoinColumn(unique=true)
private imglaptop img;

public lap() {}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public String getPROCESSOR() {
		return PROCESSOR;
	}
	public void setPROCESSOR(String pROCESSOR) {
		PROCESSOR = pROCESSOR;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public String getSYS_TYPE() {
		return SYS_TYPE;
	}
	public void setSYS_TYPE(String sYS_TYPE) {
		SYS_TYPE = sYS_TYPE;
	}
	public String getBRAND() {
		return BRAND;
	}
	public void setBRAND(String bRAND) {
		BRAND = bRAND;
	}
	public String getPROCESSING_SPEED() {
		return PROCESSING_SPEED;
	}
	public void setPROCESSING_SPEED(String pROCESSING_SPEED) {
		PROCESSING_SPEED = pROCESSING_SPEED;
	}
	public String getArchitecture() {
		return architecture;
	}
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}
	public String getProcessor_speed() {
		return processor_speed;
	}
	public void setProcessor_speed(String processor_speed) {
		this.processor_speed = processor_speed;
	}

	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}

	
	public imglaptop getImg() {
		return img;
	}
       
	public void setImg(imglaptop img) {
		this.img = img;
	}
    
	

	public lap( String nAME, String oS, String pROCESSOR, String rAM, String sYS_TYPE, String bRAND,
			String pROCESSING_SPEED, String architecture, String processor_speed, imglaptop img,String s) {
		super();
		//this.id = id;
		NAME = nAME;
		OS = oS;
		PROCESSOR = pROCESSOR;
		RAM = rAM;
		SYS_TYPE = sYS_TYPE;
		BRAND = bRAND;
		PROCESSING_SPEED = pROCESSING_SPEED;
		available=s;
		this.architecture = architecture;
		this.processor_speed = processor_speed;
		this.img = img;
		
	}

}
