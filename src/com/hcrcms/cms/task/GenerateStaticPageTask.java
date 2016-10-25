package com.hcrcms.cms.task;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcrcms.cms.task.job.GenerateStaticPageJob;

public class GenerateStaticPageTask {

	public void generateStaticPage(){
		try {
			JobDetail jobDetail = new JobDetail();
			//设置任务名称
			jobDetail.setName("generateStaticPageTask");
			jobDetail.setGroup(Scheduler.DEFAULT_GROUP);
			//设置任务执行类
			jobDetail.setJobClass(GenerateStaticPageJob.class);
			CronTrigger cronTrigger = new CronTrigger("page_",Scheduler.DEFAULT_GROUP, jobDetail.getName(),Scheduler.DEFAULT_GROUP);
			//设置任务规则
			cronTrigger.setCronExpression("0 0/10 * * * ?");
			//cronTrigger.setCronExpression("0 0/5 * * * ?");
			//调度任务
			scheduler.scheduleJob(jobDetail, cronTrigger); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private Scheduler scheduler;
}
