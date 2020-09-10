package prilax.yk.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prilax.yk.dao.common.CommonDao;
import prilax.yk.vo.common.Filter;

@SuppressWarnings("unchecked")
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDao commonDao;

    @Override
    public <T> T save(Object entity) {
        return (T) commonDao.save(entity);
    }

    @Override
    public void delete(Object entity) {
        commonDao.delete(entity);
    }

    @Override
    public <T> T findById(Object id, Class<?> clazz) {
        return (T) commonDao.findById(id, clazz);
    }

    @Override
    public <T> T findOne(List<Filter> filters, Class<?> clazz) {
        return (T) commonDao.findOne(filters, clazz);
    }

    @Override
    public <T> List<T> findAll(Class<?> clazz) {
        return (List<T>) commonDao.findAll(clazz);
    }

    @Override
    public <T> List<T> find(List<Filter> filters, Class<?> clazz) {
        return (List<T>) commonDao.find(filters, clazz);
    }

}
