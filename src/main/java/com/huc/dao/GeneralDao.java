package com.huc.dao;

import java.util.List;
import java.util.Map;

public interface GeneralDao {
	

	
	/**
	 * 获得实体对象
	 * @param tableName 表名
	 * @param primaryKey 主键
	 * @param primaryValue 主键值
	 * @return 实体对象
	 */
	public Map<String, Object> getObjectByPrimaryKey(String tableName,String[] primaryKey,Object[] primaryValue);	
	
	/**
	 * 添加表数据
	 * @param tableName 表名
	 * @param data 数据信息
	 */
	public void addObject(String tableName,Map<String, String> data);

	/**
	 * 更新表字段
	 * @param tableName 表名
	 * @param data 数据信息
	 * @param where 条件信息
	 */
	public void updateObject(String tableName,Map<String, String> data,Map<String, String> where);
	
	/**
	 * 根据条件获得字段信息
	 * @param tableName 表名
	 * @param columns 获得的字段名称
	 * @param where 条件信息
	 * @return 数据信息
	 */
	public Map<String,Object> getColumnByCondition(String tableName,String[] columns,Map<String, String> where);
	
	//启动的时候临时执行的方法
	Map<String, Object> resultSql(String sql);	
	Map<String, Object> resultSql(String sql, Object[] obj);
	List<Map<String, Object>> listSql(String sql);
	List<Map<String, Object>> listSql(String sql, Object[] obj);
	void runsql(String sql);
	void runsql(String sql, Object[] obj);
	public long insertAndGetKey(final String sql, final Object[] params);
	public long addObjectWithReturn(String tableName,Map<String, String> data);

}
