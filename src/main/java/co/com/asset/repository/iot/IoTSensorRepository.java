package co.com.asset.repository.iot;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.IoTSensorEntity;

public interface IoTSensorRepository extends CrudRepository<IoTSensorEntity, Integer> {

}
