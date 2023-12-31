package co.com.asset.service.assettype.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.asset.model.dto.AssetTypeDTO;
import co.com.asset.model.entity.AssetTypeEntity;
import co.com.asset.model.mapper.AssetTypeMapper;
import co.com.asset.repository.AssetTypeRepository;
import co.com.asset.service.assettype.AssetTypeService;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetTypeServiceImpl implements AssetTypeService {

	private AssetTypeRepository repository;
	
	private AssetTypeMapper assetTypeMapper;
	
	public AssetTypeServiceImpl(AssetTypeRepository repository, AssetTypeMapper assetTypeMapper) {
		this.repository = repository;
		this.assetTypeMapper = assetTypeMapper;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public AssetTypeDTO create(AssetTypeDTO assetTypeDTO) throws AssetException {
		repository.save(assetTypeMapper.mapperDtoToEntity(assetTypeDTO));
		return new AssetTypeDTO();
	}

	@Override
	public AssetTypeDTO getById(Long id) throws AssetException{
		AssetTypeEntity assetType = repository.findById(id).orElse(null);		
		if(Objects.isNull(assetType)) {
			throw new AssetException("Asset Type records not found");
		}
		
		return assetTypeMapper.mapperEntityToDTO(assetType);
	}

	@Override
	public List<AssetTypeDTO> findAll() throws AssetException {
		List<AssetTypeEntity> listAssetType = (List<AssetTypeEntity>) repository.findAll();
		if(!listAssetType.isEmpty()) {
			return listAssetType.stream().map(a -> assetTypeMapper.mapperEntityToDTO(a)).toList();
		}
		throw new AssetException("Asset Type records not found");		
	}
}
