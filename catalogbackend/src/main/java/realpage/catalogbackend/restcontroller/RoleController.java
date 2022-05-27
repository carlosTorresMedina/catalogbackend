package realpage.catalogbackend.restcontroller;

import java.util.List;
import java.util.function.BiFunction;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import realpage.catalogbackend.dto.RoleDto;
import realpage.catalogbackend.service.IRoleService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;
import realpage.catalogbackend.util.FunctionUtils;

/**
 * Controller used to manage 'role' rest api
 * @author Carlos Torres
 *
 */
@RequestMapping("api/v1/role")
@RestController
public class RoleController {

	private final IRoleService roleService;

	@Autowired
	public RoleController(IRoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * Adds roles to the system
	 * @param roleDto to add
	 * @return response entity object
	 */
	@PostMapping
	public ResponseEntity<?> addRole(@Valid @RequestBody RoleDto roleDto) {
		ObjectResponse<RoleDto> objectResponse = roleService.addRole(roleDto);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);

	}

	/**
	 * Gets all roles in the system
	 * @return response entity object
	 */
	@GetMapping
	public ResponseEntity<?> getAllRole() {
		ObjectResponse<List<RoleDto>> objectResponse = roleService.getAllRole();
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

	/**
	 * Gets role filter by id
	 * @param id to filter
	 * @return response entity object
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<?> getRoleById(@PathVariable("id") long id) {
		ObjectResponse<RoleDto> objectResponse = roleService.getRoleById(id);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

	/**
	 * Deletes role in the system
	 * @param id to delete
	 * @return response entity object
	 */
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> deleteRoleById(@PathVariable("id") long id) {
		ObjectResponse<Boolean> objectResponse = roleService.deleteRole(id);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

	/**
	 * Updates role in the system
	 * @param id to update
	 * @param newRole data to update
	 * @return response entity object
	 */
	@PutMapping(path = "{id}")
	public ResponseEntity<?> updateRole(@PathVariable("id") long id, @Valid @RequestBody RoleDto newRole) {
		ObjectResponse<RoleDto> objectResponse = roleService.updateRole(id, newRole);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);

	}

}
