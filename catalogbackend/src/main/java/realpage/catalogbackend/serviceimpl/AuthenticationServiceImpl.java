package realpage.catalogbackend.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import realpage.catalogbackend.dto.AuthenticationDto;
import realpage.catalogbackend.dto.AuthenticationResponseDto;
import realpage.catalogbackend.dto.UserDto;
import realpage.catalogbackend.entity.User;
import realpage.catalogbackend.mapper.UserMapper;
import realpage.catalogbackend.repository.IUserRepository;
import realpage.catalogbackend.service.IAuthenticationService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;
import realpage.catalogbackend.util.FunctionUtils;
import realpage.catalogbackend.util.TokenUtils;

/**
 * Class used to manage the authentication feature.
 * @author Carlos Torres
 *
 */
@Service
@Transactional(readOnly=true)
public class AuthenticationServiceImpl implements IAuthenticationService {

	private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);
	
	private final IUserRepository userRepository;
	private final TokenUtils tokenUtils;
	
	@Autowired
	public AuthenticationServiceImpl(IUserRepository userRepository,TokenUtils tokenUtils) {
		this.userRepository = userRepository;
		this.tokenUtils = tokenUtils;
	}
	
	@Override
	public ObjectResponse<AuthenticationResponseDto> validateAuthorization(AuthenticationDto auth) {

		try {
			User user = userRepository.findByUsername(auth.getUsername());
		if(user==null) {
			return new ObjectResponse<>(EObjectResponseCode.WARNING,"The user does not exist", null);
		}
		final String password = FunctionUtils.generateHashWithApacheCommons().apply(auth.getPassword());
		
		if(!user.getPassword().equals(password)) {
			return new ObjectResponse<>(EObjectResponseCode.WARNING,"Password incorrect", null);
		}
		AuthenticationResponseDto response = new AuthenticationResponseDto(user.getUsername(),  tokenUtils.generateToken(user.getUsername()),user.getRole().getId());
		
		return new ObjectResponse<>(EObjectResponseCode.CORRECT, "status ok",response);
		} catch (Exception e) {
			String message =AuthenticationServiceImpl.class.getName()+"-validateAuthorization "; 
			logger.error(message, e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		}
	}

}
