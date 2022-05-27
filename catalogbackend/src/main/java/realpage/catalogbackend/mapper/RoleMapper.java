package realpage.catalogbackend.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import realpage.catalogbackend.dto.RoleDto;
import realpage.catalogbackend.entity.Role;

/**
 * Class used to map 'Role' object
 * @author CARLOS TORRES
 *
 */
public class RoleMapper {

	private RoleMapper() {}
	
	/**
	 * Creates role list from role entity list
	 * @param roles {@link List<Role>} used to extract data and create the role list
	 * @return role list
	 */
	public static List<RoleDto> createListDtoFromEntity(List<Role> roles) {
		List<RoleDto> rolesDto = new ArrayList<RoleDto>();
		if (roles != null && !roles.isEmpty()) {
			rolesDto = roles.stream().map(roleEntity->createDtoFromEntity(roleEntity)).collect(Collectors.toList());
		}
		return rolesDto;
	}
	
	/**
	 * Creates role object from role entity object
	 * @param role {@link Role} used to extract data and create the role object
	 * @return role object
	 */
	public static RoleDto createDtoFromEntity(Role role) {
		RoleDto roleDto = new RoleDto();
		if (role != null) {
			roleDto.setId(role.getId());
		    roleDto.setRoleName(role.getRoleName());
		    roleDto.setRoleDescription(role.getRoleDescription());
		}
	    return roleDto;
	}
	
	/**
	 * Creates role entity object from role object
	 * @param roleDto {@link RoleDto} used to extract data and create the role entity object
	 * @return role entity object
	 */
	public static Role createEntityFromDto(RoleDto roleDto) {
		Role role = new Role();
		if (roleDto != null) {
			role.setId(roleDto.getId());
		    role.setRoleName(roleDto.getRoleName());
		    role.setRoleDescription(roleDto.getRoleDescription());
		}
	    return role;
	}
	
}
