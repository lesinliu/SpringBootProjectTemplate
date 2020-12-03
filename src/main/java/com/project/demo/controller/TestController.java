package com.project.demo.controller;

import com.project.demo.result.Result;
import com.project.demo.result.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api("测试")
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private RedisTemplate<String, String> redisTemplate;


    @ApiOperation(value = "测试接口")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功"))
    @RequestMapping(value = "testget", method = RequestMethod.GET)
    public Result<String> testGetRequest(String name, String age){
        logger.debug("=====>测试日志debug级别打印<====");
        logger.info("=====>测试日志info级别打印<=====");
        logger.error("=====>测试日志error级别打印<====");
        logger.warn("=====>测试日志warn级别打印<=====");
        redisTemplate.opsForValue().set("test", "1122312");
        return ResultGenerator.genSuccessResult(redisTemplate.opsForValue().get("test"));
    }
    @RequestMapping(value = "testpost", method = RequestMethod.POST)
    public String testPostRequest(){
        return "456";
    }
}
