package cn.appsys.service.developer;

import cn.appsys.dao.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

    @Autowired
    private AppCategoryMapper appCategoryMapper;

    @Override
    public List<AppCategory> getAppCategoryListByParentId(Long parentId) {
        AppCategoryExample example = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = example.createCriteria();
        if (null == parentId){
            criteria.andParentIdIsNull();
            return appCategoryMapper.selectByExample(example);
        }
        criteria.andParentIdEqualTo(parentId);
        return appCategoryMapper.selectByExample(example);
    }
}
