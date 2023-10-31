package co.com.asset.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssetPropertyDTO implements Serializable {

	private static final long serialVersionUID = 8090397037118628311L;
	
	private Long id;
	private Long assetId;
	private int propertyId;
	private String value;
}
