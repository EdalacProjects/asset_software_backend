package co.com.asset.service.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.asset.model.dto.UserDTO;
import co.com.asset.model.entity.UserEntity;
import co.com.asset.model.mapper.UserMapper;
import co.com.asset.repository.UserRepository;
import co.com.asset.util.exception.AssetException;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void create(UserDTO userDto) throws AssetException {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDTO findById(Long id) throws AssetException {
		Optional<UserEntity> user = userRepository.findById(id);
		if(user.isPresent()) {
			return userMapper.mapperEntityToDTO(user.get());
		}
		throw new AssetException("Records not found");
	}

	@Override
	public List<UserDTO> findAll() throws AssetException {
		List<UserEntity> list = (List<UserEntity>)userRepository.findAll();		
		return list.stream().map(u -> userMapper.mapperEntityToDTO(u)).collect(Collectors.toList());
	}

}
