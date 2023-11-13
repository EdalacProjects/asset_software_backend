package co.com.asset.model.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import co.com.asset.model.AbstractResponseEntity;
import co.com.asset.model.dto.IoTData;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class IoTTracerLogRequest extends AbstractResponseEntity implements Serializable{
	
	private static final long serialVersionUID = -5259785145190641940L;

	// This fields are used for register data
	private Integer iotSensorId;
	private Long assetId;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
//	@JsonSerialize(using = LocalDateTimeSerializer.class)
//	@Null
//	private LocalDateTime dateTime;
	private String dateTime;
	
//	@Null
	private List<IoTData> data;
	
	// This fields are used for queries by date
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime fromDateTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime toDateTime;
	
}
