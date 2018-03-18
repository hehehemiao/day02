package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @Description: TODO(������һ�仰��������������)  
 * @author zzyy
 * @date 2018��3��3��
 * CyclicBarrier
 * ��������˼�ǿ�ѭ����Cyclic��ʹ�õ����ϣ�Barrier������Ҫ���������ǣ�
 * ��һ���̵߳���һ�����ϣ�Ҳ���Խ�ͬ���㣩ʱ��������
 * ֱ�����һ���̵߳�������ʱ�����ϲŻῪ�ţ�����
 * ���������ص��̲߳Ż�����ɻ
 * �߳̽�������ͨ��CyclicBarrier��await()������
 * 
 * ����7������Ϳ����ٻ�����
 */
public class CyclicBarrierDemo {
	
	private static final int NUM=7;
	
	public static void main(String[] args) throws Exception{
		
		CyclicBarrier bc=new CyclicBarrier(NUM, () -> {
			System.out.println("**********�����߿�����");
		});
		
		
		for (int i = 1; i <=7; i++) {
			int temp=i;
			new Thread(() -> {
				System.out.println("�����˵�"+temp+"������");
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
			System.out.println("*******�����߿������ٻ�����");
		});
		for (int i = 1; i <=NUM; i++) {
			int temp=i;
			new Thread(() -> {
				
				System.out.println(Thread.currentThread().getName()+"\t�����"+temp+"������");
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}
	}
}
