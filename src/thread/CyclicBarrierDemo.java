package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author zzyy
 * @date 2018年3月3日
 * CyclicBarrier
 * 的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，
 * 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有
 * 被屏障拦截的线程才会继续干活。
 * 线程进入屏障通过CyclicBarrier的await()方法。
 * 
 * 集齐7颗龙珠就可以召唤神龙
 */
public class CyclicBarrierDemo {
	
	private static final int NUM=7;
	
	public static void main(String[] args) throws Exception{
		
		CyclicBarrier bc=new CyclicBarrier(NUM, () -> {
			System.out.println("**********集齐七科龙珠");
		});
		
		
		for (int i = 1; i <=7; i++) {
			int temp=i;
			new Thread(() -> {
				System.out.println("集齐了第"+temp+"科龙珠");
				try {
					bc.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, "your thread name").start();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void test1() {
		CyclicBarrier cb=new CyclicBarrier(NUM, () -> {
			System.out.println("*******集齐七科龙珠召唤神龙");
		});
		for (int i = 1; i <=NUM; i++) {
			int temp=i;
			new Thread(() -> {
				
				System.out.println(Thread.currentThread().getName()+"\t集齐第"+temp+"颗龙珠");
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}
	}
}
