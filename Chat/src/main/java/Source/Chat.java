package Source;

import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

public class Chat {

	@Id
	@GeneratedValue
	public String id;

	public String user1;
	public String user2;
	public List<String> messages;

	public Chat() {}

	public Chat(String user1, String user2, List<String> messages) {
		this.user1 = user1;
		this.user2 = user2;
		this.messages = messages;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUser1() {
		return user1;
	}


	public void setUser1(String user1) {
		this.user1 = user1;
	}


	public String getUser2() {
		return user2;
	}


	public void setUser2(String user2) {
		this.user2 = user2;
	}


	public List<String> getMessages() {
		return messages;
	}


	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public void appendMessage(String message) {
		this.messages.add(message);
	}
	
	
//	@Override
//	public String toString() {
//		return String.format(
//				"Customer[id=%s, firstName='%s', lastName='%s']",
//				id, firstName, lastName);
//	}

}
