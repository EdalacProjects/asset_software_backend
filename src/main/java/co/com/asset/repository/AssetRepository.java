package co.com.asset.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.AssetEntity;

public interface AssetRepository extends CrudRepository<AssetEntity, Long> {

	Optional<AssetEntity> findByAssetCode(String code);
}
