package co.com.asset.model.request;

import java.io.Serializable;
import java.time.LocalDateTime;

import co.com.asset.model.AbstractResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class IoTTracerLogResponse extends AbstractResponseEntity implements Serializable{
	
	private static final long serialVersionUID = -5259785145190641940L;

	private Integer iotSensorId;
	private Long assetId;
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;
	
	private Integer idProperty;
	private String propertyName;
	private String propertyValue;
	
}
