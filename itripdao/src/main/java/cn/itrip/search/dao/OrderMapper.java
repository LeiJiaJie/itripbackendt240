package cn.itrip.search.dao;

import cn.itrip.search.beans.pojo.ItripHotelOrder;
import cn.itrip.search.beans.pojo.ItripUser;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    public ItripHotelOrder getItripHotelOrder(String orderNo);

    public int updateItripHotelOrder(String orderNo,int orderStatus,String tradeNo);
}
