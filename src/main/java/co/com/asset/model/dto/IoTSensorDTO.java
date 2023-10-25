package co.com.asset.model.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class IoTSensorDTO implements Serializable {
	
	private static final long serialVersionUID = 6651565952022880665L;
	
	private Integer id;
	private String code;
	private String name;
	
}
