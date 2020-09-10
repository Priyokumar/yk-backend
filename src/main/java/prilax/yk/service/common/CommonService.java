package prilax.yk.service.common;

import prilax.yk.vo.common.Filter;

import java.util.List;


public interface CommonService {

	public <T> T findById(Object id, Class<?> clazz);

	public <T> T findOne(List<Filter> filters, Class<?> clazz);

	public <T> List<T> findAll(Class<?> clazz);

	public <T> List<T> find(List<Filter> filters, Class<?> clazz);

	public <T> T save(Object entity);

	public void delete(Object entity);

}
