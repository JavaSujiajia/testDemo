package com.huare.demo.controller;

import com.alibaba.fastjson.JSON;
import com.huare.demo.args.UserArgs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件描述
 *
 * @author sujia
 * @date 2020年12月10日 15:42
 */
@RestController
@RequestMapping("sendMessage")
@Api(value = "消息队列测试-sendMessageController")
public class SendMessageController {

    protected static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @ApiOperation("消息推送测试")
    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(String messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
        //String messageData = "test message, hello!~.~!"+messageId;
        System.out.println("this is messageData :" + messageData);
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "ok";
    }

    @ApiOperation("消息推送测试1")
    @GetMapping("/sendTopicMessage1")
    public String sendTopicMessage1(String messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> manMap = new HashMap<>();
        manMap.put("messageId", messageId);
        manMap.put("messageData", messageData);
        manMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return "ok";
    }

    /**
     * 测试消息队列推送,参考消费者的匹配字符
     * @param messageData
     * @return
     */
    @ApiOperation("消息推送测试2")
    @GetMapping("/sendTopicMessage2")
    public String sendTopicMessage2(String messageData) {
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> womanMap = new HashMap<>();
        womanMap.put("messageId", messageId);
        womanMap.put("messageData", messageData);
        womanMap.put("createTime", createTime);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", womanMap);
        return "ok";
    }

    /**
     * 未调试
     * @param userArgs
     * @return
     */
    @ApiOperation("消息队列保存User数据")
    @PostMapping("/sendUserDataSave")
    public String sendUserDataSave(@RequestBody UserArgs userArgs){
        logger.info("当前访问参数："+ JSON.toJSONString(userArgs));
        Map<String, Object> saveUserMap = new HashMap<>();
        saveUserMap.put("messageId", String.valueOf(UUID.randomUUID()));
        saveUserMap.put("messageData", JSON.toJSONString(userArgs));
        saveUserMap.put("createTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        rabbitTemplate.convertAndSend("topicExchange", "topic.saveUser",saveUserMap);
        return "OK";
    }


}
