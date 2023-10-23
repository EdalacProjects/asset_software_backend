package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.WorkOrderDetailEntity;

public interface WorkOrderDetailRepository extends CrudRepository<WorkOrderDetailEntity, Long> {

}
