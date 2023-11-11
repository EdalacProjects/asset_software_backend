package co.com.asset.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "asset_property")
@NoArgsConstructor
@AllArgsConstructor
public class AssetPropertyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "asset_id", insertable = false, updatable = false)
	private Long assetId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(insertable = true, updatable = true)
	private AssetEntity asset;
	
	@Column(name = "property_id")
	private int propertyId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private PropertyEntity property;
	
	private String value;
	
}
