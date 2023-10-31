package co.com.asset.controller.asset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.asset.model.dto.AssetDTO;
import co.com.asset.service.asset.AssetService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController(value = "/asset")
@ApiResponse()
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	@PostMapping
	public void create(AssetDTO asset) {
		System.out.println(asset);
//		assetService.create(asset);
	}
	
	@GetMapping(value = "/findById/{id}")
	public AssetDTO findById(@PathVariable Long id){
		return assetService.findById(id);
	}
	
	@GetMapping(value = "/findByCode/{code}")
	public AssetDTO findByCode(@PathVariable String code) {
		return assetService.findByCode(code);
	}
	
	@GetMapping(value = "/findAll")
	public List<AssetDTO> findAll(){
		return assetService.findAll();
	}
}
