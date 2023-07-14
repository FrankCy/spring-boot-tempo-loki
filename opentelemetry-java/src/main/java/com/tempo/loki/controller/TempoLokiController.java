package com.tempo.loki.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TempoLokiController
 * @Description TODO
 * @Author cy
 * @Date 2023/7/14 6:12 下午
 * @Version 1.0
 **/
@Slf4j
@Controller
@RequestMapping("/api/v1")
public class TempoLokiController {

    @GetMapping(value = "/hello")
    @ResponseBody
    public String tracking() {
        log.info("--------- Hello API V1 ----------");
        return "SUCCESS";
    }

}