package co.com.asset.service.user;

import java.util.List;

import co.com.asset.model.dto.UserDTO;
import co.com.asset.util.exception.AssetException;

public interface UserService {

	void create(UserDTO userDto) throws AssetException;
	
	UserDTO findById(Long id) throws AssetException;
	
	List<UserDTO> findAll() throws AssetException;
}
