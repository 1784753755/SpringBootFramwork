package com.controller;

import com.common.SystemOut;
import com.model.Config;
import com.service.ConfigureService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*var data = {
        'title':title,
        'web_name':web_name,
        'web_meta':web_meta,
        'web_description':web_description,
        'ip_list':ip_list,
        'emailname':emailname,
        'emailpwd':emailpwd,
        'emailtype':emailtype,
        'port':port,
        'getemail':getemail,
        'web_code':web_code,
        'Customer_service':Customer_service,
        'Qr_code':Qr_code,
        'web_successcode':web_successcode,
        'check_address':web_check_address,
        'check_postcard':web_check_postcard,
        'line_state':web_line_state,
        'Shipping_costs':Shipping_costs,
        'Large_turntable_state':Large_turntable_state,
        'sms_verification_code':sms_verification_code,
        'model':model
        //先默认在model层进行空处理
          private String priseText;
          private Integer prizeType;
         private String prizeImg;
        };
        */

/*提交上传数据返回json*/
@RestController
public class ConfigController {
    @Autowired
    private ConfigureService configureService;

    @RequestMapping(value = "/addConfig.do", method = RequestMethod.POST)
    public String addConfig(HttpServletRequest request) {
        /*所有的数据库都获取 没记录处理成空串（""|特殊值)*/
        Config config = new Config();
        String title = request.getParameter("title");
        String webName = request.getParameter("web_name");
        String webMeta = request.getParameter("web_meta");
        String webDescription = request.getParameter("web_description");
        String ipList = request.getParameter("ip_list");
        String emailName = request.getParameter("emailname");
        String emailPwd = request.getParameter("emailpwd");
        String emailType = request.getParameter("emailtype");
        String ports = request.getParameter("port");
        Integer port = (ports == null ? null : Integer.valueOf(ports));
        String getEmail = request.getParameter("getemail");
        String webCode = request.getParameter("web_code");
        String customerService = request.getParameter("Customer_service");
        String QrCode = request.getParameter("Qr_code");
        String webSuccessCode = request.getParameter("web_successcode");
        String checkAddressS = request.getParameter("check_address");
        Integer checkAddress = (checkAddressS == null ? null : Integer.valueOf(checkAddressS));
        String checkPostcardS = request.getParameter("check_postcard");
        Integer checkPostcard = (checkPostcardS == null ? null : Integer.valueOf(checkPostcardS));
        String lineStateS = request.getParameter("line_state");
        Integer lineState = (lineStateS == null ? null : Integer.valueOf(lineStateS));
        String shippingCostsS = request.getParameter("Shipping_costs");
        Integer shippingCosts = (shippingCostsS == null ? null : Integer.valueOf(shippingCostsS));
        String largeTurntableStateS = request.getParameter("Large_turntable_state");
        Integer largeTurntableState = (largeTurntableStateS == null ? null : Integer.valueOf(largeTurntableStateS));
        String smsVerificationCode = request.getParameter("sms_verification_code");
        String modelS = request.getParameter("model");
        Integer model = (modelS == null ? null : Integer.valueOf(modelS));

        /*加入config*/
        config.setTitle(title);
        config.setWebName(webName);
        config.setWebMeta(webMeta);
        config.setWebDescription(webDescription);
        config.setIpList(ipList);
        config.setEmailName(emailName);
        config.setEmailPwd(emailPwd);
        config.setEmailType(emailType);
        config.setPort(port);
        config.setGetEmail(getEmail);
        config.setWebCode(webCode);
        config.setCustomerService(customerService);
        config.setQrCode(QrCode);
        config.setWebSuccessCode(webSuccessCode);
        config.setCheckAddress(checkAddress);
        config.setCheckPostcard(checkPostcard);
        config.setLineState(lineState);
        config.setShippingCosts(shippingCosts);
        config.setLargeTurntableState(largeTurntableState);
        config.setSmsVerificationCode(smsVerificationCode);
        config.setModel(model);
        this.configureService.addConfigure(config);
        return "success";
    }
}
