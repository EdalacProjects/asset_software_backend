package co.com.asset.service.assetproperty;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetPropertyDTO;
import co.com.asset.model.entity.AssetPropertyEntity;
import co.com.asset.model.entity.PropertyEntity;
import co.com.asset.repository.AssetPropertyRepository;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetPropertyServiceImpl implements AssetPropertyService {

	private AssetPropertyRepository repository;
	
	private PropertyRepository propertyRepository;
	
	public AssetPropertyServiceImpl(AssetPropertyRepository repository, PropertyRepository propertyRepository) {
		super();
		this.repository = repository;
		this.propertyRepository = propertyRepository;
	}

	@Override
	public void create(List<AssetPropertyEntity> properties) throws AssetException {
		properties.stream().forEach(p -> repository.save(p));
	}

	@Override
	public void createDTO(List<AssetPropertyDTO> propertiesDTO) throws AssetException {
		//TODO. Realizar la implementación
		propertiesDTO.stream()
		.forEach(d -> {
			PropertyEntity propertyEntity = propertyRepository.findById(d.getProperty().getId()).get();
			if(Objects.isNull(propertyEntity)) {
//				new AssetPropertyEntity(null, null, null, 0, null, null);
			}
		});
		
		this.create(null);
	}

	@Override
	public List<AssetPropertyEntity> findByAssetId(Long assetId) throws AssetException {
		return repository.findByAssetId(assetId);
	}

}
