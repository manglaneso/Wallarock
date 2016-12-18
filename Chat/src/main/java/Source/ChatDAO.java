package Source;

import java.util.List;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatDAO extends MongoRepository<Chat, String> {

	public Chat findByUser2AndUser1(String user2, String user1);
    public Chat findByUser1AndUser2(String user1, String user2);
    public List<Chat> findByUser1OrUser2(String user1, String User2);
	public List<Chat> findAll();
    

}
