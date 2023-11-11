package co.com.asset.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetTypeDTO;
import co.com.asset.model.dto.AssetTypeDetailDTO;
import co.com.asset.model.entity.AssetTypeDetailEntity;
import co.com.asset.model.entity.AssetTypeEntity;
import co.com.asset.repository.PropertyRepository;

@Component
public class AssetTypeMapper implements AbstractMapper<AssetTypeEntity, AssetTypeDTO> {
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private PropertyMapper propertyMapper;

	@Override
	public AssetTypeEntity mapperDtoToEntity(AssetTypeDTO assetTypeDTO) {
		AssetTypeEntity entity = new AssetTypeEntity();
		entity.setId(assetTypeDTO.getId());
		entity.setName(assetTypeDTO.getName());
		entity.setCategoryId(assetTypeDTO.getCategory().getId());
		entity.setDetails(getAssetDetails(assetTypeDTO.getDetails()));
		return entity;
	}
	
	@Override
	public AssetTypeDTO mapperEntityToDTO(AssetTypeEntity assetTypeEntity) {
		AssetTypeDTO dto = new AssetTypeDTO();
		dto.setId(assetTypeEntity.getId());
		dto.setName(assetTypeEntity.getName());
		dto.setCategory(categoryMapper.mapperEntityToDTO(assetTypeEntity.getCategory()));
		List<AssetTypeDetailDTO> detailsDto = assetTypeEntity.getDetails().stream().map(d -> new AssetTypeDetailDTO(d.getId(), d.getAssetTypeId(), d.getPropertyId(), propertyMapper.mapperEntityToDTO(d.getProperty()))).collect(Collectors.toList());
		dto.setDetails(detailsDto);
		
		return dto;
	}
	
	private List<AssetTypeDetailEntity> getAssetDetails(List<AssetTypeDetailDTO> listEntry){
		return listEntry.stream().map(e -> new AssetTypeDetailEntity(null, e.getAssetTypeId(), null, e.getPropertyId(), 
				propertyRepository.findById(e.getPropertyId()).get()))
				.collect(Collectors.toList());
	}
}
