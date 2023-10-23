package co.com.asset.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.AssetTypeEntity;

public interface AssetTypeRepository extends CrudRepository<AssetTypeEntity, Long> {

}
