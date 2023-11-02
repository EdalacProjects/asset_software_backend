package co.com.asset.service.category;

import java.util.List;

import co.com.asset.model.dto.CategoryDTO;
import co.com.asset.util.exception.AssetException;

public interface CategoryService {

	void create(CategoryDTO categoryDTO) throws AssetException;
	
	CategoryDTO findByID(Integer id) throws AssetException;
	
	List<CategoryDTO> findAll() throws AssetException;
}
