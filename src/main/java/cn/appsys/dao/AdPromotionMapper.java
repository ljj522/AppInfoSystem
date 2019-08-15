package cn.appsys.dao;

import java.util.List;

import cn.appsys.pojo.AdPromotion;
import cn.appsys.pojo.AdPromotionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdPromotionMapper {
    long countByExample(AdPromotionExample example);

    int deleteByExample(AdPromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdPromotion record);

    int insertSelective(AdPromotion record);

    List<AdPromotion> selectByExample(AdPromotionExample example);

    AdPromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdPromotion record, @Param("example") AdPromotionExample example);

    int updateByExample(@Param("record") AdPromotion record, @Param("example") AdPromotionExample example);

    int updateByPrimaryKeySelective(AdPromotion record);

    int updateByPrimaryKey(AdPromotion record);
}