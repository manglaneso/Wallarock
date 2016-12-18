package Source;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class Controllercillo {
	
	@Autowired
	ProductDAO daoPr;
	
	@Autowired
	UserDAO daoUs;
	
	@RequestMapping(method=RequestMethod.GET, value = "/catalog/allproducts")
	public List<Product> getAllProducts() {
		return daoPr.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/catalog/simplesearch/{query}")
	public List<Product> simpletitlesearch(@PathVariable String query) {
		return daoPr.findByDescriptionOrTitleContains(query, query);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/catalog/advancedsearch/{query}/{category}")
	public List<Product> advancedsearch(@PathVariable String query, @PathVariable int category) {
		return daoPr.findByDescriptionOrTitleContainsAndCategory(query, query, category);
	}
	

	@RequestMapping(method=RequestMethod.GET, value = "/catalog/topsixbyprice")
	public List<Product> getSixTopProducts() {
		return daoPr.findTop6ByOrderByPriceDesc();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/catalog/productsbyuseremail/{email}/")
	public List<Product> getAllProductsByUser(@PathVariable String email) {
		Users u = daoUs.findByEmail(email);
		return daoPr.findByUsers(u);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/catalog/getproduct/{id}/")
	public Product getProductById(@PathVariable int id) {
		return daoPr.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/catalog/productsbycategory/{category}/")
	public List<Product> getProductsByCategory(@PathVariable int category) {
		return daoPr.findByCategory(category);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/catalog/productsbyprice/{price}/")
	public List<Product> getProductsByPrice(@PathVariable int price) {
		return daoPr.findByPrice(price);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/catalog/productsbytitle/{title}/")
	public List<Product> getProductsByTitle(@PathVariable String title) {
		return daoPr.findByTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/catalog/deleteproduct/{id}")
	public void deleteProduct(@PathVariable int id){
		daoPr.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/catalog/createproduct")
	public Product createProduct(@RequestBody @Validated Product p) {
		p.setImagePath("http://localhost:8020/images/" + p.getUser().getEmail() + File.separator + p.getImagePath());
		return daoPr.save(p);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/catalog/uploadPhoto")
	public String uploadPhotoHandler(@RequestParam("useremail") String useremail,
			@RequestParam("file") MultipartFile file) {	
		
		String imagePath = file.getOriginalFilename();
		
		String b = null;
		try {
			b = java.net.URLDecoder.decode(useremail, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String name = b + "/" + imagePath;
		List<Product> a = daoPr.findByimagePath("http://localhost:8020/images/" + name);
		if(!a.isEmpty()) {
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "images");
					if (!dir.exists()) {
						dir.mkdirs();
					}
					File d = new File(rootPath + File.separator + "images" + File.separator + b);
					if (!d.exists()) {
						d.mkdirs();
					}
					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();					

				} catch (Exception e) {
					return "You failed to upload " + name + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + name
						+ " because the file was empty.";
			}
		}
		return "You successfully uploaded file=" + name;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/catalog/updateproduct")
	public Product updateProduct(@RequestBody @Validated Product p) {
		Product old = daoPr.findOne(p.getId());
		old.setDescription(p.getDescription());
		old.setCategory(p.getCategory());
		old.setPrice(p.getPrice());
		old.setStatus(p.getStatus());
		old.setTitle(p.getTitle());
		old.setImagePath("http://localhost:8020/images/" + p.getUser().getEmail() + File.separator + p.getImagePath());
		return daoPr.save(old);
	}	
}
