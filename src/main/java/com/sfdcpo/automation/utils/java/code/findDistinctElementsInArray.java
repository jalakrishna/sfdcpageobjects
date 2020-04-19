package com.sfdcpo.automation.utils.java.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class findDistinctElementsInArray {


	public static void main(String[] args) {
		int[] array = {5,8,5,2,1,8,2,4};
		Map<Object, Integer> map = new LinkedHashMap<Object, Integer>();
		for(int i:array){
			if(map.containsKey(i)){
				map.put(i, map.get(i)+1);
			}else{
				map.put(i, 1);
			}
			//System.out.println(map);
		
		
		}
		Set<Object> skey = map.keySet();
		System.out.println(skey);
		for(Object c:skey){
			if(map.get(c)>1){
				System.out.println(c+ "is distinct inter");
			}
		}
		

	}

}