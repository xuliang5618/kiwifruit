package sdu.gaming.kiwifruit.controller.user;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sdu.gaming.kiwifruit.common.domain.ControllerResponse;
import sdu.gaming.kiwifruit.service.common.constant.ResponseCode;
import sdu.gaming.melon.api.IAccountService;
import sdu.gaming.melon.api.domain.AuthenticateRequest;
import sdu.gaming.melon.api.domain.AuthenticateResponse;
import sdu.gaming.melon.api.domain.RegisterRequest;
import sdu.gaming.melon.api.domain.RegisterResponse;

/**
 * @author xuliang
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    public static Logger log = LogManager.getLogger(UserController.class.getName());

    @Autowired
    private IAccountService accountService;

    /**
     * 入口页面
     *
     * @param
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/user/login";
    }


    /**
     * 注册入口页面
     *
     * @param
     * @return
     */
    @RequestMapping("/registerIndex")
    public String registerIndex() {
        return "/user/register";
    }

    /**
     * 登录验证,这里仅支持accountNumber
     *
     * @param
     * @return
     */
    @RequestMapping("/auth")
    @ResponseBody
    public JSONObject auth(String name, String password) {
        ControllerResponse result = new ControllerResponse();
        try {
            Long accountNum = Long.parseLong(name);
            AuthenticateRequest authenticateRequest = new AuthenticateRequest();
            authenticateRequest.setAccountNum(accountNum);
            AuthenticateResponse authenticateResponse = accountService.authenticate(authenticateRequest);
            result.setErrCode(authenticateResponse.getResponseCode());
            result.setMsg(authenticateResponse.getResponseMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setErrCode(ResponseCode.UNKNOWN_ERROR);
            return result.toJSONObject();
        }
        return result.toJSONObject();
    }

    /**
     * 注册入口页面
     *
     * @param
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public JSONObject register(String name, String phone, String email, String password) {
        ControllerResponse result = new ControllerResponse();
        try {
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setAccountName(name);
            registerRequest.setEmail(email);
            registerRequest.setPhone(phone);
            registerRequest.setPassword(password);
            RegisterResponse registerResponse = accountService.register(registerRequest);
            result.setResponse(registerResponse);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setErrCode(ResponseCode.UNKNOWN_ERROR);
            return result.toJSONObject();
        }
        return result.toJSONObject();
    }

    @RequestMapping("/authTest")
    public String authTest(ModelMap modelMap) {
        // Account userInfo = accountService.authenticate((long) 1, "123456");
        //   modelMap.addAttribute("account", userInfo);
        return "/demo/showInfo";
    }

    @RequestMapping("/listTest")
    public String registerTest(ModelMap modelMap) {
        return "/user/login";
    }

    @RequestMapping("/insertTest")
    public String showInfo(ModelMap modelMap) {
        return "/demo/insert";
    }

    @RequestMapping("/queryAccount")
    @ResponseBody
    public JSONObject queryAccount(String accountName, String phone, String email) {
        JSONObject result = new JSONObject();
        Boolean exist = accountService.queryAccountExist(accountName, phone, email, null);
        result.put("exist", exist);
        return result;
    }
}
