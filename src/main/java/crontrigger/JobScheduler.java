package crontrigger;

import java.text.ParseException;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
/**
* @author onlinetechvision.com
* @since 17 Sept 2011
* @version 1.0.0
*
*/
public class JobScheduler {

   public static void main(String[] args) throws ParseException, SchedulerException {

      /*try {

         // specify the job' s details..
    	// specify the job' s details..
    	  JobDetail  job = JobBuilder.newJob(TestJob.class).withIdentity("testJob").build();
         // specify the running period of the job
         Trigger trigger = TriggerBuilder.newTrigger()
                                         .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                                                            .withIntervalInSeconds(30)
                                                                            .repeatForever())
                                          .build();
         
      // CronTrigger the job to run on the every 20 seconds
         CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                                      .withIdentity("crontrigger","crontriggergroup1")
                                      .withSchedule(CronScheduleBuilder.cronSchedule("10 * * * * ?"))
                                      .build();

         //schedule the job
         SchedulerFactory schFactory = new StdSchedulerFactory();
         Scheduler sch = schFactory.getScheduler();
         sch.start();
         sch.scheduleJob(job, cronTrigger);

      } catch (SchedulerException e) {
         e.printStackTrace();
      }*/
	   
	   
	   JobDetail job = JobBuilder.newJob(TestJob.class)
				.withIdentity("dummyJobName", "group1").build();

	  // SimpleTrigger – Allows to set start time, end time, repeat interval.
	  // CronTrigger – Allows Unix cron expression to specify the dates and times to run your job.
			//Quartz 1.6.3
		    	//CronTrigger trigger = new CronTrigger();
		    	//trigger.setName("dummyTriggerName");
		    	//trigger.setCronExpression("0/5 * * * * ?");

		    	/*Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("dummyTriggerName", "group1")
				.withSchedule(
					CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
				.build();*/
		    	
		    	
		    	Trigger trigger = TriggerBuilder
		    			.newTrigger()
		    			.withIdentity("dummyTriggerName", "group1")
		    			.withSchedule(
		    			    SimpleScheduleBuilder.simpleSchedule()
		    				.withIntervalInSeconds(5).repeatForever())
		    			.build();
		    	
		    	//schedule it
		    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		    	System.out.println("schedular statrted...");
		    	
		    	scheduler.start();
		    	
		    		ReadFile instance = ReadFile.getInstance();
		    		//System.out.println("instance "+instance.properties.getProperty("user"));
		    	new Thread(instance).start();
		 	   //System.out.println("fdgdf::: "+instance.properties.getProperty("password"));
		 	   
		    	scheduler.scheduleJob(job, trigger);
   }

}