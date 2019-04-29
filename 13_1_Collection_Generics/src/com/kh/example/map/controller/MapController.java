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
		// put(K key, V value) : 키와 값 추가
		map.put("새우깡", new Snack("짠맛", 1500));
		map.put("다이제", new Snack("단맛", 2500));
		map.put("포테이토칩", new Snack("짠맛", 1500));
		map.put("고소미", new Snack("고소한맛", 1000));
		System.out.println(map);
		// 출력시 {새우깡=짠맛 [1500원]} => {key=value,key=value,key=value,---}
		// key=value형식으로 저장이 됨!
		// but 순서 유지가 되지 않음!
		// 값은 중복되도 상관 x

		map.put("새우깡", new Snack("매운맛", 1500));
		System.out.println(map);
		// 중복된 key일 시 덮어쓰기됨!! ->String은 비교할수 있는 기능이 있기 때문에!
		// Key에 객체를 넣으면 비교되지않음..

		// containsKey(Object key) : key가 있으면 true 반환
		// containtsValue(Objecty value) : value가 있으면 true 반환

		boolean key = map.containsKey("새우깡");
		System.out.println(key);// true 반환

		boolean value = map.containsValue(new Snack("짠맛", 1500));
		System.out.println(value);
		// new Snack~~으로하면 객체끼리의 비교이기때문에 해시코드와 이콜스를 오버라이딩 해주지않으면 무조건 다른 객체로 인식함!

		// get(Object key) : 키의 값 반환
		// ****get(Object value) 는 존재하지않음!!!! -> 유일하지 않기 때문에
		System.out.println(map.get("새우깡")); // 매운맛 [1500원]
		System.out.println(map.get("홈런볼")); // null
		// 키가 있다면 일치하는 value를 가져오고, 없다면 null을 가져옴!

		// map 엘리먼트 접근하기
		// 1. values() : 모든 value Collection에 담아 반환 <-사실 별로 쓸데없긴함
		System.out.println("\"map.values()\" 출력 : " + map.values() + "\n");

		// 2. keySet() : 모든 키를 Set에 담아 반환
		// keySet -> 반환형 : set
		Set set1 = map.keySet();
		Iterator it1 = set1.iterator();
		while (it1.hasNext()) {
			Object o = it1.next();
			System.out.printf("키 : %s\t값 : %s%n", o, map.get(o));
		}
		// keySet 이용, 다른버전 ->향상된 for문!
		for (Object o : map.keySet()) {
			System.out.printf("키 : %s\t값 : %s%n", o, map.get(o));
		}

		// 3. entrySet() : 모든 entry 객체(키 + 값 쌍)을 set에 담아 반환
		// keySet보다는 entySet을 훨씬 많이씀!
		Set set2 = map.entrySet();
		Iterator it2 = set2.iterator();
		System.out.println("entrySet - 모든 entry객체(키+값 쌍)을 set에 담아 반환");
		while (it2.hasNext()) {
			Map.Entry me = (Map.Entry) it2.next();
			System.out.printf("키 : %s\t값 : %s%n", me.getKey(), me.getValue());
		}
		// entrySet()이용, 다른 버전
		for (Object o : set2) {
			Map.Entry me = (Map.Entry) o;
			System.out.printf("키 : %s\t값 : %s%n", me.getKey(), me.getValue());
		}

		Map map2 = new TreeMap();
		map2.putAll(map);
		System.out.println(map2);

		Map map3 = new TreeMap(new SnackComparator());
		map3.putAll(map2);
		System.out.println(map3);

		// size() : map에 저장된 entry 수 반환
		System.out.println(map3.size());

		// remove(Object key) : 해당 key의 entry 삭제 후 값 반환!
		System.out.println(map3.remove("다이제"));

		System.out.println();
//		map3.remove(key, value)
//		key와 값이 맞으면 삭제 후 true 반환. 맞지 않으면 false 반환!
		System.out.println("map3.remove(\"고소미\", new Snack(\"고소한맛\",1000))");
		System.out.println(map3.remove("고소미", new Snack("고소한맛", 1000)));
		System.out.println(map3);
		System.out.println();
		
		// clear() : 모든 entry 삭제
		// isEmpty() : map이 비어있으면 true 반환
		//list 배울 때 했엇음~~
		map3.clear();
		System.out.println(map3);
		System.out.println(map3.isEmpty());
	}

	public void doProperties() {
		Properties prop = new Properties();
		// Properties 는 Hashtable 을 상속받고있어 put은 Hashtable에서 사용받은것!
//		prop.put(1, 10);
//		Properties의 메소드가 아님!

		prop.setProperty("채소", "오이");
		prop.setProperty("과일", "사과");
		prop.setProperty("간식", "젤리");

		prop.setProperty("채소", "피망");
		// 덮어쓰여짐!
		System.out.println(prop);
		// map의 형태로 순서 유지가 되지않음!

		// getProperty(String key) : key를 통해 value 반환
		System.out.println(prop.getProperty("채소"));// 피망
		System.out.println(prop.getProperty("견과"));// null

		System.out.println("prop.getProperty(\"채소\", \"양파\") : " + prop.getProperty("채소", "양파")); // 피망이 나옴~
		System.out.println("prop.getProperty(\"견과\", \"땅콩\")" + prop.getProperty("견과", "땅콩"));// 땅콩~
		// prop.getProperty(key, defaultValue)
		// key가 있으면 key의 값 반환 없으면 defaultValue가 튀어나옴

		// hashtable 은 구버전이기때문에 iterator을 사용하지 않고 enumeration을 사용함!!!
		Enumeration e = prop.propertyNames();

		System.out.println(
				"\n" + "Enumeration으로 출력!" + "\n" + "System.out.println(key + \" / \" + prop.getProperty(key))");
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();// = next()

			System.out.println(key + " / " + prop.getProperty(key));
		}

	}

	public void fileSave() {
		// close 하는게 무조건 IOException을 해줘야하기때문에 resource 문을 쓰면 IO예외가 뜸!
		try (FileOutputStream fos = new FileOutputStream("test.properties");) {

			Properties prop = new Properties();
			prop.setProperty("title", "Properties Practice");
			prop.setProperty("width", "1920");
			prop.setProperty("height", "1080");
			prop.setProperty("language", "kor");

			// store(OutputStream out, String comments)
			// : out에 prop를 저장하겠다. comments는 주석으로 저장!
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
			// : inStream에 있는 파일을 읽어와 저장
			prop.load(fis);
			System.out.println(prop);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
