package co.com.asset.service.assettype.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetTypeDTO;
import co.com.asset.model.dto.AssetTypeDetailDTO;
import co.com.asset.model.entity.AssetTypeDetailEntity;
import co.com.asset.model.entity.AssetTypeEntity;
import co.com.asset.model.request.AssetTypeRequest;
import co.com.asset.repository.AssetTypeRepository;
import co.com.asset.service.assettype.AssetTypeService;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetTypeServiceImpl implements AssetTypeService {

	@Autowired
	private AssetTypeRepository repository;
	
	@Override
	public AssetTypeDTO create(AssetTypeRequest request) throws AssetException {
		AssetTypeEntity entity = new AssetTypeEntity();
		entity.setName(request.getName());
		entity.setCategoryId(request.getCategory().getId());
		entity.setDetails(getAssetDetails(request.getDetails()));
		return repository.save(entity).getDTO();
	}

	@Override
	public AssetTypeDTO getById(Long id) throws AssetException{
		AssetTypeEntity assetType = repository.findById(id).orElse(null);		
		if(Objects.isNull(assetType)) {
			throw new AssetException("Asset Type records not found");
		}
		
		AssetTypeDTO assetTypeDto = assetType.getDTO();
//		List<AssetTypeDetailEntity> listAssetTypeDetail = assetTypeDetailRepository.findByAssetTypeId(assetType.getId());
//		assetTypeDto.setDetails(listAssetTypeDetail.stream().map(a -> a.getDto()).collect(Collectors.toList()));
		return assetTypeDto;
	}

	@Override
	public List<AssetTypeDTO> findAll() throws AssetException {
		List<AssetTypeEntity> listAssetType = (List<AssetTypeEntity>) repository.findAll();
		if(!listAssetType.isEmpty()) {
			return listAssetType.stream().map(a -> a.getDTO()).collect(Collectors.toList());
		}
		throw new AssetException("Asset Type records not found");		
	}

	private List<AssetTypeDetailEntity> getAssetDetails(List<AssetTypeDetailDTO> listEntry){
		return listEntry.stream().map(e -> e.getEntity()).collect(Collectors.toList());
	}
}
