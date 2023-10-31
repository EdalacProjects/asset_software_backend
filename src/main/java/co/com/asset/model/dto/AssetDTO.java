package co.com.asset.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssetDTO implements Serializable {

	private static final long serialVersionUID = -2505117469180531430L;
	
	private Long id;
	private String assetCode;
	private Double purchaseValue;	
	private LocalDate purchaseDate;
	private String usefullLifetime;
	private String userResponsible;
	private String location;	
	private Boolean status;	
	
	private CategoryDTO category;
	
	private List<AssetPropertyDTO> properties;
}
