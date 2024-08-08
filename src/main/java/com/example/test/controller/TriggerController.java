package com.example.test.controller;

import com.example.test.producter.service.SendService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/kuhn/rabbitmq")
public class TriggerController {

    private final SendService sendService;

    @GetMapping("/sendMsg/{msg}")
    public String sendMsgToMq(@PathVariable(value = "msg") String msg) {
        sendService.sendMsg(msg);

        return "nb";
    }

}
