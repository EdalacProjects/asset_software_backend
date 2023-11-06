package co.com.asset.service.property;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.PropertyDTO;
import co.com.asset.model.entity.PropertyEntity;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetPropertyServiceImpl implements AssetPropertyService {

	@Autowired
	private PropertyRepository repo;
	
	@Override
	public void create(PropertyDTO property) throws AssetException {
		// TODO Auto-generated method stub

	}

	@Override
	public PropertyDTO findById(Long id) throws AssetException {
		Optional<PropertyEntity> property = repo.findById(id);
		return property.isPresent() ? property.get().getDto() : null;
	}

	@Override
	public List<PropertyDTO> findAll() throws AssetException {
		List<PropertyEntity> properties = (List<PropertyEntity>) repo.findAll();
		List<PropertyDTO> propDTO = properties.stream().map(p -> p.getDto()).collect(Collectors.toList());
		return null;
	}

}
