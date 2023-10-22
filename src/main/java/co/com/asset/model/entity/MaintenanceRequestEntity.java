package co.com.asset.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class MaintenanceRequestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate registerDate;
	private LocalDate clousureDate;
	
	@Column(name = "asset_id")
	private Long assetId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private AssetEntity asset;
	
	private String justification;
	private String applicant;
	private String notes;
	
	@Column(name = "status_type_id")
	private int statusTypeId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private StatusTypeEntity statusType;
	
	private String requestNumber;
	
}
