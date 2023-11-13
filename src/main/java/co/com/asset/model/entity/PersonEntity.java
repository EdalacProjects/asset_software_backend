package co.com.asset.model.entity;

import java.time.LocalDate;

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
@Table(name = "person_master")
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String genre;
	
	@Column(name = "identification_type_id")
	private int identificationTypeId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private IdentificationTypeEntity identificationType;
	
	private String identificationNumber;
	
	@Column(name = "city_id")
	private int cityId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private CityEntity city;
	
	private Boolean status;
	
}
