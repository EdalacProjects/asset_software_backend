package co.com.asset.service.asset.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.repository.AssetRepository;
import co.com.asset.service.asset.AssetService;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public void create(AssetDTO assetDto) throws AssetException {
		// TODO Auto-generated method stub

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
