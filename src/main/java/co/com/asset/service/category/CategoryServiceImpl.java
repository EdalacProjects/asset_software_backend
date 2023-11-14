package co.com.asset.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.asset.model.dto.CategoryDTO;
import co.com.asset.model.entity.CategoryEntity;
import co.com.asset.model.mapper.CategoryMapper;
import co.com.asset.repository.CategoryRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	private CategoryMapper categoryMapper;
	
	public CategoryServiceImpl(CategoryRepository repo, CategoryMapper categoryMapper) {
		super();
		this.categoryRepository = repo;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public void create(CategoryDTO dto) throws AssetException {
		CategoryEntity category = new CategoryEntity(null, dto.getName(), dto.getDescription(), dto.getStatus());
		categoryRepository.save(category);
	}

	@Override
	public CategoryDTO findByID(Long id) throws AssetException {
		if(id < 0 ) return null;
		
		Optional<CategoryEntity> entity = categoryRepository.findById(id);
		if(entity.isPresent()) {
			return categoryMapper.mapperEntityToDTO(entity.get());
		}
		return null;
	}

	@Override
	public List<CategoryDTO> findAll() throws AssetException {
		List<CategoryEntity> list = (List<CategoryEntity>) categoryRepository.findAll();
		return list.stream().map(c -> categoryMapper.mapperEntityToDTO(c)).toList();
	}

}
