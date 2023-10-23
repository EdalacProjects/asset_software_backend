package co.com.asset.service.assettype.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetTypeDTO;
import co.com.asset.model.entity.AssetTypeDetailEntity;
import co.com.asset.model.entity.AssetTypeEntity;
import co.com.asset.repository.AssetTypeDetailRepository;
import co.com.asset.repository.AssetTypeRepository;
import co.com.asset.service.assettype.AssetTypeService;

@Component
public class AssetTypeServiceImpl implements AssetTypeService {

	@Autowired
	private AssetTypeRepository repository;
	
	@Autowired
	private AssetTypeDetailRepository assetTypeDetailRepository;
	
	@Override
	public AssetTypeDTO getById(Long id) {
		AssetTypeEntity assetType = repository.findById(id).orElse(null);		
		if(Objects.nonNull(assetType)) {
			AssetTypeDTO assetTypeDto = assetType.getDTO();
			List<AssetTypeDetailEntity> listAssetTypeDetail = assetTypeDetailRepository.findByAssetTypeId(assetType.getId());
			assetTypeDto.setDetails(listAssetTypeDetail.stream().map(a -> a.getDto()).collect(Collectors.toList()));
			return assetTypeDto;
		}
		return null;
	}

}
