package co.com.asset.model.entity.schedule;

import java.time.LocalDate;

import co.com.asset.model.entity.AssetEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
	private Long id;
	private LocalDate executionDate;
	
	@Column(name = "asset_id")
	private Long assetId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private AssetEntity asset;
	
	private Boolean status;
	
}
