package co.com.asset.model.mapper;


import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import co.com.asset.model.dto.PropertyDTO;
import co.com.asset.model.entity.PropertyEntity;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = { PropertyMapper.class })
 class PropertyMapperTest{

	@Mock
    private PropertyEntity mockedEntity;

    @Mock
    private PropertyDTO mockedDTO;

    @InjectMocks
    private PropertyMapper propertyMapper;

    @Test
    public void testMapperDtoToEntity() {
        // Mockear un objeto PropertyDTO para la prueba
        when(mockedDTO.getId()).thenReturn(1L);
        when(mockedDTO.getName()).thenReturn("Propiedad1");
        when(mockedDTO.getDescription()).thenReturn("Descripción de la propiedad");

        // Ejecutar el método a probar
        PropertyEntity entity = propertyMapper.mapperDtoToEntity(mockedDTO);

        // Verificar que los campos se han mapeado correctamente
        Assertions.assertEquals(mockedDTO.getId(), entity.getId());
        Assertions.assertEquals(mockedDTO.getName(), entity.getName());
        Assertions.assertEquals(mockedDTO.getDescription(), entity.getDescription());
    }

    @Test
    public void testMapperEntityToDTO() {
        // Mockear un objeto PropertyEntity para la prueba
        when(mockedEntity.getId()).thenReturn(1L);
        when(mockedEntity.getName()).thenReturn("Propiedad1");
        when(mockedEntity.getDescription()).thenReturn("Descripción de la propiedad");

        // Ejecutar el método a probar
        PropertyDTO dto = propertyMapper.mapperEntityToDTO(mockedEntity);

        // Verificar que los campos se han mapeado correctamente
        Assertions.assertEquals(mockedEntity.getId(), dto.getId());
        Assertions.assertEquals(mockedEntity.getName(), dto.getName());
        Assertions.assertEquals(mockedEntity.getDescription(), dto.getDescription());
    }
}