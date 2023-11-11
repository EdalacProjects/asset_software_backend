package co.com.asset.model.mapper;

public interface AbstractMapper<T, R> {

	T mapperDtoToEntity(R dto);
	
	R mapperEntityToDTO(T entity);
}
