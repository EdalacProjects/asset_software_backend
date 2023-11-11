package co.com.asset.service.asset.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.AssetPropertyEntity;
import co.com.asset.model.entity.CategoryEntity;
import co.com.asset.model.mapper.AssetMapper;
import co.com.asset.repository.AssetRepository;
import co.com.asset.repository.CategoryRepository;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.service.asset.AssetService;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private AssetMapper assetMapper;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void create(AssetDTO assetDto) throws AssetException {
		CategoryEntity categoryEntity = null;
		List<AssetPropertyEntity> listProperties = null;
		if(Objects.nonNull(assetDto)) {
			if(Objects.nonNull(assetDto.getCategory())) {
				categoryEntity = categoryRepository.findById(assetDto.getCategory().getId()).get();	
			}else {
				throw new AssetException("Category not Found");
			}
//			if(Objects.nonNull(assetDto.getProperties()) && !assetDto.getProperties().isEmpty()) {
//				listProperties = assetDto.getProperties().stream().map(p -> new AssetPropertyEntity(p.getId(), p.getAssetId(), null, p.getPropertyId(), propertyRepository.findById(p.getPropertyId()).get(), p.getValue())).collect(Collectors.toList());
//			}
			
//			AssetEntity entity = new AssetEntity();
//			entity.setAssetCode(assetDto.getAssetCode());
//			entity.setLocation(assetDto.getLocation());
//			entity.setPurchaseDate(assetDto.getPurchaseDate());
//			entity.setPurchaseValue(assetDto.getPurchaseValue());
//			entity.setUsefullLifetime(assetDto.getUsefullLifetime());
//			entity.setUserResponsibleId(assetDto.getUserResponsible());
//			entity.setCategoryId(categoryEntity.getId());
//			entity.setProperties(listProperties);
//			entity.setStatus(assetDto.getStatus());
			
			
			assetRepository.save(assetMapper.mapperDtoToEntity(assetDto));
		}
	}

	@Override
	public AssetDTO findById(Long id) throws AssetException {
		Optional<AssetEntity> asset = assetRepository.findById(id);
		if(asset.isPresent()) {
			return assetMapper.mapperEntityToDTO(asset.get());
		}else {
			throw new AssetException("Error mapping AssetDTO");
		}
	}

	@Override
	public AssetDTO findByCode(String code) throws AssetException {
		Optional<AssetEntity> asset = assetRepository.findByAssetCode(code);
		if(asset.isPresent()) {
			return assetMapper.mapperEntityToDTO(asset.get());
		}else {
			throw new AssetException("Error mapping AssetDTO");
		}
	}

	@Override
	public List<AssetDTO> findAll() throws AssetException {
		List<AssetEntity> listEntity = (List<AssetEntity>) assetRepository.findAll();
		return listEntity.stream().map(a -> assetMapper.mapperEntityToDTO(a)).collect(Collectors.toList());
	}

}
