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

import realpage.catalogbackend.dto.UserDto;
import realpage.catalogbackend.service.IUserService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;
import realpage.catalogbackend.util.FunctionUtils;

/**
 * Controller used to manage 'user' rest api
 * @author Carlos Torres
 *
 */
@RequestMapping("api/v1/user")
@RestController
public class UserController {

	private final IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * Adds an user in the system
	 * @param userDto to add
	 * @return response entity object
	 */
	@PostMapping
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto) {
		ObjectResponse<UserDto> objectResponse = userService.addUser(userDto);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);

	}
	
	/**
	 * Gets user list
	 * @return response entity object
	 */
	@GetMapping
	public ResponseEntity<?> getAllUser() {
		ObjectResponse<List<UserDto>> objectResponse = userService.getAllUser();
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

	/**
	 * Gets user list filter by id
	 * @param id to filter
	 * @return response entity object
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") long id) {
		ObjectResponse<UserDto> objectResponse =  userService.getUserById(id);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

	/**
	 * Deletes a specific user object
	 * @param id to delete
	 * @return response entity object
	 */
	@DeleteMapping(path = "{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") long id) {
		ObjectResponse<Boolean> objectResponse = userService.deleteUser(id);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

	/**
	 * Updates a specific user object
	 * @param id to update
	 * @param newUser data to update
	 * @return response entity object
	 */
	@PutMapping(path = "{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") long id,@Valid @RequestBody UserDto newUser) {
			ObjectResponse<UserDto> objectResponse = userService.updateUser(id, newUser);
			BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
					.generarFunctionResponseEntity();
			return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

}
