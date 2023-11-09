package co.com.asset.service.asset.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.AssetPropertyEntity;
import co.com.asset.model.entity.CategoryEntity;
import co.com.asset.repository.AssetRepository;
import co.com.asset.repository.CategoryRepository;
import co.com.asset.service.asset.AssetService;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void create(AssetDTO assetDto) throws AssetException {
		CategoryEntity categoryEntity = null;
		List<AssetPropertyEntity> listProperties = null;
		if(Objects.nonNull(assetDto)) {
			if(Objects.nonNull(assetDto.getCategory())) {
				categoryEntity = categoryRepository.findById(assetDto.getCategory().getId()).get();	
			}else {
				throw new AssetException("Category not Found");
			}
			if(Objects.nonNull(assetDto.getProperties()) && assetDto.getProperties().isEmpty()) {
				listProperties = assetDto.getProperties().stream().map(p -> new AssetPropertyEntity(p.getId(), p.getAssetId(), null, p.getPropertyId(), null, p.getValue())).collect(Collectors.toList());
			}
			AssetEntity entity = new AssetEntity();
			entity.setAssetCode(assetDto.getAssetCode());
			entity.setLocation(assetDto.getLocation());
			entity.setPurchaseDate(assetDto.getPurchaseDate());
			entity.setPurchaseValue(assetDto.getPurchaseValue());
			entity.setUsefullLifetime(assetDto.getUsefullLifetime());
			entity.setUserResponsible(assetDto.getUserResponsible());
			entity.setCategory(categoryEntity);
			entity.setProperties(listProperties);
			entity.setStatus(assetDto.getStatus());
			
			assetRepository.save(entity);
		}
	}

	@Override
	public AssetDTO findById(Long id) throws AssetException {
		Optional<AssetEntity> asset = assetRepository.findById(id);
		return asset.isPresent() ? asset.get().getDTO() : null;
	}

	@Override
	public AssetDTO findByCode(String code) throws AssetException {
		Optional<AssetEntity> asset = assetRepository.findByAssetCode(code);
		return asset.isPresent() ? asset.get().getDTO() : null;
	}

	@Override
	public List<AssetDTO> findAll() throws AssetException {
		List<AssetEntity> listEntity = (List<AssetEntity>) assetRepository.findAll();
		return listEntity.stream().map(a -> a.getDTO()).collect(Collectors.toList());
	}

}
