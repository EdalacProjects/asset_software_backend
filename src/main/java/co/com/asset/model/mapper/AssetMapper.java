package co.com.asset.model.mapper;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.model.dto.UserDTO;
import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.CategoryEntity;
import co.com.asset.model.entity.UserEntity;
import co.com.asset.repository.CategoryRepository;
import co.com.asset.repository.UserRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class AssetMapper implements AbstractMapper<AssetEntity, AssetDTO> {

	private CategoryMapper categoryMapper;

	private CategoryRepository categoryRepository;

	private UserRepository userRepository;

	private AssetPropertyMapper assetPropertyMapper;

	private UserMapper userMapper;

	public AssetMapper(CategoryMapper categoryMapper, CategoryRepository categoryRepository,
			UserRepository userRepository, AssetPropertyMapper assetPropertyMapper, UserMapper userMapper) {
		super();
		this.categoryMapper = categoryMapper;
		this.categoryRepository = categoryRepository;
		this.userRepository = userRepository;
		this.assetPropertyMapper = assetPropertyMapper;
		this.userMapper = userMapper;
	}

	@Override
	public AssetEntity mapperDtoToEntity(AssetDTO dto) {
		AssetEntity assetEntity = AssetEntity.builder()
				.id(dto.getId())
				.assetCode(dto.getAssetCode())
				.purchaseValue(dto.getPurchaseValue())
				.purchaseDate(dto.getPurchaseDate())
				.usefullLifetime(dto.getUsefullLifetime())
				.location(dto.getLocation())
				.status(dto.getStatus())
				.categoryId(dto.getCategory().getId())
				.category(this.findCategoryById(dto.getCategory().getId()))
				.build();
		if(Objects.isNull(dto.getUserResponsible())) dto.setUserResponsible(UserDTO.builder().id(0L).build());
		assetEntity.setUserResponsible(this.findUserById(dto.getUserResponsible().getId()));
		assetEntity.setUserResponsibleId(dto.getUserResponsible().getId());		
		assetEntity.setProperties(assetPropertyMapper.convertListDTOToListEntity(dto.getProperties(), assetEntity));
		return assetEntity;
		
	}

	@Override
	public AssetDTO mapperEntityToDTO(AssetEntity entity) {
		return AssetDTO.builder()
			.id(entity.getId())
			.assetCode(entity.getAssetCode())
			.purchaseValue(entity.getPurchaseValue())
			.purchaseDate(entity.getPurchaseDate())
			.usefullLifetime(entity.getUsefullLifetime())
			.userResponsible(userMapper.mapperEntityToDTO(entity.getUserResponsible()))
			.location(entity.getLocation())
			.status(entity.getStatus())
			.category(categoryMapper.mapperEntityToDTO(entity.getCategory()))
			.properties(assetPropertyMapper.convertListEntityToListDTO(entity.getProperties()))
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
}
