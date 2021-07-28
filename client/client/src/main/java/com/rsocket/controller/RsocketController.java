package com.rsocket.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rsocket.vo.MessageVo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class RsocketController {

    /**
     * request response
     * @param marketData
     * @return
     */
    @MessageMapping("/requestResponse")
    public Mono<JSONPObject> getInfor(String marketData){
        JSONPObject jsonpObject = null;
        return Mono.just(jsonpObject);
    }

    /**
     * Fire And Forget
     * @param marketData
     * @return
     */
    @MessageMapping("/fireAndForget")
    public void collectMarketData(String marketData) {
        System.out.println(marketData);
    }

    /**
     * Request Stream
     * @param request
     * @return
     */
    @MessageMapping("stream")
    Flux<String> stream(String request) {
        System.out.println(request);

        return Flux
            .create(e -> {
                new Thread(new RunableInter(e)).start();
            }).map(index -> index+request);
    }

    /**
     * Request channel
     * @param settings
     * @return
     */
    @MessageMapping("channel")
    Flux<MessageVo> channel(final Flux<String> settings) {
        return Flux.create(e -> {
            settings.subscribe(str -> {
                MessageVo messageVo = new MessageVo();
                messageVo.setFrom("server");
                messageVo.setMessage(str+"::server");
                messageVo.setTo("client");
                e.next(messageVo);
                e.complete();
            });
        });
    }

}

