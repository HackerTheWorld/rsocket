package com.rsocket.controller;

import reactor.core.publisher.FluxSink;


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

