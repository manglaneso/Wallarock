package Source;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controllercillo {

	@Autowired
	UserDAO daoUs;
	
	@RequestMapping(method=RequestMethod.GET, value="/client/allusers")
	public List<Users> getUsers() {
		return daoUs.findAll();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/client/deleteuser/{email}")
	public void deleteUser(@PathVariable String email){
		daoUs.delete(email);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/client/createuser")
	public Users createUser(@RequestBody @Validated Users u){
		return daoUs.save(u);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/client/modifyuser")
	public Users modifyUser(@RequestBody @Validated Users u){
		daoUs.delete(u.getEmail());
		return daoUs.save(u);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/client/getuser/{email}")
	public Users getUser(@PathVariable String email){
		return daoUs.findByEmail(email);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/client/checkcredentials/{email}/{password}")
	public Users checkCredentials(@PathVariable String email, @PathVariable String password){
		return daoUs.findByEmailAndPassword(email, password);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/client/getifadmin/{email}")
	public boolean getIfAdmin(@PathVariable String email){
		Users u = daoUs.findByEmail(email);
		if (u != null) {
			if(u.getAdmin() == 1) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
}
