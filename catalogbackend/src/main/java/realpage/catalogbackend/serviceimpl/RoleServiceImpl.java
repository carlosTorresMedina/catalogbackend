package realpage.catalogbackend.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import realpage.catalogbackend.dto.RoleDto;
import realpage.catalogbackend.entity.Role;
import realpage.catalogbackend.mapper.RoleMapper;
import realpage.catalogbackend.repository.IRoleRepository;
import realpage.catalogbackend.service.IRoleService;
import realpage.catalogbackend.util.EObjectResponseCode;
import realpage.catalogbackend.util.ObjectResponse;


/**
 * Service used to manage all the features related to 'Role'
 * @author Carlos Torres
 *
 */
@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements IRoleService {

	private final IRoleRepository roleRepository;
	private static final Logger logger = LogManager.getLogger(RoleServiceImpl.class);

	@Autowired
	public RoleServiceImpl(IRoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	@Transactional
	public ObjectResponse<RoleDto> addRole(RoleDto role) {
		try {
			Role newRole = RoleMapper.createEntityFromDto(role);
			RoleDto roleDto = RoleMapper.createDtoFromEntity(roleRepository.save(newRole)); 
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",roleDto);
		} catch (Exception e) {
			String message = RoleServiceImpl.class.getName()+"-addRole ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		}
	}

	@Override
	public ObjectResponse<List<RoleDto>> getAllRole() {
		try {
			List<RoleDto> roleList = RoleMapper.createListDtoFromEntity(roleRepository.findAll()); 
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",roleList);
		} catch (Exception e) {
			String message = RoleServiceImpl.class.getName()+"-addAllRole ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		}
	}

	@Override
	public ObjectResponse<RoleDto> getRoleById(long id)  {
		try {
			RoleDto roleDto = RoleMapper.createDtoFromEntity(roleRepository.findById(id).orElse(null)); 
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",roleDto);
		} catch (Exception e) {
			String message = RoleServiceImpl.class.getName()+"-getRoleById ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
			
		}
	}

	@Override
	@Transactional
	public ObjectResponse<Boolean> deleteRole(long id)  {
		try {
			RoleDto roleDto = RoleMapper.createDtoFromEntity(roleRepository.findById(id).orElse(null)); 
			roleRepository.delete(RoleMapper.createEntityFromDto(roleDto));
			return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",true);
		} catch (Exception e) {
			String message =RoleServiceImpl.class.getName()+"-deleteRole ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

	@Override
	@Transactional
	public ObjectResponse<RoleDto> updateRole(long id, RoleDto newRole)  {
		try {
			Role oldRole = roleRepository.findById(id).orElse(null);
			if (oldRole != null) {
				Role newEntity = RoleMapper.createEntityFromDto(newRole);
				newEntity.setId(oldRole.getId());
				RoleDto roleDto = RoleMapper.createDtoFromEntity(roleRepository.save(newEntity)); 
				return new ObjectResponse<>(EObjectResponseCode.CORRECT,"status ok",roleDto);
			}
			return new ObjectResponse<>(EObjectResponseCode.WARNING,"The role to update does not exist",null);
		} catch (Exception e) {
			String message = RoleServiceImpl.class.getName()+"-updateRole ";
			logger.error(message,e);
			return new ObjectResponse<>(EObjectResponseCode.ERROR,message+e.getMessage(), null);
		
		}
	}

}
