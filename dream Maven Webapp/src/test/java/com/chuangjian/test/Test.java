package com.chuangjian.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chuangjian.entity.City;
import com.chuangjian.entity.District;
import com.chuangjian.entity.Province;

public class Test {

	public static void main(String[] args) {
		List<District> districtList1=new ArrayList<District>();
		districtList1.add(new District(1,"越秀区"));
		districtList1.add(new District(2,"荔湾区"));
		districtList1.add(new District(3,"海珠区"));
		districtList1.add(new District(4,"天河区"));
		districtList1.add(new District(5,"白云区"));
		List<District> districtList2=new ArrayList<District>();
		districtList2.add(new District(1,"福田区"));
		districtList2.add(new District(2,"罗湖区"));
		districtList2.add(new District(3,"南山区"));
		districtList2.add(new District(4,"宝安区"));
		districtList2.add(new District(5,"龙岗区"));
		Map<City,List<District>> cityMap1=new HashMap<City,List<District>>();
		cityMap1.put(new City(1,"广州市"),districtList1);
		cityMap1.put(new City(2,"深圳市"),districtList2);
		
		List<District> districtList3=new ArrayList<District>();
		districtList3.add(new District(1,"越秀区"));
		districtList3.add(new District(2,"荔湾区"));
		districtList3.add(new District(3,"海珠区"));
		districtList3.add(new District(4,"天河区"));
		districtList3.add(new District(5,"白云区"));
		List<District> districtList4=new ArrayList<District>();
		districtList4.add(new District(1,"福田区"));
		districtList4.add(new District(2,"罗湖区"));
		districtList4.add(new District(3,"南山区"));
		districtList4.add(new District(4,"宝安区"));
		districtList4.add(new District(5,"龙岗区"));
		Map<City,List<District>> cityMap2=new HashMap<City,List<District>>();
		cityMap2.put(new City(1,"广州市"),districtList1);
		cityMap2.put(new City(2,"深圳市"),districtList2);
		
		
		Map<Province,Map<City,List<District>>> provinceMap=new HashMap<Province,Map<City,List<District>>>();
		provinceMap.put(new Province(1,"广东省"), cityMap1);
		provinceMap.put(new Province(2,"浙江省"), cityMap2);
		System.out.println(provinceMap.toString());
	}
}
