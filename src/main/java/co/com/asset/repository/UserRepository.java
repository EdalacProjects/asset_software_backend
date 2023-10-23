package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
