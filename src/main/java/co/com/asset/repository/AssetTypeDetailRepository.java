package co.com.asset.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.AssetTypeDetailEntity;

public interface AssetTypeDetailRepository extends CrudRepository<AssetTypeDetailEntity, Long> {

	List<AssetTypeDetailEntity> findByAssetTypeId(Long assetId);
}
