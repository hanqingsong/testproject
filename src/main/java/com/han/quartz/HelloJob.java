package com.han.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by hanqingsong on 17/7/28.
 */
public class HelloJob implements Job {

    public HelloJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException
    {
        System.err.println("Hello!  HelloJob is executing.");
        System.out.println("Hello!  HelloJob is executing.");
    }
}
