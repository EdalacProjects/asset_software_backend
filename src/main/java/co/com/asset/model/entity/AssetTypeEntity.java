package co.com.asset.model.entity;

import java.util.List;

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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "assetType", orphanRemoval = true)
	private List<AssetTypeDetailEntity> details;
	
	
}
