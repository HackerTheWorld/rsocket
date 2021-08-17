/* ====================================================================================================
 * Project Name     [rsocket]
 * File Name        [com.rsocket.controller.RunableInterMessage.java]
 * Creation Date    [2021-08-17]
 *
 * Copyright© 2021 瑞声科技[AAC Technologies Holdings] All Rights Reserved
 *
 * ====================================================================================================
 * Change Log
 * ====================================================================================================
 * 2021-08-17     潘凌云      [Init] .
 * ==================================================================================================== */
package com.rsocket.controller;

import com.rsocket.vo.MessageVo;
import reactor.core.publisher.FluxSink;

/**
 * <p></p>
 *
 * @author <a href="mailto:panlingyun@aactechnologies.com">潘凌云</a>
 * @version 1.0.0
 * @since jdk 1.8
 */
public class RunnableInterMessage implements Runnable{

    private FluxSink fluxSink;

    public RunnableInterMessage(FluxSink fluxSink){
        this.fluxSink = fluxSink;
    }

    @Override
    public void run() {
        int i =0;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MessageVo messageVo = new MessageVo("rsocket","webFlux",i+++"test");
            fluxSink.next(messageVo);
        }
    }
}

