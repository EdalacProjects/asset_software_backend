package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.MaintenanceRequestEntity;

public interface MaintenanceRequestRepository extends CrudRepository<MaintenanceRequestEntity, Long> {

}
