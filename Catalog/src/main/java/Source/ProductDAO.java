package Source;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {
	public Product findById(int id);
	public List<Product> findByimagePath(String imagePath);
	public List<Product> findByUsers(Users user);
	public List<Product> findAll();
	public List<Product> findByTitle(String title);
	public List<Product> findByPrice(int price);
	public List<Product> findByTitleAndPrice(String title, int price);
	
	public List<Product> findTop6ByOrderByPriceDesc();
	
	public List<Product> findByTitleContains(String title);
	public List<Product> findByDescriptionContains(String description);
	public List<Product> findByCategory(int category);
	
	public List<Product> findByDescriptionOrTitleContains(String query1, String query2);
	public List<Product> findByDescriptionOrTitleContainsAndCategory(String query1, String query2, int category);
	
}
