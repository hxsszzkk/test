package com.stt.cm.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stt.cm.inter.GutestMapper;

@Service
public class InsertSerImpl implements InsertSer {
	
	@Autowired
	GutestMapper gu;

	public void add() {
		try {
			long starttime = System.currentTimeMillis();
			File file = new File("D:/test.csv");
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader bre = null;
			bre = new BufferedReader(isr);
			String str;
			int count = 0;
			ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			List<String[]> list2 = new ArrayList<String[]>();
			while ((str = bre.readLine()) != null) {
				String[] split = str.split(",");
				list2.add(split);
			}
			long midTime = System.currentTimeMillis();
			
			for (String[] split : list2) {
				count++;
				Map<String, Object> hashmap = new HashMap<String, Object>();
				hashmap = new HashMap<String, Object>();
				hashmap.put("id", split[0]);
				hashmap.put("s1", split[1]);
				hashmap.put("i1", split[2]);
				hashmap.put("i2", split[3]);
				list.add(hashmap);
				if (count == 1000 ) {
					HashMap<String, Object> hashMap = new HashMap<String, Object>();
					hashMap.put("list", list);
					gu.inserts(hashMap);
					list.clear();
					hashMap.clear();
					count = 0;
				}
			}
			if(count !=0){
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("list", list);
				gu.inserts(hashMap);
			}

			long endTime = System.currentTimeMillis();
			System.out.println("总共:" + (endTime - starttime) + "毫秒");
			System.out.println("io:" + (midTime - starttime) + "毫秒");
			System.out.println("插入:" + (endTime - midTime) + "毫秒");
			isr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
