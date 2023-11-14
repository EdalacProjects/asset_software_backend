package co.com.asset.model.mapper;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.asset.model.dto.UserDTO;
import co.com.asset.model.entity.PersonEntity;
import co.com.asset.model.entity.UserEntity;
import co.com.asset.repository.PersonRepository;
import co.com.asset.util.MockUtils;
import co.com.asset.util.exception.AssetException;

@ExtendWith(MockitoExtension.class)
 class UserMapperTest{

	@InjectMocks
	private UserMapper userMapper;
	
	@InjectMocks
	private PersonMapper personMapper;
	
	@Mock
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        personRepository = mock(PersonRepository.class);
        personMapper = new PersonMapper();
//        userMapper = mock(UserMapper.class);
        userMapper = new UserMapper(personRepository, personMapper);
    }

    @Test
    void testMapperDtoToEntity() throws AssetException {
        // Mock para findPersonById
        when(personRepository.findById(1L)).thenReturn(Optional.of(MockUtils.getPersonEntity()));

        // Act
        UserEntity userEntity = userMapper.mapperDtoToEntity(MockUtils.getUserDTO());

        // Assert
        Assertions.assertNotNull(userEntity);
        Assertions.assertNotNull(userEntity.getPerson());
        Assertions.assertNotNull(userEntity.getPerson().getIdentificationType());
        Assertions.assertNotNull(userEntity.getPerson().getIdentificationNumber());
        Assertions.assertNotNull(userEntity.getPerson().getFirstName());
        Assertions.assertNotNull(userEntity.getPerson().getCity());        
        Assertions.assertNotNull(userEntity.getUserName());
        Assertions.assertNotNull(userEntity.getPassword());
    }

    @Test
    void testMapperEntityToDTO() throws AssetException {
        // Mock para findPersonById
        when(personRepository.findById(1L)).thenReturn(Optional.of(MockUtils.getPersonEntity()));

        // Act
        UserDTO userDTO = userMapper.mapperEntityToDTO(MockUtils.getUserEntity());

        // Assert
        Assertions.assertNotNull(userDTO);
        Assertions.assertNotNull(userDTO.getPerson());
        Assertions.assertNotNull(userDTO.getPerson().getIdentificationType());
        Assertions.assertNotNull(userDTO.getPerson().getIdentificationNumber());
        Assertions.assertNotNull(userDTO.getPerson().getFirstName());
        Assertions.assertNotNull(userDTO.getPerson().getCity());        
        Assertions.assertNotNull(userDTO.getUserName());
        Assertions.assertNotNull(userDTO.getPassword());
    }

    @Test
    void testFindPersonById() throws AssetException {
        // Arrange
        Long personId = 1L;

        // Mock para findById
        when(personRepository.findById(personId)).thenReturn(Optional.of(MockUtils.getPersonEntity()));

        // Act
        PersonEntity personEntity = personRepository.findById(personId).get();

        // Assert
        Assertions.assertNotNull(personEntity);
        Assertions.assertNotNull(personEntity.getIdentificationType());
        Assertions.assertNotNull(personEntity.getIdentificationNumber());
        Assertions.assertNotNull(personEntity.getFirstName());
        Assertions.assertNotNull(personEntity.getCity());
    }
    
    
}