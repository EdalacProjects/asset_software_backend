package co.com.asset.model.mapper;


import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.asset.model.dto.CategoryDTO;
import co.com.asset.model.entity.CategoryEntity;

@ExtendWith(MockitoExtension.class)
 class CategoryMapperTest{

	@Mock
    private CategoryEntity mockedEntity;

    @Mock
    private CategoryDTO mockedDTO;

    @InjectMocks
    private CategoryMapper categoryMapper;

    @Test
    public void testMapperDtoToEntity() {
        // Mockear un objeto CategoryDTO para la prueba
        when(mockedDTO.getId()).thenReturn(1L);
        when(mockedDTO.getName()).thenReturn("Category1");
        when(mockedDTO.getDescription()).thenReturn("Description of category");
        when(mockedDTO.getStatus()).thenReturn(true);

        // Ejecutar el método a probar
        CategoryEntity entity = categoryMapper.mapperDtoToEntity(mockedDTO);

        // Verificar que los campos se han mapeado correctamente
        Assertions.assertEquals(mockedDTO.getId(), entity.getId());
        Assertions.assertEquals(mockedDTO.getName(), entity.getName());
        Assertions.assertEquals(mockedDTO.getDescription(), entity.getDescription());
        Assertions.assertEquals(mockedDTO.getStatus(), entity.getStatus());
    }

    @Test
    public void testMapperEntityToDTO() {
        // Mockear un objeto CategoryEntity para la prueba
        when(mockedEntity.getId()).thenReturn(1L);
        when(mockedEntity.getName()).thenReturn("Category1");
        when(mockedEntity.getDescription()).thenReturn("Description of category");
        when(mockedEntity.getStatus()).thenReturn(true);

        // Ejecutar el método a probar
        CategoryDTO dto = categoryMapper.mapperEntityToDTO(mockedEntity);

        // Verificar que los campos se han mapeado correctamente
        Assertions.assertEquals(mockedEntity.getId(), dto.getId());
        Assertions.assertEquals(mockedEntity.getName(), dto.getName());
        Assertions.assertEquals(mockedEntity.getDescription(), dto.getDescription());
        Assertions.assertEquals(mockedEntity.getStatus(), dto.getStatus());
    }
}