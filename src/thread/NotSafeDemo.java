package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
CopyOnWrite������дʱ���Ƶ���������һ���������Ԫ�ص�ʱ�򣬲�ֱ������ǰ����Object[]��ӣ������Ƚ���ǰ����Object[]����Copy��
���Ƴ�һ���µ�����Object[] newElements��Ȼ���µ�����Object[] newElements�����Ԫ�أ������Ԫ��֮��
�ٽ�ԭ����������ָ���µ����� setArray(newElements);���������ĺô��ǿ��Զ�CopyOnWrite�������в����Ķ���
������Ҫ��������Ϊ��ǰ������������κ�Ԫ�ء�����CopyOnWrite����Ҳ��һ�ֶ�д�����˼�룬����д��ͬ������
*/
public class NotSafeDemo {

	public static void main(String[] args) {
//		List list =new ArrayList<String>();
		Set<String> set= new CopyOnWriteArraySet<String>();
		for (int i = 1; i <=30; i++) {
			new Thread(() -> {
				set.add(UUID.randomUUID().toString().substring(0,3));
				System.out.println(set);
			}, String.valueOf(i)).start();
		}
	}

	public static void testMap() {
		Map<String,String> map = new ConcurrentHashMap<String,String>();
		for (int i = 1; i <=30; i++) {
			
			new Thread(() -> {
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 3));
				System.out.println(map);
			}, String.valueOf(i)).start();
		}
	}

	public static void testList() {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
//		list=Arrays.asList("a","b","c");
//		list.forEach(System.out::println);
		for (int i = 1; i <=30; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0,3));
				System.out.println(list);
			}, String.valueOf(i)).start();
		}
	}
}
