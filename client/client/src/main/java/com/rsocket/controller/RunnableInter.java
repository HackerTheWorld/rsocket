package com.rsocket.controller;

import reactor.core.publisher.FluxSink;


public class RunnableInter implements Runnable{

    private FluxSink fluxSink;

    public RunnableInter(FluxSink fluxSink){
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
            fluxSink.next(i+++"test");
        }

    }
}

