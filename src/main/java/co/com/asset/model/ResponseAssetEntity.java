package co.com.asset.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseAssetEntity<T extends AbstractResponseEntity> {

	private HttpStatus responseCode;
	private String msgError;
	T data;
	List<T> listData;
	
}
