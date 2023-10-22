package co.com.asset.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "iot_tracer_log")
public class IoTTracerLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTracer;
	
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
	private String propertyName;
	private String propertyValue;
	private LocalDate dateTime;
}
