package com.shengsiyuan2;

import java.util.HashMap;
import java.util.TreeMap;

public class MapTest1 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("deming", "dog");
		map.put("alex", "cat");
		map.put("fatass", "pig");
		map.put("kai", "lion");
		String gechar=(String) map.get("deming");
		System.out.println(gechar);
		System.out.println(map);
		
		TreeMap trmap = new TreeMap();
		trmap.put("deming", "dog");
		trmap.put("alex", "cat");
		trmap.put("fatass", "pig");
		trmap.put("kai", "lion");
		System.out.println(trmap);

	}
}
