package co.com.asset.service.property;

import java.util.List;

import co.com.asset.model.dto.PropertyDTO;
import co.com.asset.util.exception.AssetException;

public interface AssetPropertyService {

	void create(PropertyDTO property) throws AssetException;
	
	PropertyDTO findById(Long id) throws AssetException;
	
	List<PropertyDTO> findAll() throws AssetException;
}
