package co.com.asset.model.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import co.com.asset.model.dto.AssetDTO;
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

@Data
@Entity
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

	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private CategoryEntity category;

	@OneToMany(mappedBy = "asset", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AssetPropertyEntity> properties;

	public AssetDTO getDTO() {
		return new AssetDTO(this.id, this.assetCode, this.purchaseValue, this.purchaseDate, this.usefullLifetime,
				this.userResponsibleId, this.location, this.status,
				Objects.nonNull(this.category) ? this.category.getDTO() : null, null);
	}
}
