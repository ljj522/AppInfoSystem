package cn.appsys.dao;

import cn.smbms.pojo.DevUser;
import cn.smbms.pojo.DevUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {
    long countByExample(DevUserExample example);

    int deleteByExample(DevUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    List<DevUser> selectByExample(DevUserExample example);

    DevUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DevUser record, @Param("example") DevUserExample example);

    int updateByExample(@Param("record") DevUser record, @Param("example") DevUserExample example);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}