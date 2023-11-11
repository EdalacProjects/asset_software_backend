package co.com.asset.model.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.model.dto.AssetPropertyDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.AssetPropertyEntity;
import co.com.asset.model.entity.CategoryEntity;
import co.com.asset.model.entity.UserEntity;
import co.com.asset.repository.CategoryRepository;
import co.com.asset.repository.UserRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetMapper implements AbstractMapper<AssetEntity, AssetDTO> {

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AssetPropertyMapper assetPropertyMapper;

	@Override
	public AssetEntity mapperDtoToEntity(AssetDTO dto) {
		return AssetEntity.builder()
				.id(dto.getId())
				.assetCode(dto.getAssetCode())
				.purchaseValue(dto.getPurchaseValue())
				.purchaseDate(dto.getPurchaseDate())
				.usefullLifetime(dto.getUsefullLifetime())
				.userResponsible(this.findUserById(dto.getUserResponsible()))
				.location(dto.getLocation())
				.status(dto.getStatus())
				.categoryId(dto.getCategory().getId())
				.category(this.findCategoryById(dto.getCategory().getId()))
				.properties(null)
				.build();
	}

	@Override
	public AssetDTO mapperEntityToDTO(AssetEntity entity) {
		return AssetDTO.builder()
			.id(entity.getId())
			.assetCode(entity.getAssetCode())
			.purchaseValue(entity.getPurchaseValue())
			.purchaseDate(entity.getPurchaseDate())
			.usefullLifetime(entity.getUsefullLifetime())
			.userResponsible(entity.getUserResponsibleId())
			.location(entity.getLocation())
			.status(entity.getStatus())
			.category(categoryMapper.mapperEntityToDTO(entity.getCategory()))
			.properties(this.convertListEntityToListDTO(entity.getProperties()))
			.build();
	}

	private CategoryEntity findCategoryById(Long id) {
		Optional<CategoryEntity> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
		} else {
			throw new AssetException("Category Not Found");
		}
	}

	private UserEntity findUserById(Long id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new AssetException("User Not Found");
		}
	}
	
	private List<AssetPropertyDTO> convertListEntityToListDTO(List<AssetPropertyEntity> listEntity){
		return listEntity.stream()
				.map(p -> assetPropertyMapper.mapperEntityToDTO(p))
				.collect(Collectors.toList());
				
	}
}
