package wzn.text.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
/**
 * 定时任务测试
 * @author wzn
 *
 */
@Configuration
//@EnableScheduling 关闭定时
public class dingshiqi {
	/**
	 * Cron 参数详解：
	*	 按顺序依次为
	*	1  秒（0~59）
	*	2  分钟（0~59）
	*	3     小时（0~23）
	*	4  天（0~31）
	*	5 月（0~11）
	*	6  星期（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
	*	7.年份（1970－2099）
	*	0 0 12 ? * WED 表示每个星期三中午12点
	*	0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
	*	fixedDelay 参数：在固定时间后执行 Long类型 单位毫秒 (上次结束时间---下次开始时间)
	*	fixedDelayString 在固定时间后执行 string类型 单位毫秒   (上次结束时间---下次开始时间)
	*	fixedRate  在间隔固定时间后执行 long 类型 单位毫秒
	*	fixedRateString  在间隔固定时间后执行 stirng 类型 单位毫秒
	*	initialDelay   初始化后多少毫秒后执行定时器 long 类型 单位毫秒
	*	initialDelayString 初始化后多少毫秒后执行定时器 String类型 单位毫秒
	*	fixedDelay 和fixedRate  区别
	*	fixedDelay 是上一次定时器结束后间隔制定时间后再次执行
	*	FixedRate  是每次间隔多久执行一次（不管上次是否执行完毕）
	*/
	/** 
	 * 定时器开发步骤
		1.创建定时器类 
		2.开启对计划任务的支持	类上添加 @EnableScheduling
		3.编写定时任务
		4.在定时任务上开启注解 @Scheduled 根据需求填写参赛
	*/
	//代码分析 FixedRate和fixedDelay区别
	Thread t = new Thread();
	@SuppressWarnings("static-access")
	@Scheduled(fixedRate=5000)
	public void timeRun() throws InterruptedException{
		System.out.println("----------华丽分割------------");
		System.out.println(System.currentTimeMillis());
		System.out.println("FixeRate:50000毫秒执行一次");
		Thread t = new Thread();
		t.run();
		t.sleep(6000);;
		System.out.println(System.currentTimeMillis());
		
	}
	@SuppressWarnings("static-access")
	@Scheduled(fixedDelay=5000)
	public void timeRun1() throws InterruptedException{
		System.out.println("----------fixedDelay华丽分割------------");
		System.out.println(System.currentTimeMillis());
		System.out.println("fixedDelay:50000毫秒执行一次");
		
		t.run();
		t.sleep(6000);
		System.out.println(System.currentTimeMillis());
	}
}
