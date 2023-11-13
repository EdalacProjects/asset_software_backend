package co.com.asset.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import co.com.asset.model.entity.CityEntity;
import co.com.asset.model.entity.IdentificationTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = -2330804183461912155L;

	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String genre;
	private IdentificationTypeEntity identificationType;	
	private String identificationNumber;	
	private CityEntity city;	
	private Boolean status;
}
