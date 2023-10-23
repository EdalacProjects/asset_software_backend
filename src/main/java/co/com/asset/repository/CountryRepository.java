package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.CountryEntity;

public interface CountryRepository extends CrudRepository<CountryEntity, Integer> {

}
