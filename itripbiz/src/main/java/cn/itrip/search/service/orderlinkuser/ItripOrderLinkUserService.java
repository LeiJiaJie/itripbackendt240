package cn.itrip.search.service.orderlinkuser;
import cn.itrip.search.beans.pojo.ItripOrderLinkUser;
import java.util.List;
import java.util.Map;

import cn.itrip.search.beans.vo.order.ItripOrderLinkUserVo;

/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripOrderLinkUserService {

    public ItripOrderLinkUser getItripOrderLinkUserById(Long id)throws Exception;

    public List<ItripOrderLinkUserVo>	getItripOrderLinkUserListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripOrderLinkUserCountByMap(Map<String, Object> param)throws Exception;

    public Integer itriptxAddItripOrderLinkUser(ItripOrderLinkUser itripOrderLinkUser)throws Exception;

    public Integer itriptxModifyItripOrderLinkUser(ItripOrderLinkUser itripOrderLinkUser)throws Exception;

    public Integer itriptxDeleteItripOrderLinkUserById(Long id)throws Exception;

    /**
     * 查询所有未支付的订单所关联的所有常用联系人
     * @return
     * @throws Exception
     */
    public List<Long> getItripOrderLinkUserIdsByOrder() throws Exception;
}
