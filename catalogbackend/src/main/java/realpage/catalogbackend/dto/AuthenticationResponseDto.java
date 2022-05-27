package realpage.catalogbackend.dto;

public class AuthenticationResponseDto {
	
	private String username;
	private String token;
	private long roleid;
	
	public AuthenticationResponseDto(String username, String token,long roleid) {
		super();
		this.username = username;
		this.token = token;
		this.roleid = roleid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getRoleid() {
		return roleid;
	}
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}


}
