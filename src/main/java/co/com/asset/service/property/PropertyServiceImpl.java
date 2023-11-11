package co.com.asset.service.property;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.PropertyDTO;
import co.com.asset.model.entity.PropertyEntity;
import co.com.asset.model.mapper.PropertyMapper;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository repo;
	
	@Autowired
	private PropertyMapper propertyMapper;
	
	@Override
	public void create(PropertyDTO property) throws AssetException {
		// TODO Auto-generated method stub

	}

	@Override
	public PropertyDTO findById(Long id) throws AssetException {
		Optional<PropertyEntity> property = repo.findById(id);
		if(property.isPresent()) {
			return propertyMapper.mapperEntityToDTO(property.get());
		}else {
			throw new AssetException("Error mapping PropertyDTO");
		}
	}

	@Override
	public List<PropertyDTO> findAll() throws AssetException {
		List<PropertyEntity> properties = (List<PropertyEntity>) repo.findAll();
		return properties.stream().map(p -> propertyMapper.mapperEntityToDTO(p)).collect(Collectors.toList());
	}

}
