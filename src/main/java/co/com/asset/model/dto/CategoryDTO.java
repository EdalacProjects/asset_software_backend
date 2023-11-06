package co.com.asset.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = -1829792288389099337L;
	
	private Long id;
	private String name;
	private String description;
	private Boolean status;
}
