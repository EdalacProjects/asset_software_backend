package co.com.asset.model.entity;

import java.time.LocalDate;
import java.util.List;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder()
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asset")
public class AssetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String assetCode;
	private Double purchaseValue;
	private LocalDate purchaseDate;
	private String usefullLifetime;
	
	@Column(name = "user_responsible_id")
	private Long userResponsibleId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private UserEntity userResponsible;
	
	private String location;
	private Boolean status;
	
	@Column(name = "category_id", insertable = false, updatable = false)
	private Long categoryId;
	
	@ManyToOne
	@JoinColumn
	private CategoryEntity category;

	@OneToMany(mappedBy = "asset", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<AssetPropertyEntity> properties;

}
