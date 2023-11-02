package co.com.asset.service.category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.CategoryDTO;
import co.com.asset.model.entity.CategoryEntity;
import co.com.asset.repository.CategoryRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Override
	public void create(CategoryDTO dto) throws AssetException {
		CategoryEntity category = new CategoryEntity(null, dto.getName(), dto.getDescription(), dto.getStatus());
		repo.save(category);
	}

	@Override
	public CategoryDTO findByID(Integer id) throws AssetException {
		if(id < 0 ) return null;
		
		Optional<CategoryEntity> entity = repo.findById(id);
		if(entity.isPresent()) {
			return entity.get().getDTO();
		}
		return null;
	}

	@Override
	public List<CategoryDTO> findAll() throws AssetException {
		List<CategoryEntity> list = (List<CategoryEntity>) repo.findAll();
		return list.stream().map(c -> c.getDTO()).collect(Collectors.toList());
	}

}
