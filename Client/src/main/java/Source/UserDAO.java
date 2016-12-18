package Source;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<Users, String> {
	
	public Users findByEmail(String email);
	public Users findByEmailAndPassword(String email, String password);
	public List<Users> findByName(String name);
	public List<Users> findByNameAndSurname(String name, String surname);
	public List<Users> findAll();
	

}
