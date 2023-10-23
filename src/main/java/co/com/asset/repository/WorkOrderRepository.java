package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.WorkOrderEntity;

public interface WorkOrderRepository extends CrudRepository<WorkOrderEntity, Long> {

}
