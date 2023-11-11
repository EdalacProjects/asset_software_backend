package co.com.asset.model.mapper;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.PersonDTO;
import co.com.asset.model.entity.PersonEntity;

@Component
public class PersonMapper implements AbstractMapper<PersonEntity, PersonDTO>{
	
	@Override
	public PersonEntity mapperDtoToEntity(PersonDTO personDto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setId(personDto.getId());
		personEntity.setLastName(personDto.getLastName());
		personEntity.setBirthday(personDto.getBirthday());
		personEntity.setGenre(personDto.getGenre());
		personEntity.setIdentificationType(personDto.getIdentificationType());
		personEntity.setIdentificationNumber(personDto.getIdentificationNumber());
		personEntity.setCity(personDto.getCity());
		personEntity.setStatus(personDto.getStatus());
		
		return personEntity;
	}

	@Override
	public PersonDTO mapperEntityToDTO(PersonEntity personEntity) {
		PersonDTO persondDTO = new PersonDTO();
		persondDTO.setId(personEntity.getId());
		persondDTO.setLastName(personEntity.getLastName());
		persondDTO.setBirthday(personEntity.getBirthday());
		persondDTO.setGenre(personEntity.getGenre());
		persondDTO.setIdentificationType(personEntity.getIdentificationType());
		persondDTO.setIdentificationNumber(personEntity.getIdentificationNumber());
		persondDTO.setCity(personEntity.getCity());
		persondDTO.setStatus(personEntity.getStatus());
		
		return persondDTO;
	}
}
