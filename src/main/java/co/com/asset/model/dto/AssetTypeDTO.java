package co.com.asset.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class AssetTypeDTO implements Serializable {

	private static final long serialVersionUID = -7854010677473415891L;
	
	private Long id;
	private String name;
	private Long categoryId;
	private CategoryDTO category;
	private List<AssetTypeDetailDTO> details;
	
}
