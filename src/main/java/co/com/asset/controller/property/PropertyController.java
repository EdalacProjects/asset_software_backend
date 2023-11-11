package co.com.asset.controller.property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.asset.model.dto.PropertyDTO;
import co.com.asset.service.property.PropertyService;
import co.com.asset.util.exception.AssetException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/asset/property")
@ApiResponse(ref = "Property", description = "Property Controller")
public class PropertyController {

	@Autowired
	private PropertyService service;
	
	@PostMapping
	public void create(PropertyDTO property) throws AssetException{
		
	}
	
	@GetMapping("findById/{id}")
	public PropertyDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping("findAll")
	public List<PropertyDTO> findAll(){
		return service.findAll();
	}
}
