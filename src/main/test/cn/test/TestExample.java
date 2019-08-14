package cn.test;

import cn.appsys.dao.InfoMapper;
import cn.appsys.pojo.Info;
import cn.appsys.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.List;

public class TestExample {
    SqlSession session;



    @Test
    public void test2(){
        //添加用户
        session = MyBatisUtils.openSession();
        InfoMapper mapper = session.getMapper(InfoMapper.class);
        //实例化用户对象
        Info info = new Info();
        info.setAppinfo("dasda");
        int rows = mapper.insert(info);
        session.commit();
        System.out.println(rows==1?"添加用户成功！":"添加失败！");
    }

}
