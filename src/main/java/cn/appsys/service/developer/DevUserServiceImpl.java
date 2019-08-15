package cn.appsys.service.developer;

import cn.appsys.dao.DevUserMapper;
import cn.appsys.pojo.DevUser;
import cn.appsys.pojo.DevUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    @Override
    public DevUser login(String devCode, String devPassword) throws Exception {

        //创建example对象
        DevUserExample example = new DevUserExample();
        //添加查询条件
        example.createCriteria().andDevCodeEqualTo(devCode);
        List<DevUser> list = devUserMapper.selectByExample(example);
        //匹配密码
        //验证用户名是否正确
        if(null!=list && list.size()>0){
            DevUser devUser= list.get(0);
            //用户名正确、验证密码是否正确
            if(list.get(0).getDevPassword().equals(devPassword)){
                //验证通过，返回user
                return devUser;
            }
        }
        return null;
    }
}
