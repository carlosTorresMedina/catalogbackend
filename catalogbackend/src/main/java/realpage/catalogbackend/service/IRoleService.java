package realpage.catalogbackend.service;

import java.util.List;

import realpage.catalogbackend.dto.RoleDto;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Interface to abstract 'role' features
 * @author Carlos Torres
 *
 */
public interface IRoleService {

	/**
	 * Adds roles to the system
	 * 
	 * @param role {@link RoleDto} to save in the system
	 * @return object response with the role object added
	 */
	public ObjectResponse<RoleDto> addRole(RoleDto role);

	/**
	 * Gets all roles in the system
	 * @return object response with role list data
	 */
	public ObjectResponse<List<RoleDto>> getAllRole();

	/**
	 * Gets role filter by id
	 * @param id used to filter
	 * @return object response with role object data
	 */
	public ObjectResponse<RoleDto> getRoleById(long id);

	/**
	 * Deletes role in the system
	 * 
	 * @param id used to search and delete specific role
	 * @return object response with boolean value to indicate if the action was successful.
	 */
	public ObjectResponse<Boolean> deleteRole(long id);

	/**
	 * Updates role in the system
	 * @param id of the role to update
	 * @param newRole {@link RoleDto} data to update
	 * @return object response with role updated
	 */
	public ObjectResponse<RoleDto> updateRole(long id, RoleDto newRole);

}
