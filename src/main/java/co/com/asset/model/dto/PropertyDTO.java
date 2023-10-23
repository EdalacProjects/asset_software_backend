package co.com.asset.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropertyDTO implements Serializable {

	private static final long serialVersionUID = 2099640153330056158L;
	
	private Long id;
	private String name;
	private String description;
}
