package com.gundi.crypto.ticker;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by pai on 27.03.18.
 */
public class TickerCaptureScheduler {

    public static  void main(String args[]) {
        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = null;
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        // and start it off
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


        // define the job and tie it to our TickerCaptureJob class
        JobDetail job = newJob(TickerCaptureJob.class)
                .withIdentity("TickerCaptureJob", "Gundi")
                .build();

        // Trigger the job to run now, and then repeat every 60 seconds
        Trigger trigger = newTrigger()
                .withIdentity("TickerCaptureTrigger", "Gundi")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(60)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        try {
            scheduler.scheduleJob(job, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }


}
