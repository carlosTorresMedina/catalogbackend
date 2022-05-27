package realpage.catalogbackend.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import realpage.catalogbackend.dto.UserDto;
import realpage.catalogbackend.entity.User;
import realpage.catalogbackend.util.FunctionUtils;

/**
 * Class used to map 'User' object
 * @author Carlos Torres
 *
 */
public class UserMapper {
	
	private UserMapper() {}
	
	/**
	 * Creates user list from user entity list
	 * @param users {@link List<User>} used to extract data and create user list
	 * @return user list
	 */
	public static List<UserDto> createListDtoFromEntity(List<User> users) {
		List<UserDto> usersDto = new ArrayList<UserDto>();
		if (users != null && !users.isEmpty()) {
			usersDto = users.stream().map(userEntity->createDtoFromEntity(userEntity)).collect(Collectors.toList());
		}
		return usersDto;
	}
	
	/**
	 * Creates user object from user entity object
	 * @param user {@link User} used to extract data and create user object
	 * @return user object
	 */
	public static UserDto createDtoFromEntity(User user) {
	    UserDto userDto = new UserDto();
	    if (user != null) {
	    	userDto.setId(user.getId());
	 	    userDto.setUsername(user.getUsername());
	 	    userDto.setPassword(user.getPassword());
	 	    userDto.setRole(RoleMapper.createDtoFromEntity(user.getRole()));
	    }
	    return userDto;
	}
	
	/**
	 * Creates user object from user entity object
	 * @param userDto {@link UserDto} used to extract data and create the user entity object
	 * @return user entity object
	 */
	public static User createEntityFromDto(UserDto userDto) {
	    User user = new User();
	    if (userDto != null) {
	    	user.setId(userDto.getId());
	 	    user.setUsername(userDto.getUsername());
	 	    user.setPassword(FunctionUtils.generateHashWithApacheCommons().apply(userDto.getPassword()));
	 	    user.setRole(RoleMapper.createEntityFromDto(userDto.getRole()));
	    }
	    return user;
	}
}
