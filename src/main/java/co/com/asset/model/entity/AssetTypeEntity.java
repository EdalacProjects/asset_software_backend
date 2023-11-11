package co.com.asset.model.entity;

import java.util.List;
import java.util.stream.Collectors;

import co.com.asset.model.dto.AssetTypeDTO;
import co.com.asset.model.dto.AssetTypeDetailDTO;
import co.com.asset.model.dto.CategoryDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
	@OneToMany(mappedBy = "assetType", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<AssetTypeDetailEntity> details;
	
	
}
