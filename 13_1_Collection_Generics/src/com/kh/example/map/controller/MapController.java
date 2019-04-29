package com.kh.example.map.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import com.kh.example.map.model.compare.SnackComparator;
import com.kh.example.map.model.vo.Snack;

public class MapController {
	public void doMap() {
		Map map = new HashMap();
		// put(K key, V value) : Ű�� �� �߰�
		map.put("�����", new Snack("§��", 1500));
		map.put("������", new Snack("�ܸ�", 2500));
		map.put("��������Ĩ", new Snack("§��", 1500));
		map.put("��ҹ�", new Snack("����Ѹ�", 1000));
		System.out.println(map);
		// ��½� {�����=§�� [1500��]} => {key=value,key=value,key=value,---}
		// key=value�������� ������ ��!
		// but ���� ������ ���� ����!
		// ���� �ߺ��ǵ� ��� x

		map.put("�����", new Snack("�ſ��", 1500));
		System.out.println(map);
		// �ߺ��� key�� �� ������!! ->String�� ���Ҽ� �ִ� ����� �ֱ� ������!
		// Key�� ��ü�� ������ �񱳵�������..

		// containsKey(Object key) : key�� ������ true ��ȯ
		// containtsValue(Objecty value) : value�� ������ true ��ȯ

		boolean key = map.containsKey("�����");
		System.out.println(key);// true ��ȯ

		boolean value = map.containsValue(new Snack("§��", 1500));
		System.out.println(value);
		// new Snack~~�����ϸ� ��ü������ ���̱⶧���� �ؽ��ڵ�� ���ݽ��� �������̵� ������������ ������ �ٸ� ��ü�� �ν���!

		// get(Object key) : Ű�� �� ��ȯ
		// ****get(Object value) �� ������������!!!! -> �������� �ʱ� ������
		System.out.println(map.get("�����")); // �ſ�� [1500��]
		System.out.println(map.get("Ȩ����")); // null
		// Ű�� �ִٸ� ��ġ�ϴ� value�� ��������, ���ٸ� null�� ������!

		// map ������Ʈ �����ϱ�
		// 1. values() : ��� value Collection�� ��� ��ȯ <-��� ���� ����������
		System.out.println("\"map.values()\" ��� : " + map.values() + "\n");

		// 2. keySet() : ��� Ű�� Set�� ��� ��ȯ
		// keySet -> ��ȯ�� : set
		Set set1 = map.keySet();
		Iterator it1 = set1.iterator();
		while (it1.hasNext()) {
			Object o = it1.next();
			System.out.printf("Ű : %s\t�� : %s%n", o, map.get(o));
		}
		// keySet �̿�, �ٸ����� ->���� for��!
		for (Object o : map.keySet()) {
			System.out.printf("Ű : %s\t�� : %s%n", o, map.get(o));
		}

		// 3. entrySet() : ��� entry ��ü(Ű + �� ��)�� set�� ��� ��ȯ
		// keySet���ٴ� entySet�� �ξ� ���̾�!
		Set set2 = map.entrySet();
		Iterator it2 = set2.iterator();
		System.out.println("entrySet - ��� entry��ü(Ű+�� ��)�� set�� ��� ��ȯ");
		while (it2.hasNext()) {
			Map.Entry me = (Map.Entry) it2.next();
			System.out.printf("Ű : %s\t�� : %s%n", me.getKey(), me.getValue());
		}
		// entrySet()�̿�, �ٸ� ����
		for (Object o : set2) {
			Map.Entry me = (Map.Entry) o;
			System.out.printf("Ű : %s\t�� : %s%n", me.getKey(), me.getValue());
		}

		Map map2 = new TreeMap();
		map2.putAll(map);
		System.out.println(map2);

		Map map3 = new TreeMap(new SnackComparator());
		map3.putAll(map2);
		System.out.println(map3);

		// size() : map�� ����� entry �� ��ȯ
		System.out.println(map3.size());

		// remove(Object key) : �ش� key�� entry ���� �� �� ��ȯ!
		System.out.println(map3.remove("������"));

		System.out.println();
//		map3.remove(key, value)
//		key�� ���� ������ ���� �� true ��ȯ. ���� ������ false ��ȯ!
		System.out.println("map3.remove(\"��ҹ�\", new Snack(\"����Ѹ�\",1000))");
		System.out.println(map3.remove("��ҹ�", new Snack("����Ѹ�", 1000)));
		System.out.println(map3);
		System.out.println();
		
		// clear() : ��� entry ����
		// isEmpty() : map�� ��������� true ��ȯ
		//list ��� �� �߾���~~
		map3.clear();
		System.out.println(map3);
		System.out.println(map3.isEmpty());
	}

	public void doProperties() {
		Properties prop = new Properties();
		// Properties �� Hashtable �� ��ӹް��־� put�� Hashtable���� ��������!
//		prop.put(1, 10);
//		Properties�� �޼ҵ尡 �ƴ�!

		prop.setProperty("ä��", "����");
		prop.setProperty("����", "���");
		prop.setProperty("����", "����");

		prop.setProperty("ä��", "�Ǹ�");
		// �������!
		System.out.println(prop);
		// map�� ���·� ���� ������ ��������!

		// getProperty(String key) : key�� ���� value ��ȯ
		System.out.println(prop.getProperty("ä��"));// �Ǹ�
		System.out.println(prop.getProperty("�߰�"));// null

		System.out.println("prop.getProperty(\"ä��\", \"����\") : " + prop.getProperty("ä��", "����")); // �Ǹ��� ����~
		System.out.println("prop.getProperty(\"�߰�\", \"����\")" + prop.getProperty("�߰�", "����"));// ����~
		// prop.getProperty(key, defaultValue)
		// key�� ������ key�� �� ��ȯ ������ defaultValue�� Ƣ���

		// hashtable �� �������̱⶧���� iterator�� ������� �ʰ� enumeration�� �����!!!
		Enumeration e = prop.propertyNames();

		System.out.println(
				"\n" + "Enumeration���� ���!" + "\n" + "System.out.println(key + \" / \" + prop.getProperty(key))");
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();// = next()

			System.out.println(key + " / " + prop.getProperty(key));
		}

	}

	public void fileSave() {
		// close �ϴ°� ������ IOException�� ������ϱ⶧���� resource ���� ���� IO���ܰ� ��!
		try (FileOutputStream fos = new FileOutputStream("test.properties");) {

			Properties prop = new Properties();
			prop.setProperty("title", "Properties Practice");
			prop.setProperty("width", "1920");
			prop.setProperty("height", "1080");
			prop.setProperty("language", "kor");

			// store(OutputStream out, String comments)
			// : out�� prop�� �����ϰڴ�. comments�� �ּ����� ����!
			prop.store(fos, "Properties Test file");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileOpen() {
		try (FileInputStream fis = new FileInputStream("test.properties")) {
			Properties prop = new Properties();

			// load(InputStream inStream)
			// : inStream�� �ִ� ������ �о�� ����
			prop.load(fis);
			System.out.println(prop);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
