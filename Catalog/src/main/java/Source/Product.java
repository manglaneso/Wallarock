package Source;

import java.io.Serializable;
import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	@Column(name="image_path")
	private String imagePath;

	private int price;

	private String title;

	@Column(name="id_category")
	private int category;
	
	private int status;
	//bi-directional many-to-one association to Category
//	@ManyToOne
//	@JoinColumn(name="id_category")
//	@JsonBackReference(value="cat")
//	private Category category;

	//bi-directional one-to-one association to Status	
//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name="status")
//	@JsonBackReference
//	private Status statusBean;	

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="email_user")
	private Users users;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory() {
		return this.category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public Users getUser() {
		return this.users;
	}

	public void setUser(Users user) {
		this.users = user;
	}

}