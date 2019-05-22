package com.rong360.testapp.controller;

import io.github.pactstart.commonutils.JsonUtils;
import io.github.pactstart.rong360.push.bean.OrderBean;
import io.github.pactstart.rong360.push.dto.ResultDto;
import io.github.pactstart.rong360.push.form.UnifiedForm;
import io.github.pactstart.rong360.push.service.PushHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/rong360")
public class Rong360Controller {

    @Autowired
    private PushHandleService pushHandleService;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PostMapping("/pushOrder.json")
    public String pushOrder(@Valid @RequestBody UnifiedForm unifiedForm, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        OrderBean orderBean = JsonUtils.string2Obj(unifiedForm.getBiz_data(), OrderBean.class);
        ResultDto resultDto = pushHandleService.handleOrderBaseInfoPush(orderBean);
        return resultDto.toString();
    }
}
