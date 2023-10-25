package co.com.asset.controller.assettype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.asset.model.dto.AssetTypeDTO;
import co.com.asset.model.request.AssetTypeRequest;
import co.com.asset.service.assettype.AssetTypeService;
import co.com.asset.util.exception.AssetException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController()
@RequestMapping(value = "/asset/asset-type")
@ApiResponse
public class AssetTypeController {

	@Autowired
	private AssetTypeService assetService;
	
	@PostMapping
	public ResponseEntity<AssetTypeDTO> create(@RequestBody AssetTypeRequest request) {
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AssetTypeDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(assetService.getById(id));
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<AssetTypeDTO>> findAll(){
		try {
			return ResponseEntity.ok(assetService.findAll());
		}catch (AssetException e) {
			return null;
		}
		
	}
	
}
