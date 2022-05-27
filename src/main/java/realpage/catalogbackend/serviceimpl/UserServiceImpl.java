package realpage.catalogbackend.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import realpage.catalogbackend.dto.UserDto;
import realpage.catalogbackend.entity.User;
import realpage.catalogbackend.mapper.UserMapper;
import realpage.catalogbackend.repository.IUserRepository;
import realpage.catalogbackend.service.IUserService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;

/**
 * Service used to manage all the features related to 'user'
 * 
 * @author Carlos Torres
 *
 */
@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements IUserService {

	private final IUserRepository userRepository;
	private static final Logger logger = LogManager.getLogger("USERLOGGER");
	
	

	@Autowired
	public UserServiceImpl(IUserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@Override
	@Transactional
	public ObjectResponse<UserDto> addUser(UserDto user) {
		try {
			logger.debug("registring user: "+user.getUsername());
			User newUser = UserMapper.createEntityFromDto(user);
			UserDto userDto = UserMapper.createDtoFromEntity(userRepository.save(newUser)); 
			logger.debug("registred user: "+user.getUsername());
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",userDto);
		} catch (Exception e) {
			String message = UserServiceImpl.class.getName()+"-addUser ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

	@Override
	public ObjectResponse<List<UserDto>> getAllUser()  {
		try {
			List<UserDto> userList = UserMapper.createListDtoFromEntity(userRepository.findAll());
			logger.debug("all user of the system consulted, total: "+userList.size());
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",userList);
		} catch (Exception e) {
			String message = UserServiceImpl.class.getName()+"-getAllUser ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

	@Override
	public ObjectResponse<UserDto> getUserById(long id) {
		try {
			UserDto userDto = UserMapper.createDtoFromEntity(userRepository.findById(id).orElse(null)); 
			logger.debug("consulted user with the id: "+id);
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",userDto);
		} catch (Exception e) {
			String message = UserServiceImpl.class.getName()+"-getUserById ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public ObjectResponse<Boolean> deleteUser(long id){
		try {
			logger.debug("deleting user with id: "+id);
			UserDto userDto = UserMapper.createDtoFromEntity(userRepository.findById(id).orElse(null)); 
			userRepository.delete(UserMapper.createEntityFromDto(userDto));
			logger.debug("deleted user with id: "+id);
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",true);
		} catch (Exception e) {
			String message = UserServiceImpl.class.getName()+"-deleteUser ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public ObjectResponse<UserDto> updateUser(long id, UserDto newUser){
		try {
			logger.debug("updating user with id: "+id);
			User oldUser = userRepository.findById(id).orElse(null);
			if (oldUser != null) {
				User newEntity = UserMapper.createEntityFromDto(newUser);
				newEntity.setId(oldUser.getId());
				UserDto userDto = UserMapper.createDtoFromEntity(userRepository.save(newEntity)); 
				logger.debug("updated user with id: "+id);
				return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",userDto);
			}
			return new ObjectResponse<>(EObjectResponseCode.WARNING,"The user to update does not exist",null);
		} catch (Exception e) {
			String message = UserServiceImpl.class.getName()+"-updateUser";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

}
