/* ====================================================================================================
 * Project Name     [rsocket]
 * File Name        [com.rsocket.controller.RunableInter.java]
 * Creation Date    [2021-07-24]
 *
 * Copyright© 2021 瑞声科技[AAC Technologies Holdings] All Rights Reserved
 *
 * ====================================================================================================
 * Change Log
 * ====================================================================================================
 * 2021-07-24     潘凌云      [Init] .
 * ==================================================================================================== */
package com.rsocket.controller;

import reactor.core.publisher.FluxSink;

/**
 * <p></p>
 *
 * @author <a href="mailto:panlingyun@aactechnologies.com">潘凌云</a>
 * @version 1.0.0
 * @since jdk 1.8
 */
public class RunableInter  implements Runnable{

    private FluxSink fluxSink;

    public RunableInter(FluxSink fluxSink){
        this.fluxSink = fluxSink;
    }

    @Override
    public void run() {
        int i =0;
        while (true){
            fluxSink.next(i+++"test");
        }

    }
}

