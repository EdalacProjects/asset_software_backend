package co.com.asset.repository.schedule;

import org.springframework.data.repository.CrudRepository;

import co.com.asset.model.entity.schedule.ScheduleEntity;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {

}
