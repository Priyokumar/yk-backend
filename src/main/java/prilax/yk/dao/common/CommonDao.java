package prilax.yk.dao.common;

import prilax.yk.vo.common.Filter;

import java.util.List;


public interface CommonDao {

	public Object findById(Object id, Class<?> clazz);

	public Object findOne(List<Filter> filters, Class<?> clazz);

	public Object findAll(Class<?> clazz);

	public Object find(List<Filter> filters, Class<?> clazz);

	public Object save(Object entity);

	public void delete(Object entity);

}
