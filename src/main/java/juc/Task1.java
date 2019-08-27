package juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public  class Task1 implements Callable {
        @Override
        public Object call() throws Exception {
            log.info("Task1 休眠开始");
            Thread.sleep(2000);
            log.info("Task1 休眠结束");
            return "task1";
        }
    }