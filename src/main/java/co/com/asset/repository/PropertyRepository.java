package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.PropertyEntity;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

}
