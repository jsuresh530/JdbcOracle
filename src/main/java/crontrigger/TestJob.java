package crontrigger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJob implements Job {

	private static Logger LOGGER = LoggerFactory.getLogger(TestJob.class);

   public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {
	   LOGGER.debug("TestJob run successfully");
   }

}
