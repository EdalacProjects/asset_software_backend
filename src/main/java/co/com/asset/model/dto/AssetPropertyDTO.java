package co.com.asset.model.dto;

import java.io.Serializable;

import co.com.asset.model.entity.PropertyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AssetPropertyDTO implements Serializable {

	private static final long serialVersionUID = 8090397037118628311L;
	
	private Long id;
	private Long assetId;
	private PropertyEntity property;
	private String value;
}
