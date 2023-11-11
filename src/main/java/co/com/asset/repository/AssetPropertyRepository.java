package co.com.asset.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.AssetPropertyEntity;

public interface AssetPropertyRepository extends CrudRepository<AssetPropertyEntity, Long> {

	List<AssetPropertyEntity> findByAssetId(Long assetId);
}
