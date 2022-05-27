package realpage.catalogbackend.service;

import java.util.List;

import realpage.catalogbackend.dto.UserDto;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Interface to abstract 'user' features
 * @author Carlos Torres
 *
 */
public interface IUserService {

	/**
	 * Adds an user in the system
	 * @param user {@link} to add in the system
	 * @return object response with user object added
	 */
	public ObjectResponse<UserDto> addUser(UserDto user);
	
	/**
	 * Gets user list
	 * @return object response with user list data
	 */
	public ObjectResponse<List<UserDto>> getAllUser();
	
	/**
	 * Gets user list filter by id
	 * @param id used to filter
	 * @return object response with user object data
	 */
	public ObjectResponse<UserDto> getUserById(long id);
	
	/**
	 * Deletes a specific user object
	 * @param id used to search the user object to delete
	 * @return object response with Boolean value to indicate if the action was successful
	 */
	public ObjectResponse<Boolean> deleteUser(long id);
	
	/**
	 * Updates a specific user object
	 * @param id used to search the user object to update
	 * @param newUser data to update
	 * @return object response with user object updated
	 */
	public ObjectResponse<UserDto> updateUser(long id, UserDto newUser);
}
