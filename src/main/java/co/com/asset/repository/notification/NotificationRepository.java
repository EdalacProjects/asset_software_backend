package co.com.asset.repository.notification;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.notification.NotificationEntity;

public interface NotificationRepository extends CrudRepository<NotificationEntity, Long> {

}
