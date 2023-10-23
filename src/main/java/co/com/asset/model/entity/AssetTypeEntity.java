package co.com.asset.model.entity;

import java.util.HashSet;
import java.util.Set;

import co.com.asset.model.dto.AssetTypeDTO;
import co.com.asset.model.dto.CategoryDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "asset_type_master")
@NoArgsConstructor
public class AssetTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(name = "category_id")
	private Long categoryId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private CategoryEntity category;
	
	@OneToMany(mappedBy = "assetType", cascade = CascadeType.ALL)
	Set<AssetTypeDetailEntity> details = new HashSet<>();
	
	public AssetTypeDTO getDTO() {
		AssetTypeDTO dto = new AssetTypeDTO();
		dto.setId(this.id);
		dto.setName(this.name);
		dto.setCategory(new CategoryDTO(this.category.getId(), this.category.getName(), this.category.getDescription(), this.category.getStatus()));
//		List<AssetTypeDetailDTO> detailsDto = this.details.stream().map(d -> new AssetTypeDetailDTO(d.getId(), d.getAssetTypeId(), d.getPropertyId(), null)).collect(Collectors.toList());
//		dto.setDetails(detailsDto);
		
		return dto;
	}
}
