package thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author zzyy
 * @date 2018年3月17日
 * 
 * 在信号量上我们定义两种操作：
 * acquire（获取） 当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1），
 * 					要么一直等下去，直到有线程释放信号量，或超时。
 * release（释放）实际上会将信号量的值加1，然后唤醒等待的线程。
 * 
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore s=new Semaphore(3);//模拟3个车位
		
		for (int i =1; i <=6; i++) {
			new Thread(() -> {
				try {
					s.acquire();
					System.out.println(Thread.currentThread().getName()+"\t"+"抢占了车位");
					TimeUnit.SECONDS.sleep(new Random().nextInt(10));
					System.out.println(Thread.currentThread().getName()+"\t"+"离开了车位");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally{
					s.release();
					
				}
			}, String.valueOf(i)).start();
		}
	}
}
