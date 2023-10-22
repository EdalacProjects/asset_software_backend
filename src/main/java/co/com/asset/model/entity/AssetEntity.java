package co.com.asset.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String userResponsible;
	private String location;	
	private Boolean status;		
}
