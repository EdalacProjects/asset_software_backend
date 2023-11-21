package co.com.asset.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asset_property")
public class AssetPropertyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "asset_id", insertable = false, updatable = false)
	private Long assetId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(columnDefinition = "asset_id", insertable = true, updatable = false)
	private AssetEntity asset;
	
	@Column(name = "property_id", insertable = true, updatable = false)
	private Long propertyId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private PropertyEntity property;
	
	private String value;
	
}
