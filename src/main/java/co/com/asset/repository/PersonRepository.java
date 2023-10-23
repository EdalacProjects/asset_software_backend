package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

}
