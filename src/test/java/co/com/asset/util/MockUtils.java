package co.com.asset.util;

import java.time.LocalDate;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.model.dto.CategoryDTO;
import co.com.asset.model.dto.PersonDTO;
import co.com.asset.model.dto.UserDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.CategoryEntity;
import co.com.asset.model.entity.CityEntity;
import co.com.asset.model.entity.IdentificationTypeEntity;
import co.com.asset.model.entity.PersonEntity;
import co.com.asset.model.entity.PropertyEntity;
import co.com.asset.model.entity.UserEntity;

public class MockUtils {

	public static PersonEntity getPersonEntity() {
    	return PersonEntity.builder()
    		.id(1L)
    		.firstName("Alam")
    		.lastName("Brito Delgado")
    		.birthday(LocalDate.parse("1980-06-01"))
    		.genre("M")
    		.identificationType(new IdentificationTypeEntity(1, "CEDULA", "CC"))
    		.identificationNumber("123456")
    		.city(CityEntity.builder().id(1).name("State Test").status(true).build())
    		.status(true)
    		.build();
    }
    
    public static PersonDTO getPersonDTO() {
    	return PersonDTO.builder()
			.id(1L)
			.firstName("Rosa")
			.lastName("Melano")
			.birthday(LocalDate.parse("1980-06-01"))
			.genre("F")
			.identificationType(new IdentificationTypeEntity(1, "CEDULA", "CC"))
			.identificationNumber("9876543")
			.city(CityEntity.builder().id(1).name("State Test").status(true).build())
			.status(true)
			.build();
    }
    
    public static UserDTO getUserDTO() {
    	return UserDTO.builder()
			.id(1L)
			.userName("user.test")
			.password("123456")
			.insertionDateTime(LocalDate.parse("2023-10-01"))
			.updateDateTime(LocalDate.parse("2023-10-01"))
			.person(getPersonDTO())
			.status(1)
			.build();
    }
    
    public static UserEntity getUserEntity() {
    	return UserEntity.builder()
			.id(1L)
			.userName("user.test")
			.password("123456")
			.insertionDateTime(LocalDate.parse("2023-10-01"))
			.updateDateTime(LocalDate.parse("2023-10-01"))
			.person(getPersonEntity())
			.status(1)
			.build();
    }
    
    public static CategoryEntity getCategoryEntity() {
    	return new CategoryEntity(1L, "CATEGORY TEST", "Categoria de Pruebas", true);
    }
    
    public static CategoryDTO getCategoryDTO() {
    	return new CategoryDTO(1L, "CATEGORY TEST", "Categoria de Pruebas", true);
    }
    
    public static PropertyEntity getPropertyEntity() {
    	return PropertyEntity.builder()
    		.id(1L)
    		.name("PROPERTY TEST")
    		.description("Propiedad de pruebas")
    		.build();
    }
    
    public static AssetEntity getAssetEntity() {
    	return AssetEntity.builder()
    		.id(1L)
    		.assetCode("ASSET-00-01")
    		.purchaseValue(Double.parseDouble("100000"))
    		.purchaseDate(LocalDate.parse("2022-10-01"))
    		.usefullLifetime("90")
    		.userResponsible(getUserEntity())
    		.location("EN CUALQUIER PARTE")
    		.status(true)
    		.category(getCategoryEntity())
    		.build();
    }
    
    public static AssetDTO getAssetDTO() {
    	return AssetDTO.builder()
    		.id(1L)
    		.assetCode("ASSET-00-01")
    		.purchaseValue(Double.parseDouble("100000"))
    		.purchaseDate(LocalDate.parse("2022-10-01"))
    		.usefullLifetime("90")
    		.userResponsible(getUserDTO())
    		.location("EN CUALQUIER PARTE")
    		.status(true)
    		.category(getCategoryDTO())
    		.build();
    }
}
