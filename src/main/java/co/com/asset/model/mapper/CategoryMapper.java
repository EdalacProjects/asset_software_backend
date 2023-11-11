package co.com.asset.model.mapper;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.CategoryDTO;
import co.com.asset.model.entity.CategoryEntity;

@Component
public class CategoryMapper implements AbstractMapper<CategoryEntity, CategoryDTO>{

	@Override
	public CategoryEntity mapperDtoToEntity(CategoryDTO categoryDto) {
		return new CategoryEntity(categoryDto.getId(), categoryDto.getName(), categoryDto.getDescription(), categoryDto.getStatus());
	}

	@Override
	public CategoryDTO mapperEntityToDTO(CategoryEntity categoryEntity) {
		return new CategoryDTO(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription(), categoryEntity.getStatus());
	}
}
