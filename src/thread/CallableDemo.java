package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * 
 * 
�����߳�����Ҫִ�бȽϺ�ʱ�Ĳ���ʱ�����ֲ����������߳�ʱ�����԰���Щ��ҵ����Future�����ں�̨��ɣ�
�����߳̽�����Ҫʱ���Ϳ���ͨ��Future�����ú�̨��ҵ�ļ���������ִ��״̬��

һ��FutureTask�����ں�ʱ�ļ��㣬���߳̿���������Լ����������ȥ��ȡ�����

���ڼ������ʱ���ܼ�����������������δ��ɣ������� get ������һ��������ɣ�
�Ͳ��������¿�ʼ��ȡ�����㡣get��������ȡ���ֻ���ڼ������ʱ��ȡ�������һֱ����ֱ������ת�����״̬��
Ȼ��᷵�ؽ�������׳��쳣�� 

ֻ����һ��
get�����ŵ����
 */
public class CallableDemo {

	public static void main(String[] args)throws Exception {
//		FutureTask<Integer> ft=new FutureTask<Integer>(() ->{
//			System.out.println("***********sssss");
//			return 1111;
//		});
		FutureTask<Integer> ft=new FutureTask<Integer>(new MyThread());
		new Thread(ft,"AA").start();
		new Thread(ft,"BB").start();
		System.out.println(Thread.currentThread().getName()+"�����Ͽ����߳�");
		Integer result1 =ft.get();
//		Integer result2 =ft.get();
		System.out.println("result1:"+result1);
//		System.out.println("result2:"+result2);
		
	}
}
class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("**********call()");
		return 1018;
	}
	
}