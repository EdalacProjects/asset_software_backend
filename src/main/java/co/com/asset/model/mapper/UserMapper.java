package co.com.asset.model.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.UserDTO;
import co.com.asset.model.entity.PersonEntity;
import co.com.asset.model.entity.UserEntity;
import co.com.asset.repository.PersonRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class UserMapper implements AbstractMapper<UserEntity, UserDTO> {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonMapper personMapper;
	
	public UserEntity mapperDtoToEntity(UserDTO userDTO) throws AssetException {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDTO.getId());
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setInsertionDateTime(userDTO.getInsertionDateTime());
		userEntity.setUpdateDateTime(userDTO.getUpdateDateTime());
		userEntity.setStatus(userDTO.getStatus());
		userEntity.setPerson(this.findPersonById(userDTO.getPerson().getId()));
		
		return userEntity;
	}
	
	public UserDTO mapperEntityToDTO(UserEntity userEntity) throws AssetException {
		UserDTO userDto = new UserDTO();
		userDto.setId(userEntity.getId());
		userDto.setUserName(userEntity.getUserName());
		userDto.setPassword(userEntity.getPassword());
		userDto.setInsertionDateTime(userEntity.getInsertionDateTime());
		userDto.setUpdateDateTime(userEntity.getUpdateDateTime());
		userDto.setStatus(userEntity.getStatus());
		userDto.setPerson(personMapper.mapperEntityToDTO(this.findPersonById(userEntity.getPerson().getId())));
		
		return userDto;
	}
	
	private PersonEntity findPersonById(Long id) throws AssetException{
		Optional<PersonEntity> personEntity = personRepository.findById(id);
		if(personEntity.isPresent()) {
			return personEntity.get();
		}else {
			throw new AssetException("Person not Found");
		}		
	}
}
