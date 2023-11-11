package co.com.asset.model.mapper;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.PropertyDTO;
import co.com.asset.model.entity.PropertyEntity;

@Component
public class PropertyMapper implements AbstractMapper<PropertyEntity, PropertyDTO> {

	@Override
	public PropertyEntity mapperDtoToEntity(PropertyDTO dto) {
		return PropertyEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.description(dto.getDescription())
				.build();
	}

	@Override
	public PropertyDTO mapperEntityToDTO(PropertyEntity entity) {
		return PropertyDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.description(entity.getDescription())
				.build();
	}
}
