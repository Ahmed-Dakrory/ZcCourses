package main.com.zc.services.domain.courses;


public class CourseDao {
	
	private Integer id;
	
	private String name;
	
	private String description;

	private Integer price;
	
	private String image;
	
	private Integer idProgram;
	
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
	
	
}
