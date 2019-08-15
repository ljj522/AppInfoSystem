package cn.appsys.service.developer;

import cn.appsys.pojo.AppInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AppInfoService {

    /**
     * 根据条件查询出app列表
     * @param softwareName
     * @param status
     * @param categoryLevel1
     * @param categoryLevel2
     * @param categoryLevel3
     * @param flatformId
     * @param devId
     * @param currentPageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageInfo<AppInfo> getAppInfoList(String softwareName, Long status,
                                            Long categoryLevel1, Long categoryLevel2,
                                            Long categoryLevel3, Long flatformId,
                                            Long devId, Integer currentPageNo, Integer pageSize);
}
