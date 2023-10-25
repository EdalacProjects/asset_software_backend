package co.com.asset.service.iot;

import java.util.List;

import co.com.asset.model.request.IoTTracerLogRequest;
import co.com.asset.model.request.IoTTracerLogResponse;
import co.com.asset.util.exception.AssetException;

public interface IoTTracerLogService {

	void create(IoTTracerLogRequest request) throws AssetException;
	
	List<IoTTracerLogResponse> findByBetweenDateTime(IoTTracerLogRequest request) throws AssetException;
	
	List<IoTTracerLogResponse> findAll() throws AssetException;
}
