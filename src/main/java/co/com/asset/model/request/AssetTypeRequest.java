package co.com.asset.model.request;

import java.io.Serializable;
import java.util.List;

import co.com.asset.model.AbstractResponseEntity;
import co.com.asset.model.dto.AssetTypeDetailDTO;
import co.com.asset.model.dto.CategoryDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AssetTypeRequest extends AbstractResponseEntity implements Serializable{

	private static final long serialVersionUID = 1906019241206626055L;

	private String name;
	private CategoryDTO category;
	private List<AssetTypeDetailDTO> details;
}
