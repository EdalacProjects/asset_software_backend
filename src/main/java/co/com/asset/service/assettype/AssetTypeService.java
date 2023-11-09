package co.com.asset.service.assettype;

import java.util.List;

import co.com.asset.model.dto.AssetTypeDTO;
import co.com.asset.model.request.AssetTypeRequest;
import co.com.asset.util.exception.AssetException;

public interface AssetTypeService {

	AssetTypeDTO create(AssetTypeRequest request) throws AssetException;

	AssetTypeDTO getById(Long id) throws AssetException;

	List<AssetTypeDTO> findAll() throws AssetException;
}
