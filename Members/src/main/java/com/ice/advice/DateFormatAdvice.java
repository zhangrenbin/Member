package com.ice.advice;

import ice.tool.Page;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;


@Component("dateFormatAdvice")
public class DateFormatAdvice implements AfterReturningAdvice {
	
	public void afterReturning(Object returnValue, Method m, Object[] arg2, Object target) throws Throwable {
		DateFormatter dm = m.getAnnotation(DateFormatter.class);
		if(dm == null) {
			return;
		}
		String pattern = dm.value();
		if(returnValue instanceof List) {
			List list = (List)returnValue;
			for (Object o : list) {
				if(!(o instanceof Map)) {
					continue;
				}
				Map map = (Map)o;
				Set<Map.Entry> set = map.entrySet();
				Iterator<Map.Entry> ir = set.iterator();
				Map tm = new HashMap();
				while (ir.hasNext()) {
					Map.Entry entry = (Map.Entry) ir.next();
					if(entry.getValue() != null && entry.getValue() instanceof Date) {
						Date d = (Date)entry.getValue();
						//格式化
						DateFormat df = new SimpleDateFormat(pattern);
						tm.put(entry.getKey() + "_STR", df.format(d));
					}
				}
				map.putAll(tm);
			}
			System.out.println("------");
		} else if(returnValue instanceof Page) {
			Page p = (Page)returnValue;
			for (Object o : p.getResultList()) {
				if(!(o instanceof Map)) {
					continue;
				}
				Map map = (Map)o;
				Map tm = new HashMap();
				Set<Map.Entry> set = map.entrySet();
				Iterator<Map.Entry> ir = set.iterator();
				while (ir.hasNext()) {
					Map.Entry entry = (Map.Entry) ir.next();
					if(entry.getValue() != null && entry.getValue() instanceof Date) {
						Date d = (Date)entry.getValue();
						//格式化
						DateFormat df = new SimpleDateFormat(pattern);
						tm.put(entry.getKey() + "_STR", df.format(d));
					}
				}
				map.putAll(tm);
			}
		} else if(returnValue instanceof Map) {
			Map map = (Map)returnValue;
			Map tm = new HashMap();
			Set<Map.Entry> set = map.entrySet();
			Iterator<Map.Entry> ir = set.iterator();
			while (ir.hasNext()) {
				Map.Entry entry = (Map.Entry) ir.next();
				if(entry.getValue() != null && entry.getValue() instanceof Date) {
					Date d = (Date)entry.getValue();
					//格式化
					DateFormat df = new SimpleDateFormat(pattern);
					tm.put(entry.getKey() + "_STR", df.format(d));
				}
			}
			map.putAll(tm);
		}
		System.out.println("++++++++++");
	}
}
