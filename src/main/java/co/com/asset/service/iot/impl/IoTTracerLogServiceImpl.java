package co.com.asset.service.iot.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import co.com.asset.model.entity.AssetEntity;
import co.com.asset.model.entity.IoTSensorEntity;
import co.com.asset.model.entity.IoTTracerLogEntity;
import co.com.asset.model.request.IoTTracerLogRequest;
import co.com.asset.model.request.IoTTracerLogResponse;
import co.com.asset.repository.AssetRepository;
import co.com.asset.repository.PropertyRepository;
import co.com.asset.repository.iot.IoTSensorRepository;
import co.com.asset.repository.iot.IoTTracerLogRepository;
import co.com.asset.service.iot.IoTTracerLogService;
import co.com.asset.util.exception.AssetException;

@Component
public class IoTTracerLogServiceImpl implements IoTTracerLogService {

	private Logger logger = LoggerFactory.getLogger(IoTTracerLogServiceImpl.class);
	
	private IoTTracerLogRepository ioTTracerRepository;
	
	private AssetRepository assetRepository;
	
	private IoTSensorRepository iotRepository;
	
	private PropertyRepository propertyRepository;

	public IoTTracerLogServiceImpl(IoTTracerLogRepository ioTTracerRepository, AssetRepository assetRepository,
			IoTSensorRepository iotRepository, PropertyRepository propertyRepository) {
		this.ioTTracerRepository = ioTTracerRepository;
		this.assetRepository = assetRepository;
		this.iotRepository = iotRepository;
		this.propertyRepository = propertyRepository;
	}

	@Override
	public void create(IoTTracerLogRequest request) throws AssetException {
		logger.info("Searching asset and iotSensor info in database.");
		Optional<AssetEntity> asset = assetRepository.findById(request.getAssetId());
		Optional<IoTSensorEntity> iotSensor = iotRepository.findById(request.getIotSensorId());
		if(asset.isPresent() && iotSensor.isPresent() && !request.getData().isEmpty()) {
			boolean existAll = request.getData().stream().allMatch(d -> propertyRepository.findById(d.getIdProperty().longValue()).isPresent());
			if(existAll) {
				Iterable<IoTTracerLogEntity> listEntites = request.getData()
					.stream()
					.map(d -> new IoTTracerLogEntity(iotSensor.get().getId(), asset.get().getId(), d.getIdProperty(), d.getPropertyName(), d.getPropertyValue(), request.getDateTime()))
					.collect(Collectors.toList());
				try {
					ioTTracerRepository.saveAll(listEntites);
					logger.info("Recors saved sucessfull");
				}catch (AssetException e) {
					logger.error("has ocurred an error.");
					throw new AssetException(e.getMessage());
				}
			}
		}
	}

	@Override
	public List<IoTTracerLogResponse> findByBetweenDateTime(IoTTracerLogRequest request) throws AssetException {
		List<IoTTracerLogEntity> listEntities = ioTTracerRepository.findAllByIotSensorIdAndAssetIdAndDateTimeGreaterThanEqualAndDateTimeLessThanEqual(request.getIotSensorId(), request.getAssetId(), request.getFromDateTime(), request.getToDateTime());
		try {
			return listEntities.stream().map(e -> e.getResponseDTO()).toList();
		}catch (AssetException e) {
			logger.error("Has ocurred an Error: {}", e.getCause().getMessage());
			throw new AssetException(e.getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	@Override
	public List<IoTTracerLogResponse> findAll() throws AssetException {
		List<IoTTracerLogEntity> listEntities = (List<IoTTracerLogEntity>) ioTTracerRepository.findAll();
		return listEntities.stream().map(e -> e.getResponseDTO()).toList();
	}

}
