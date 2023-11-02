package co.com.asset.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.asset.model.dto.CategoryDTO;
import co.com.asset.service.category.CategoryService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/asset/category")
@ApiResponse(description = "Categorias")
public class CategoryController {
	
	@Autowired
	private CategoryService service;

	@GetMapping("/findById/{id}")
	public CategoryDTO findById(@PathVariable Integer id) {
		return service.findByID(id);
	}
	
	@GetMapping("/findAll")
	public List<CategoryDTO> findAll(){
		return service.findAll();
	}
}
