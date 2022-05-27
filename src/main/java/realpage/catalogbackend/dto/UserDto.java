package realpage.catalogbackend.dto;


/**
 * 
 * @author Carlos Torres
 *
 */
public class UserDto {

	private long id;

	private String username;
	
	private String password;
	
	private RoleDto role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	
}
