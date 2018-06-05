package com.leslia.inter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.leslia.activemq.QueueSender;
import com.leslia.activemq.TopicSender;
import com.leslia.inter.api.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/MQ")
public class MessageController {

    @Reference
    private MessageService messageService;

    @Resource
    private QueueSender queueSender;

    @Resource
    private TopicSender topicSender;

    @RequestMapping("/sendQueue")
    @ResponseBody
    public void sendQueue(){
        messageService.sendQueue();
    }

    @RequestMapping("/sendTopic")
    @ResponseBody
    public void sendTopic(){
        messageService.sendTopic();
    }

    @RequestMapping("/sendQueueRest")
    @ResponseBody
    public void sendQueueRest(){
        queueSender.send("rest.queue","message send in rest");
    }

    @RequestMapping("/sendTopicRest")
    @ResponseBody
    public void sendTopicRest(){
        topicSender.send("rest.topic","message send in rest ");
    }


}