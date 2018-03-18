package thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Description: ��4�ֻ�ö��̵߳ķ�ʽ,�̳߳�
 * @author zzyy
 * @date 2018��3��3��
 * 
 * SSS
 * Collections Arrays Executors
 * @author pc
 *
 */
public class ExecutorsDemo {

	public static void main(String[] args) {
//		ExecutorService service =Executors.newSingleThreadExecutor();
//		ExecutorService service =Executors.newCachedThreadPool();
		ExecutorService service =Executors.newFixedThreadPool(5);
		Future<Integer> ft=null;
		try {
			for (int i = 1; i <=15; i++) {
				ft=service.submit(() -> {
					System.out.println(Thread.currentThread().getName());
					return new Random().nextInt(8);
				});
				System.out.println("*************ft="+ft);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static void test1() {
		ScheduledExecutorService service =Executors.newScheduledThreadPool(5);
		ScheduledFuture<Integer> result=null;
		try {
			for (int i = 1; i <=15; i++) {
				result=service.schedule(() -> {
					System.out.print(Thread.currentThread().getName());
					return new Random().nextInt(10);
				}, 2, TimeUnit.SECONDS);
				System.out.println("******result:"+result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}
	
	public static void testThreadPool(){
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
