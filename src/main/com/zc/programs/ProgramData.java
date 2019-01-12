package main.com.zc.programs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


/**
 * @author dakrory
 *
 */


@NamedQueries({
	
	
	@NamedQuery(name="ProgramData.getAll",
		     query="SELECT c FROM ProgramData c"
		     )
	,
	@NamedQuery(name="ProgramData.getById",
	query = "from ProgramData d where d.id = :id"
			)
	
	
	
})

@Entity
@Table(name = "program")
public class ProgramData {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	
	@Column(name="img")
	@Lob
	private byte[] img;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	
	public String getphoto() {
		String imageString= new String(Base64.encodeBase64(img));

		return "data:image/png;base64, "+imageString;
		
	}

}
