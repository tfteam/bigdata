package com.bigdata.dao;


import com.bigdata.common.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

@Component
public class BaseDAO {
	@Autowired
	protected SqlMapClientTemplate sqlMapClientTemplate;
	
	protected String _start = "_start";
	
	protected String _end = "_end";

	protected String _size = "_size";
	
	/**
	 * 获得NUM % mod后的字符串format格式
	 * @param num
	 * @param mod
	 * @return
	 */
	protected String getModNum(String format, long num, int mod) {
		return Util.getModNum(format, num, mod);
	}
	
	/**
	 * 获得数据库表在对象里的映射字段名
	 * @param column
	 * @return
	 */
	public static String getColumn2Field(String column) {
		String[] words = column.split("_");
		int length = words.length;
		String field = words[0];
		for (int i = 1; i < length; i++) {
			field += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
		}
		return field;
	}
	
	/**
	 * 动态设置值到PreparedStatement对象
	 * @param ps
	 * @param object
	 * @param field
	 * @param count
	 */
	public static void setPsWithValue(PreparedStatement ps,
			Object object, String field, int count) {
		try {
			String type = Util.getFieldType(object, field);
			if ("int".equals(type) || "Integer".equals(type)) {
				ps.setInt(count, (Integer) Util.getObjectField(object, field));
			} else if ("String".equals(type)) {
				ps.setString(count, (String) Util.getObjectField(object, field));
			} else if ("long".equals(type) || "Long".equals(type)) {
				ps.setLong(count, (Long) Util.getObjectField(object, field));
			} else if ("float".equals(type) || "Float".equals(type)) {
				ps.setFloat(count, (Float) Util.getObjectField(object, field));
			} else if ("Timestamp".equals(type)) {
				ps.setTimestamp(count, (Timestamp) Util.getObjectField(object, field));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
