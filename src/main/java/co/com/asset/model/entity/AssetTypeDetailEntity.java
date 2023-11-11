package co.com.asset.model.entity;

import co.com.asset.model.dto.AssetTypeDetailDTO;
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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "asset_type_detail")
@NoArgsConstructor
@AllArgsConstructor
public class AssetTypeDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "asset_type_id", insertable = false, updatable = false)
	private Long assetTypeId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(insertable = true, updatable = true)
	private AssetTypeEntity assetType;
	
	@Column(name = "property_id")
	private Long propertyId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private PropertyEntity property;
	
//	public AssetTypeDetailDTO getDto() {
//		return new AssetTypeDetailDTO(this.id, this.assetTypeId, this.propertyId, this.property.getDto());
//	}
}
