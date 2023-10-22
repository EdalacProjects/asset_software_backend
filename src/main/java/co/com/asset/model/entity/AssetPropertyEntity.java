package co.com.asset.model.entity;

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
@Table(name = "asset_property")
public class AssetPropertyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "asset_id")
	private Long assetId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private AssetEntity asset;
	
	@Column(name = "property_id")
	private int propertyId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private PropertyEntity property;
	
	private String value;
	
}
