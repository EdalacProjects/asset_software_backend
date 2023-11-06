package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

}
