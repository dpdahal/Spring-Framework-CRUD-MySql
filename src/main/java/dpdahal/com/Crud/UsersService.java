package dpdahal.com.Crud;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	@Autowired
	private UserRepository repo;
	
	public List<Users> listAll(){
		return repo.findAll();
		
	}
	public void save(Users users) {
		repo.save(users);
	}
	public Users get(Long id) {
		return repo.findById(id).get();
		
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
