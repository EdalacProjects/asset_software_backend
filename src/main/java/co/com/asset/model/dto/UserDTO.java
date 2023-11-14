package co.com.asset.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 4762101345170205023L;
	private Long id;
	private String userName;
	private String password;
	private LocalDate insertionDateTime;
	private LocalDate updateDateTime;
	private int status;

	private PersonDTO person;
}
