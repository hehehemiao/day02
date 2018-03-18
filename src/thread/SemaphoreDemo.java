package thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @Description: TODO(������һ�仰��������������)  
 * @author zzyy
 * @date 2018��3��17��
 * 
 * ���ź��������Ƕ������ֲ�����
 * acquire����ȡ�� ��һ���̵߳���acquire����ʱ����Ҫôͨ���ɹ���ȡ�ź������ź�����1����
 * 					Ҫôһֱ����ȥ��ֱ�����߳��ͷ��ź�������ʱ��
 * release���ͷţ�ʵ���ϻὫ�ź�����ֵ��1��Ȼ���ѵȴ����̡߳�
 * 
 * �ź�����Ҫ��������Ŀ�ģ�һ�������ڶ��������Դ�Ļ���ʹ�ã���һ�����ڲ����߳����Ŀ��ơ�
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore s=new Semaphore(3);//ģ��3����λ
		
		for (int i =1; i <=6; i++) {
			new Thread(() -> {
				try {
					s.acquire();
					System.out.println(Thread.currentThread().getName()+"\t"+"��ռ�˳�λ");
					TimeUnit.SECONDS.sleep(new Random().nextInt(10));
					System.out.println(Thread.currentThread().getName()+"\t"+"�뿪�˳�λ");
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
