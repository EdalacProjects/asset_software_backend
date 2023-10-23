package co.com.asset.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder()
@AllArgsConstructor
public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = -1829792288389099337L;
	
	private Integer id;
	private String name;
	private String description;
	private Boolean status;
}
