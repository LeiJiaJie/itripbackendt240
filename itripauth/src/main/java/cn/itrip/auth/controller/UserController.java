package cn.itrip.auth.controller;

import cn.itrip.auth.service.UserService;
import cn.itrip.search.beans.dto.Dto;
import cn.itrip.search.beans.pojo.ItripUser;
import cn.itrip.search.beans.vo.userinfo.ItripUserVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ErrorCode;
import cn.itrip.common.MD5;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value="邮箱注册用户激活",httpMethod = "PUT",
            protocols = "HTTP",  response = Dto.class,notes="邮箱激活")
    @RequestMapping(value="/activate",method=RequestMethod.PUT)
    @ResponseBody
    public Dto activate(@RequestParam String user,
                        @ApiParam(name="code",value="激活码",defaultValue="018f9a8b2381839ee6f40ab2207c0cfe")
                         @RequestParam String code){
        try {
            if(userService.activate(user, code)) {
                return DtoUtil.returnSuccess("激活成功");
            }else{
                return DtoUtil.returnSuccess("激活失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("激活失败", ErrorCode.AUTH_ACTIVATE_FAILED);
        }
    }

    /**
     * 使用手机注册
     * @param userVO
     */
    @ApiOperation(value="使用手机注册",httpMethod = "POST",
            protocols = "HTTP",  response = Dto.class,notes="使用手机注册 ")
    @RequestMapping(value="/doRegisterByPhone",method= RequestMethod.POST)
    @ResponseBody
    public  Dto doRegisterByPhone(@RequestBody ItripUserVO userVO) {
        //1、手机号格式验证
        if (!this.validPhone(userVO.getUserCode())) {
            return DtoUtil.returnFail("请使用正确的手机号码！",ErrorCode.AUTH_ILLEGAL_USERCODE);
        }
        //2、调用Service层新增用户的方法
        try {
            ItripUser user=new ItripUser();
            user.setUserCode(userVO.getUserCode());
            user.setUserPassword(userVO.getUserPassword());
            user.setUserType(0);
            user.setUserName(userVO.getUserName());
            if (null == userService.findByUsername(user.getUserCode())) {
                user.setUserPassword(MD5.getMd5(user.getUserPassword(), 32));
                userService.insertUserByPhone(user);
                return DtoUtil.returnSuccess();
            } else {
                return DtoUtil.returnFail("用户已存在，注册失败", ErrorCode.AUTH_USER_ALREADY_EXISTS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(), ErrorCode.AUTH_UNKNOWN);
        }
    }

    /**
     * 验证手机号码的格式是否正确
     * @param phone 手机号码
     * @return 返回true表示手机号码验证通过。否则返回false
     */
    public boolean validPhone(String phone) {
        String regex = "^1[34578]{1}\\d{9}$";
        return Pattern.compile(regex).matcher(phone).find();
    }

    @ApiOperation(value="手机注册用户激活",httpMethod = "PUT",
            protocols = "HTTP",  response = Dto.class,notes="手机注册用户激活")
    @RequestMapping(value="/activateByPhone",method=RequestMethod.PUT)
    @ResponseBody
    public Dto activateByPhone(
            @ApiParam(name="user",value="手机号码")@RequestParam String user,
            @ApiParam(name="code",value="激活码")  @RequestParam String code){
        try {
            if(userService.validatePhone(user, code)) {
                return DtoUtil.returnSuccess("激活成功");
            }else{
                return DtoUtil.returnSuccess("激活失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("激活失败", ErrorCode.AUTH_ACTIVATE_FAILED);
        }
    }



}
