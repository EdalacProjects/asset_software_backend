package co.com.asset.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AssetTypeDetailDTO implements Serializable {

	private static final long serialVersionUID = 7357217350487773299L;
	
	private Long id;
	private Long assetTypeId;
	private Long propertyId;
	private PropertyDTO property;
}
