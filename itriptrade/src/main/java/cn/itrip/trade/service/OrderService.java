package cn.itrip.trade.service;

import cn.itrip.search.beans.pojo.ItripHotelOrder;

public interface OrderService {
    public ItripHotelOrder loadItripHotelOrder(String orderNo);

    public boolean processed(String out_trade_no);

    public int paySuccess(String out_trade_no, int no, String trade_no);
}
