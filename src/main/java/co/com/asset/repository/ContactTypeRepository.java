package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.ContactTypeEntity;

public interface ContactTypeRepository extends CrudRepository<ContactTypeEntity, Integer> {

}
