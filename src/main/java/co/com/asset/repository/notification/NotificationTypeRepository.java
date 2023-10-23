package co.com.asset.repository.notification;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.notification.NotificationTypeEntity;

public interface NotificationTypeRepository extends CrudRepository<NotificationTypeEntity, Integer> {

}
