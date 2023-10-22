package co.com.asset.model.entity.notification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "notification")
public class Notification {

	@Id
	private Long id;
	private String subject;
	private String recipient;
	
	@Column(name = "notification_type_id")
	private int notificationTypeId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private NotificationType notificationType;
	
	private String template;
	
}
