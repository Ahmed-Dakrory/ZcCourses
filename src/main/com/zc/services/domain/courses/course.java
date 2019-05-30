/**
 * 
 */
package main.com.zc.services.domain.courses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String image;
	
	@Column(name = "idProgram")
	private Integer idProgram;
	
	@Column(name = "categories")
	private String categories;
	
	@Column(name = "payLink")
	private String payLink;
	
	
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

	
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
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

	
	public String getPayLink() {
		return payLink;
	}

	public void setPayLink(String payLink) {
		this.payLink = payLink;
	}

	
	
}
