package co.com.asset.model.entity.notification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notification")
public class NotificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subject;
	private String recipient;
	private String template;
	
	@Column(name = "notification_type_id")
	private Integer notificationTypeId;
	
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false)
	private NotificationTypeEntity notificationType;
}
