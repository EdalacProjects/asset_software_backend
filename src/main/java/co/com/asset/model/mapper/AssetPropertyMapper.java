package co.com.asset.model.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetPropertyDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.AssetPropertyEntity;
import co.com.asset.model.entity.PropertyEntity;
import co.com.asset.repository.AssetRepository;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetPropertyMapper implements AbstractMapper<AssetPropertyEntity, AssetPropertyDTO> {

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public AssetPropertyEntity mapperDtoToEntity(AssetPropertyDTO dto) {
		return AssetPropertyEntity.builder()
				.id(dto.getId())
				.asset(this.findAssetById(dto.getAssetId()))
				.property(this.findPropertyById(dto.getProperty().getId()))
				.value(dto.getValue())
				.build();
	}

	@Override
	public AssetPropertyDTO mapperEntityToDTO(AssetPropertyEntity entity) {
		return AssetPropertyDTO.builder()
				.id(entity.getId())
				.assetId(entity.getAssetId())
				.property(entity.getProperty())
				.value(entity.getValue())
				.build();
	}
	
	private AssetEntity findAssetById(Long id) {
		Optional<AssetEntity> assetEntity = assetRepository.findById(id);
		if(assetEntity.isPresent()) {
			return assetEntity.get();
		}else {
			throw new AssetException("asset not found");
		}
	}
	
	private PropertyEntity findPropertyById(Long id) {
		Optional<PropertyEntity> optional = propertyRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new AssetException("Property not found");
		}
	}
}
