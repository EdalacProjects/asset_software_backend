package co.com.asset.model.mapper;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.PersonDTO;
import co.com.asset.model.entity.PersonEntity;

@Component
public class PersonMapper implements AbstractMapper<PersonEntity, PersonDTO>{
	
	@Override
	public PersonEntity mapperDtoToEntity(PersonDTO personDto) {
		return PersonEntity.builder()
			.id(personDto.getId())
			.lastName(personDto.getLastName())
			.birthday(personDto.getBirthday())
			.genre(personDto.getGenre())
			.identificationType(personDto.getIdentificationType())
			.identificationNumber(personDto.getIdentificationNumber())
			.city(personDto.getCity())
			.status(personDto.getStatus())
			.build();
	}

	@Override
	public PersonDTO mapperEntityToDTO(PersonEntity personEntity) {
		return PersonDTO.builder()
			.id(personEntity.getId())
			.firstName(personEntity.getFirstName())
			.lastName(personEntity.getLastName())
			.birthday(personEntity.getBirthday())
			.genre(personEntity.getGenre())
			.identificationType(personEntity.getIdentificationType())
			.identificationNumber(personEntity.getIdentificationNumber())
			.city(personEntity.getCity())
			.status(personEntity.getStatus())
			.build();
	}
}
