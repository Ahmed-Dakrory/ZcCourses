/**
 * 
 */
package main.com.zc.services.domain.courses;

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
	
	
	@NamedQuery(name="course.getAll",
		     query="SELECT c FROM course c"
		     )
	,
	@NamedQuery(name="course.getById",
	query = "from course d where d.id = :id"
			)
	
	,
	@NamedQuery(name="course.getByIdProgram",
	query = "from course d where d.idProgram = :idProgram"
			)
	
})

@Entity
@Table(name = "course")
public class course {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Integer price;
	
	@Column(name="image")
	@Lob
	private byte[] image;
	
	@Column(name = "idProgram")
	private Integer idProgram;
	
	@Column(name = "categories")
	private String categories;
	
	
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	

	public Integer getIdProgram() {
		return idProgram;
	}

	public void setIdProgram(Integer idProgram) {
		this.idProgram = idProgram;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getphoto() {
		String imageString= new String(Base64.encodeBase64(image));

		return "data:image/png;base64, "+imageString;
		
	}
	
}
