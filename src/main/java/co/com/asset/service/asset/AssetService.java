package co.com.asset.service.asset;

import java.util.List;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.util.exception.AssetException;

public interface AssetService {

	void create(AssetDTO assetDto) throws AssetException;
	
	AssetDTO findById(Long id) throws AssetException;
	
	AssetDTO findByCode(String code) throws AssetException;
	
	List<AssetDTO> findAll() throws AssetException;
}
