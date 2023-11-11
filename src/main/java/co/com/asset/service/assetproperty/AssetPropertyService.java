package co.com.asset.service.assetproperty;

import java.util.List;

import co.com.asset.model.dto.AssetPropertyDTO;
import co.com.asset.model.entity.AssetPropertyEntity;
import co.com.asset.util.exception.AssetException;

public interface AssetPropertyService {

	void create(List<AssetPropertyEntity> properties) throws AssetException;
	
	void createDTO(List<AssetPropertyDTO> propertiesDTO) throws AssetException;
	
	List<AssetPropertyEntity> findByAssetId(Long assetId) throws AssetException;
}
