package co.com.asset.model.dto;

import java.io.Serializable;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IoTData implements Serializable {
	
	private static final long serialVersionUID = -8675078089726032726L;
	
	@Id
	private Long idProperty;
	private String propertyName;
	private String propertyValue;
	
}
