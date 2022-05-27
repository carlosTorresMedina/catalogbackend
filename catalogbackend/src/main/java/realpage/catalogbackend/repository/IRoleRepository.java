package realpage.catalogbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import realpage.catalogbackend.entity.Role;

/**
 * repository to manage Role's data
 * @author Carlos Torres
 *
 */
@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {

}
