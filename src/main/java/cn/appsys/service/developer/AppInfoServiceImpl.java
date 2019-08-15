package cn.appsys.service.developer;

import cn.appsys.dao.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppInfoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Override
    public PageInfo<AppInfo> getAppInfoList(String softwareName, Long status,
                                        Long categoryLevel1, Long categoryLevel2,
                                        Long categoryLevel3, Long flatformId,
                                        Long devId, Integer currentPageNo, Integer pageSize) {
        //启用分页
        PageInfo<AppInfo> pageInfo = null;
        PageHelper.startPage(currentPageNo,pageSize);
        AppInfoExample example = new AppInfoExample();
        //设置查询条件
        AppInfoExample.Criteria criteria = example.createCriteria();
        if (null != softwareName && "" != softwareName){
            criteria.andSoftwareNameLike("%"+softwareName+"%");
        }
        if (null != status && 0 != status){
            criteria.andStatusEqualTo(status);
        }
        if (null != flatformId && 0 != flatformId){
            criteria.andFlatformIdEqualTo(flatformId);
        }
        if (null != categoryLevel1 && 0 != categoryLevel1){
            criteria.andCategoryLevel1EqualTo(categoryLevel1);
            if (null != categoryLevel2 && 0 != categoryLevel2){
                criteria.andCategoryLevel1EqualTo(categoryLevel2);
                if (null != categoryLevel3 && 0 != categoryLevel3){
                    criteria.andCategoryLevel1EqualTo(categoryLevel3);
                }
            }
        }
        //执行查询
        List<AppInfo> list = appInfoMapper.selectByExample(example);
        //获取分页信息
        pageInfo = new PageInfo<AppInfo>(list);
        return pageInfo;
    }
}
