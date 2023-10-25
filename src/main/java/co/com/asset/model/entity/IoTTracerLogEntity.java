package co.com.asset.model.entity;

import java.time.LocalDateTime;

import co.com.asset.model.request.IoTTracerLogResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "iot_tracer_log")
@NoArgsConstructor
public class IoTTracerLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTracer;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private IoTSensorEntity iotSensor;
	
	@Column(name = "iot_sensor_id")
	private Integer iotSensorId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private AssetEntity asset;
	
	@Column(name = "asset_id")
	private Long assetId;
	
	private Long propertyId;
	private String propertyName;
	private String propertyValue;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dateTime;
	
	public IoTTracerLogResponse getResponseDTO() {
		return new IoTTracerLogResponse(iotSensorId, assetId, dateTime, propertyId, propertyName, propertyValue);
	}

	public IoTTracerLogEntity(Integer iotSensorId, Long assetId, Long propertyId, String propertyName,
			String propertyValue, LocalDateTime dateTime) {
		super();
		this.iotSensorId = iotSensorId;
		this.assetId = assetId;
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.dateTime = dateTime;
	}
	
	
}
