package co.com.asset.controller.assettype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.com.asset.service.assettype.AssetTypeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@ApiResponse
public class AssetTypeController {

	@Autowired
	private AssetTypeService assetService;
	
	@GetMapping("/{id}")
	public ResponseEntity getAssetType(@PathVariable Long id) {
		return ResponseEntity.ok(assetService.getById(id));
	}
}
