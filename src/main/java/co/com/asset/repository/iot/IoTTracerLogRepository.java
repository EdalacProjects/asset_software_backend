package co.com.asset.repository.iot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.IoTTracerLogEntity;

public interface IoTTracerLogRepository extends CrudRepository<IoTTracerLogEntity, Long> {

	List<IoTTracerLogEntity> findByDateTimeGreaterThanEqualAndDateTimeLessThanEqual(LocalDate fromDate, LocalDate toDate);
	
	List<IoTTracerLogEntity> findAllByIotSensorIdAndAssetIdAndDateTimeGreaterThanEqualAndDateTimeLessThanEqual(Integer iotSensorId, Long assetId, LocalDateTime fromDate, LocalDateTime toDate);
}
