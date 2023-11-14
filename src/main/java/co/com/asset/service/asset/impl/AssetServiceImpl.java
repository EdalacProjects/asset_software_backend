package co.com.asset.service.asset.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.mapper.AssetMapper;
import co.com.asset.repository.AssetRepository;
import co.com.asset.service.asset.AssetService;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetServiceImpl implements AssetService {

	private AssetRepository assetRepository;
	
	private AssetMapper assetMapper;
	
	public AssetServiceImpl(AssetRepository assetRepository, AssetMapper assetMapper) {
		this.assetRepository = assetRepository;
		this.assetMapper = assetMapper;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void create(AssetDTO assetDto) throws AssetException {
		if(Objects.nonNull(assetDto)) {			
			AssetEntity entity = assetMapper.mapperDtoToEntity(assetDto);
			assetRepository.save(entity);
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
		return listEntity.stream()
			.map(a -> assetMapper.mapperEntityToDTO(a))
			.toList();
	}

}
