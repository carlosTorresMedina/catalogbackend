package realpage.catalogbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import realpage.catalogbackend.entity.User;

/**
 * repository to manage User's data
 * @author Carlos Torres
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
	
	public User findByUsername(String username);

}
