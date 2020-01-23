package paraballo;

import java.util.Base64;
import javax.persistence.*;
@Table
@Entity
public class imglaptop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String base64Image;
	private byte[] image;
	
	public imglaptop(){}
	public imglaptop(String base64Image) {
		super();
		//this.id = id;
		this.base64Image=base64Image;
		//this.image = image;
	}
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
		
	}
	@Transient
	/**public String getByteArrayString()
	{
	   return new String(this.image);
	}**/
	public String getBase64Image() {
	   // base64Image = Base64.getEncoder().encodeToString(this.image);
     
		return base64Image;
	}

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
    
}
