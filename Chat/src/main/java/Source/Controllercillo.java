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

	@Autowired
	ChatDAO daoCh;

	@RequestMapping("/chat/allchats")
	public List<Chat> getAllChats() {
		return daoCh.findAll();
	}

	@RequestMapping("/chat/allchatsby/{user}")
	public List<Chat> findByUser(@PathVariable String user) {
		return daoCh.findByUser1OrUser2(user, user);
	}


	@RequestMapping("/chat/checkchat/{user1}/{user2}")
	public boolean checkChatByUser1AndUser2(@PathVariable String user1, @PathVariable String user2) {
		Chat c = daoCh.findByUser2AndUser1(user1, user2);
		Chat d = daoCh.findByUser1AndUser2(user1, user2);
		if(c == null) {
			if(d == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	@RequestMapping(method=RequestMethod.GET, value="/chat/getchat/{user1}/{user2}")
	public Chat getChat(@PathVariable String user1, @PathVariable String user2) {	
		Chat c = daoCh.findByUser2AndUser1(user1, user2);
		Chat d = daoCh.findByUser1AndUser2(user1, user2);
		if(c == null) {
			if(d == null) {
				return null;
			} else {
				return d;
			}
		} else {
			return c;
		}
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/chat/deletechat/{id}")
	public void deleteChat(@PathVariable String id){
		daoCh.delete(id);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/chat/deletealluserchats/{user}")
	public void deletealluserChats(@PathVariable String user) {
		List<Chat> c = daoCh.findByUser1OrUser2(user, user);
		for(int i = 0; i < c.size(); i++) {			
			daoCh.delete(c);
		}
	}

	@RequestMapping(method=RequestMethod.POST, value="/chat/newchat")
	public Chat saveChat(@RequestBody @Validated Chat chat){
		if(daoUs.findByEmail(chat.getUser1()) == null || daoUs.findByEmail(chat.getUser2()) == null) {
			return null;
		} else {
			Chat c = daoCh.findByUser2AndUser1(chat.getUser1(), chat.getUser2());
			Chat d = daoCh.findByUser1AndUser2(chat.getUser1(), chat.getUser2());
			if(c == null) {
				if(d == null) {
					return daoCh.save(chat);
				} else {
					return null;
				}
			} else {
				return null;
			}
			
		}	
	}

	@RequestMapping(method=RequestMethod.POST, value="/chat/updatechat/{id}")
	public Chat updateChat(@PathVariable String id, @RequestBody @Validated Chat update) {
		Chat updateCs = daoCh.findOne(id);
		updateCs.setMessages(update.getMessages());
		return daoCh.save(updateCs);
	}


}