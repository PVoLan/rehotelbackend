package com.example.demo.controllers.tools;

import com.example.demo.usecases.HelloControllerUC;
import org.slf4j.Logger;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.function.Function;

public class RequestRunner<TResult> {

    private Logger logger;

    public RequestRunner(Logger logger) {
        this.logger = logger;
    }

    public DeferredResult<TResult> run(RequestAction<TResult> action){

        logger.info("*****************Request*******************");

        DeferredResult<TResult> deferredResult = new DeferredResult<>();

        new Thread(new Runnable() {
            @Override
            public void run() {

                logger.info("*******Call*****");

                try {
                    TResult response = action.run();
                    deferredResult.setResult(response);
                    logger.info("*******Call done*****");
                } catch (Exception e) {
                    logger.error("*******Call failed*****", e);
                    deferredResult.setErrorResult(e);
                }


            }
        }).start();

        logger.info("*****************Request done*******************");

        return deferredResult;
    }



}
