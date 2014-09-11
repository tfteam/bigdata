package com.springapp.mvc;

import com.bigdata.entity.ResultBase;
import com.bigdata.entity.UserBehaviorDO;
import com.bigdata.service.UserBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    private UserBehaviorService userBehaviorService;

	@RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        UserBehaviorDO userBehaviorDO = new UserBehaviorDO();
        userBehaviorDO.setUserId(121L);
       /* userBehaviorDO.setBrandId(111L);
        userBehaviorDO.setType(1);*/
        //userBehaviorDO.setVisitDatetime(DateUtil.strToTimestamp("2014-01-01"));
        ResultBase<?> result =  userBehaviorService.insertOneUserBehaviors(userBehaviorDO);
        System.out.println(result.getErrorMsg());
        System.out.println(result.isSuccess());
        return "hello";
    }
}