package co.com.asset.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssetDTO implements Serializable {

	private static final long serialVersionUID = -2505117469180531430L;
	
	private Long id;
	private String assetCode;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate purchaseDate;
	
	private Double purchaseValue;	
	private String usefullLifetime;
	private UserDTO userResponsible;
	private String location;	
	private Boolean status;	
	
	private CategoryDTO category;
	
	private List<AssetPropertyDTO> properties;
}
