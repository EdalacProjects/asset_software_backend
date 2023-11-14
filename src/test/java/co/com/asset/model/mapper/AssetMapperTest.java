package co.com.asset.model.mapper;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.CategoryEntity;
import co.com.asset.repository.CategoryRepository;
import co.com.asset.repository.PersonRepository;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.repository.UserRepository;
import co.com.asset.util.MockUtils;

@ExtendWith(MockitoExtension.class)
 class AssetMapperTest{

	@InjectMocks
	AssetMapper underTest;
	@Mock
	AssetPropertyMapper assetPropertyMapper;
	@Mock
	CategoryMapper categoryMapper;
	@Mock
	CategoryRepository categoryRepository;
	@Mock
	UserMapper userMapper;
	@Mock
	UserRepository userRepository;
	@Mock
	PropertyRepository propertyRepository;
	@Mock
	PersonRepository personRepository;
	
	private AssetMapper assetMapper;
	private PersonMapper personMapper;

    @BeforeEach
    public void setUp() {
        categoryRepository = mock(CategoryRepository.class);
//        propertyRepository = mock(PropertyRepository.class);
        personRepository = mock(PersonRepository.class);
        userRepository = mock(UserRepository.class);
        
        categoryMapper = new CategoryMapper();      
        personMapper = new PersonMapper();
        assetPropertyMapper = new AssetPropertyMapper(propertyRepository);
        userMapper = new UserMapper(personRepository, personMapper);
        assetMapper = new AssetMapper(categoryMapper, categoryRepository, userRepository, assetPropertyMapper, userMapper);
    }

    @Test
    void testMapperDtoToEntity() {
        // Mock para categoryRepository.findById y userRepository.findById
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(new CategoryEntity()));
        when(userRepository.findById(1L)).thenReturn(Optional.of(MockUtils.getUserEntity()));
        
        // Act
        AssetEntity assetEntity = assetMapper.mapperDtoToEntity(MockUtils.getAssetDTO());

        verify(categoryRepository).findById(1l);
        verify(userRepository).findById(1l);
        
        // Assert
        Assertions.assertNotNull(assetEntity);
        Assertions.assertNotNull(assetEntity.getCategory());
        Assertions.assertNotNull(assetEntity.getAssetCode());
        Assertions.assertNotNull(assetEntity.getUserResponsible());
        Assertions.assertNotNull(assetEntity);
    }

    @Test
    void testMapperEntityToDTO() {
    	when(personRepository.findById(1L)).thenReturn(Optional.of(MockUtils.getPersonEntity()));
        // Act
        AssetDTO assetDTO = assetMapper.mapperEntityToDTO(MockUtils.getAssetEntity());

        verify(personRepository).findById(1l);
        
        // Assert
        Assertions.assertNotNull(assetDTO);
        Assertions.assertNotNull(assetDTO.getCategory());
        Assertions.assertNotNull(assetDTO.getAssetCode());
        Assertions.assertNotNull(assetDTO.getUserResponsible());
        Assertions.assertNotNull(assetDTO);
    }
}