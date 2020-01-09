package cn.itrip.search.service.hotelextendproperty;
import cn.itrip.search.beans.pojo.ItripHotelExtendProperty;
import cn.itrip.common.Page;

import java.util.List;
import java.util.Map;

/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelExtendPropertyService {

    public ItripHotelExtendProperty getItripHotelExtendPropertyById(Long id)throws Exception;

    public List<ItripHotelExtendProperty>	getItripHotelExtendPropertyListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripHotelExtendPropertyCountByMap(Map<String, Object> param)throws Exception;

    public Integer itriptxAddItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty)throws Exception;

    public Integer itriptxModifyItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty)throws Exception;

    public Integer itriptxDeleteItripHotelExtendPropertyById(Long id)throws Exception;

    public Page<ItripHotelExtendProperty> queryItripHotelExtendPropertyPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;
}
