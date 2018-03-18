package thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @Description: 一个线程写入,100个线程读取
 * @author zzyy
 * @date 2018年3月17日
 */
public class ReadWriteLockDemo {

	public static void main(String[] args) {
		MyQueue mq=new MyQueue();
		new Thread(() -> {
			mq.write("ssss");
		}, "writeThread").start();
		
		for (int i = 1; i <=100; i++) {
			new Thread(() -> {
				mq.read();
			}, String.valueOf(i)).start();
		}
	}
}
class MyQueue{
	private Object obj;
	public ReentrantReadWriteLock rw=new ReentrantReadWriteLock();
	
	public void write(Object obj){
		rw.writeLock().lock();
		try {
			this.obj=obj;//赋值,不然为空
			System.out.println(Thread.currentThread().getName()+"\t"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rw.writeLock().unlock();
		}
	}
	public void read(){
		rw.readLock().lock();
		
		try {
			System.out.println(Thread.currentThread().getName()+"\t"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rw.readLock().unlock();
		}
	}
	
	
	
	
	
}