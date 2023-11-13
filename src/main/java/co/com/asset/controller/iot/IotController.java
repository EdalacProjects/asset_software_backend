package co.com.asset.controller.iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.asset.model.ResponseAssetEntity;
import co.com.asset.model.request.IoTTracerLogRequest;
import co.com.asset.model.request.IoTTracerLogResponse;
import co.com.asset.service.iot.IoTTracerLogService;
import co.com.asset.util.exception.AssetException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(value = "/asset/iot")
@ApiResponse
public class IotController {

	@Autowired
	private IoTTracerLogService iotService;
	
	@PostMapping
	public void createIoTLog(@RequestBody IoTTracerLogRequest request) {
		System.out.println(request);
		iotService.create(request);
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<ResponseAssetEntity<IoTTracerLogResponse>>  findAll(){
		ResponseAssetEntity<IoTTracerLogResponse> response = new ResponseAssetEntity<>();
		try {
			response.setListData(iotService.findAll());
			response.setResponseCode(HttpStatus.OK);
			return ResponseEntity.ok(response);
		}catch (AssetException e) {
			response.setMsgError(e.getCause().getMessage());
			response.setResponseCode(e.getStatusCode());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}		
	}
	
	@PatchMapping(value = "/findByIotSensorAndAssetAndDatetime")
	public ResponseEntity<ResponseAssetEntity<IoTTracerLogResponse>> findByIotSensorAndAssetAndDatetime(@RequestBody IoTTracerLogRequest request){
		ResponseAssetEntity<IoTTracerLogResponse> response = new ResponseAssetEntity<>();
		try {
			response.setListData(iotService.findByBetweenDateTime(request));
			response.setResponseCode(HttpStatus.OK);
			return ResponseEntity.ok(response);
		}catch (AssetException e) {
			response.setMsgError(e.getCause().getMessage());
			response.setResponseCode(e.getStatusCode());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}		
	}
}
