package cn.appsys.controller.developer;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.AppCategoryService;
import cn.appsys.service.developer.AppInfoService;
import cn.appsys.service.developer.DataDictionaryService;
import cn.appsys.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dev/flatform/app")
public class AppController {

    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @Value("${currentPageNo}")
    private String currentPageNo;
    @Value("${pageSize}")
    private String pageSize;

    @RequestMapping("/list")
    public String getAppInfoList(Model model, HttpSession session,
                                 @RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
                                 @RequestParam(value="queryStatus",required=false) Long queryStatus,
                                 @RequestParam(value="queryCategoryLevel1",required=false) Long queryCategoryLevel1,
                                 @RequestParam(value="queryCategoryLevel2",required=false) Long queryCategoryLevel2,
                                 @RequestParam(value="queryCategoryLevel3",required=false) Long queryCategoryLevel3,
                                 @RequestParam(value="queryFlatformId",required=false) Long queryFlatformId,
                                 @RequestParam(value="pageIndex",required=false) Long pageIndex){
        this.currentPageNo = (currentPageNo==null || currentPageNo == "")?this.currentPageNo:currentPageNo;
        this.pageSize = (pageSize==null || pageSize == "0")?this.pageSize:pageSize;
        Long devId = ((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId();
        List<DataDictionary> statusList = dataDictionaryService.getDataDictionaryList("APP_STATUS");
        List<DataDictionary> flatFormList = dataDictionaryService.getDataDictionaryList("APP_FLATFORM");
        //列出一级分类列表，注：二级和三级分类列表通过异步ajax获取
        List<AppCategory> categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
        List<AppCategory> categoryLevel2List = appCategoryService.getAppCategoryListByParentId(1l);
        List<AppCategory> categoryLevel3List = appCategoryService.getAppCategoryListByParentId(2l);
        model.addAttribute("categoryLevel1List",categoryLevel1List);
        model.addAttribute("categoryLevel2List",categoryLevel2List);
        model.addAttribute("categoryLevel3List",categoryLevel3List);
        model.addAttribute("statusList",statusList);
        model.addAttribute("flatFormList",flatFormList);

        PageInfo<AppInfo> pageInfo = appInfoService.getAppInfoList(querySoftwareName,queryStatus,queryCategoryLevel1,
                queryCategoryLevel2,queryCategoryLevel3,queryFlatformId,pageIndex,Integer.parseInt(this.currentPageNo),Integer.parseInt(this.pageSize));
        model.addAttribute("pageInfo",pageInfo);


        return "jsp/developer/appinfolist";
    }
}
