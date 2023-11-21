package co.com.asset.model.mapper;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.PersonDTO;
import co.com.asset.model.dto.UserDTO;
import co.com.asset.model.entity.PersonEntity;
import co.com.asset.model.entity.UserEntity;
import co.com.asset.repository.PersonRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class UserMapper implements AbstractMapper<UserEntity, UserDTO> {

	private PersonRepository personRepository;
	
	private PersonMapper personMapper;
	
	public UserMapper(PersonRepository personRepository, PersonMapper personMapper) {
		super();
		this.personRepository = personRepository;
		this.personMapper = personMapper;
	}

	public UserEntity mapperDtoToEntity(UserDTO userDTO) throws AssetException {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDTO.getId());
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setInsertionDateTime(userDTO.getInsertionDateTime());
		userEntity.setUpdateDateTime(userDTO.getUpdateDateTime());
		userEntity.setStatus(userDTO.getStatus());
		if(Objects.isNull(userDTO.getPerson())) {
			userDTO.setPerson(PersonDTO.builder().id(0L).build());
		}
		userEntity.setPerson(this.findPersonById(userDTO.getPerson().getId()));
		userEntity.setPersonId(userDTO.getPerson().getId());
		
		return userEntity;
	}
	
	public UserDTO mapperEntityToDTO(UserEntity userEntity) throws AssetException {
		UserDTO userDto = null;
		if(Objects.nonNull(userEntity)) {
			userDto = new UserDTO();
			userDto.setId(userEntity.getId());
			userDto.setUserName(userEntity.getUserName());
			userDto.setPassword(userEntity.getPassword());
			userDto.setInsertionDateTime(userEntity.getInsertionDateTime());
			userDto.setUpdateDateTime(userEntity.getUpdateDateTime());
			userDto.setStatus(userEntity.getStatus());
			userDto.setPerson(personMapper.mapperEntityToDTO(this.findPersonById(userEntity.getPerson().getId())));
			
			return userDto;
		}
		return null;
//		throw new AssetException("UserEntity in null");
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
