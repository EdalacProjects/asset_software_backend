package co.com.asset.service.assetproperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetPropertyDTO;
import co.com.asset.model.entity.AssetPropertyEntity;
import co.com.asset.model.entity.PropertyEntity;
import co.com.asset.repository.AssetPropertyRepository;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetPropertyServiceImpl implements AssetPropertyService {

	@Autowired
	private AssetPropertyRepository repository;
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	public void create(List<AssetPropertyEntity> properties) throws AssetException {
		properties.stream().forEach(p -> repository.save(p));
	}

	@Override
	public void createDTO(List<AssetPropertyDTO> propertiesDTO) throws AssetException {
		List<AssetPropertyEntity> list = new ArrayList<AssetPropertyEntity>();
				propertiesDTO.stream()
				.forEach(d -> {
					PropertyEntity propertyEntity = propertyRepository.findById(d.getProperty().getId()).get();
					if(Objects.nonNull(propertyEntity)) {
						new AssetPropertyEntity(null, null, null, 0, null, null);
					}
				});
		
		this.create(null);
	}

	@Override
	public List<AssetPropertyEntity> findByAssetId(Long assetId) throws AssetException {
		return repository.findByAssetId(assetId);
	}

}