package co.com.asset.model.entity.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "notification_type")
public class NotificationType {

	@Id
	private int id;
	private String name;
}
