package cn.appsys.dao;

import java.util.List;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.BackendUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BackendUserMapper {
    long countByExample(BackendUserExample example);

    int deleteByExample(BackendUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    List<BackendUser> selectByExample(BackendUserExample example);

    BackendUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BackendUser record, @Param("example") BackendUserExample example);

    int updateByExample(@Param("record") BackendUser record, @Param("example") BackendUserExample example);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
}