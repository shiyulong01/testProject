package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionSort {
	
	public List<Integer> sortList(List<Integer> unsortList){
		System.out.println("before sort: ");
		displayList(unsortList);
		Collections.sort(unsortList, new Comparator<Integer>(){
			public int compare(Integer int1, Integer int2){
				//return int1.compareTo(int2);
				if(int1 > int2)
					return 1;
				else if(int1 < int2)
					return -1;
				else
					return 0;
			}
		});
		
		System.out.println("after sort: ");
		displayList(unsortList);
		return unsortList;
	}
	
	public void displayList(List<Integer> list){
		for(int element : list){
			System.out.println(element);
		}
	}
	
	public Map<String, Integer> sortMap(Map<String, Integer> map){
		List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		System.out.println("before sort: ");
		for(Map.Entry<String, Integer> tem : entryList){
			System.out.println(tem.getKey() + ": " + tem.getValue());
		}
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2){
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		System.out.println("after sort: ");
		for(Map.Entry<String, Integer> tem : entryList){
			System.out.println(tem.getKey() + ": " + tem.getValue());
		}
		return map;
	}
	
	public void displayMap(Map<String, Integer> map){
		List<Map.Entry<String, Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		for(Map.Entry<String, Integer> tem : mapList){
			System.out.println(tem.getKey() + ": " + tem.getValue());
		}
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(8);
		list.add(5);
		CollectionSort cs = new CollectionSort();
		cs.sortList(list);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 3);
		map.put("b", 2);
		map.put("c", 8);
		map.put("d", 5);
		cs.sortMap(map);
	}

}
