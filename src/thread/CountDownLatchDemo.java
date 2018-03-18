package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Talk is cheap,show me your code
 * 
 * @Description: CountDownLatch  
 * @author zzyy
 * @date 2018��3��17��
 *��һЩ�߳�����ֱ����һЩ�߳����һϵ�в�����ű����ѡ�
 * 
 * CountDownLatch��Ҫ��������������һ�������̵߳���await����ʱ����Щ�̻߳�������
 * �����̵߳���countDown�����Ὣ��������1(����countDown�������̲߳�������)��
 * ����������ֵ��Ϊ0ʱ����await�����������̻߳ᱻ���ѣ�����ִ�С�
 * 
 * ���ͣ�5��ͬѧ½���뿪���Һ�ֵ��ͬѧ�ſ��Թ��š�
 * Ҳ��	����6����һͳ����
 * main���̱߳���Ҫ��ǰ��5���߳����ȫ���������Լ����ܿ���
 */
public class CountDownLatchDemo {

	public static void main(String[] args)throws Exception {
		//�ļ�
		CountDownLatch cd =new CountDownLatch(6);
		for (int i = 1; i <=6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+"\t ������");
				cd.countDown();
			},CountryEnum.forEachCountryEnums(i).getRetMsg()).start();
			
		}
		cd.await();
		System.out.println(Thread.currentThread().getName()+"*********����6����һͳ����");
		
		
	}

	public static void testsiji() throws InterruptedException {
		CountDownLatch cdl=new CountDownLatch(4);
		for (int i = 1; i <=4; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+"\t ����");
				cdl.countDown();
			}, Seasons.forEachSeason(i).getReMsg()).start();
		}
		cdl.await();
		System.out.println(Thread.currentThread().getName()+"*********������");
	}

	public static void testCountry() throws InterruptedException {
		CountDownLatch cdl=new CountDownLatch(6);
		for (int i = 1; i <=6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+"\t ������");
				cdl.countDown();
			}, CountryEnum.forEachCountryEnums(i).getRetMsg()).start();
		}
		cdl.await();
		System.out.println(Thread.currentThread().getName()+"*********����6����һͳ����");
	}

	public static void testCloseDoor() throws InterruptedException {
		CountDownLatch cdl=new CountDownLatch(6);
		for (int i = 1; i <=6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName()+"\t ����ϰ�뿪����");
				cdl.countDown();
			}, String.valueOf(i)).start();
		}
		cdl.await();
		System.out.println(Thread.currentThread().getName()+"*********�೤����");
	}
}
