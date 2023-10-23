package co.com.asset.model.entity;

import co.com.asset.model.dto.PropertyDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "property_master")
@NoArgsConstructor
public class PropertyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	public PropertyDTO getDto() {
		return new PropertyDTO(this.id, this.name, this.description);
	}
}
