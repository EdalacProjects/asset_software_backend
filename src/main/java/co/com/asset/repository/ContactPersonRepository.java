package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.ContactPersonEntity;

public interface ContactPersonRepository extends CrudRepository<ContactPersonEntity, Long> {

}
