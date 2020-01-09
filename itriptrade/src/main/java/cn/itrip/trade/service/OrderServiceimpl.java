package cn.itrip.trade.service;

import cn.itrip.search.beans.pojo.ItripHotelOrder;
import cn.itrip.search.dao.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("OrderService")
public class OrderServiceimpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Override
    public ItripHotelOrder loadItripHotelOrder(String orderNo) {
        return orderMapper.getItripHotelOrder(orderNo);
    }

    @Override
    public boolean processed(String out_trade_no) {
        return orderMapper.getItripHotelOrder(out_trade_no)==null?true:false;
    }

    @Override
    public int paySuccess(String out_trade_no, int no, String trade_no) {
        return orderMapper.updateItripHotelOrder(out_trade_no,no,trade_no);
    }
}
