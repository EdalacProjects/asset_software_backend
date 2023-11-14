package co.com.asset.model.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetPropertyDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.AssetPropertyEntity;
import co.com.asset.model.entity.PropertyEntity;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetPropertyMapper implements AbstractMapper<AssetPropertyEntity, AssetPropertyDTO> {

	private PropertyRepository propertyRepository;
	
	private AssetEntity assetEntity;
	
	public AssetPropertyMapper(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}

	@Override
	public AssetPropertyEntity mapperDtoToEntity(AssetPropertyDTO dto) {
		return AssetPropertyEntity.builder()
				.id(dto.getId())
				.asset(this.assetEntity)
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
	
	public List<AssetPropertyDTO> convertListEntityToListDTO(List<AssetPropertyEntity> listEntity){
		if(Objects.isNull(listEntity) || listEntity.isEmpty()) return new ArrayList<>();
		return listEntity.stream()
				.map(this::mapperEntityToDTO)
				.collect(Collectors.toList());
				
	}
	
	public List<AssetPropertyEntity> convertListDTOToListEntity(List<AssetPropertyDTO> listDTO, AssetEntity assetEntity){
		if(Objects.isNull(listDTO) || listDTO.isEmpty()) return new ArrayList<>();
		this.assetEntity = assetEntity;
		return listDTO.stream()
				.map(this::mapperDtoToEntity)
				.collect(Collectors.toList());
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
