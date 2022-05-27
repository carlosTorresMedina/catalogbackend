package realpage.catalogbackend.restcontroller;

import java.util.function.BiFunction;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import realpage.catalogbackend.dto.AuthenticationDto;
import realpage.catalogbackend.dto.AuthenticationResponseDto;
import realpage.catalogbackend.service.IAuthenticationService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;
import realpage.catalogbackend.util.FunctionUtils;

/**
 * Controller used to manage 'cast' rest api
 * 
 * @author Carlos Torres
 *
 */
@RequestMapping("auth")
@RestController
public class AuthenticationController {

	private final IAuthenticationService authenticationService;

	@Autowired
	public AuthenticationController(IAuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping
	public ResponseEntity<?> validateUser(@Valid @RequestBody AuthenticationDto auth) {
		ObjectResponse<AuthenticationResponseDto> objectResponse = authenticationService.validateAuthorization(auth);
		BiFunction<EObjectResponseCode, ObjectResponse<?>, ResponseEntity<?>> function = FunctionUtils
				.generarFunctionResponseEntity();
		return function.apply(objectResponse.getResponseCode(), objectResponse);
	}

}
