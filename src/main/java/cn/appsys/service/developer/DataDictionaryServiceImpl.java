package cn.appsys.service.developer;

import cn.appsys.dao.DataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DataDictionaryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getDataDictionaryList(String typeCode) {
        DataDictionaryExample example = new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = example.createCriteria();
        if (null != typeCode && "" != typeCode){
            criteria.andTypeCodeEqualTo(typeCode);
        }
        return dataDictionaryMapper.selectByExample(example);
    }
}
