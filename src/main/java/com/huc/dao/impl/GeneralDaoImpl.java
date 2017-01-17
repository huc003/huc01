package com.huc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.KeyHolder;

import com.huc.dao.GeneralDao;

public class GeneralDaoImpl implements GeneralDao {
	private static final Log log = LogFactory.getLog(GeneralDaoImpl.class);


	public JdbcTemplate jdbcTemplate;

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 运行sql语句
	 * 
	 * @param sql
	 */
	public void runsql(String sql) {
		this.jdbcTemplate.update(sql);
	}

	/**
	 * 运行sql语句
	 * 
	 * @param sql
	 */
	public void runsql(String sql, Object[] obj) {
		this.jdbcTemplate.update(sql, obj);
	}

	/**
	 * 运行sql语句,返回一条数据
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public Map<String, Object> resultSql(String sql) {
		List<Map<String, Object>> tpList = this.jdbcTemplate.query(sql,getColumnMapRowMapper());
		if (tpList != null && !tpList.isEmpty()) {
			return tpList.get(0);
		}
		return null;
	}

	/**
	 * 运行sql语句,返回一条数据
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public Map<String, Object> resultSql(String sql, Object[] obj) {
		List<Map<String, Object>> tpList = this.jdbcTemplate.query(sql,
				obj,getColumnMapRowMapper());
		if (tpList != null && !tpList.isEmpty()) {
			return tpList.get(0);
		}
		return null;
	}
	 protected RowMapper<Map<String, Object>> getColumnMapRowMapper() {
	        return new MyColumnMapRowMapper();
	}
	 private static class MyColumnMapRowMapper extends ColumnMapRowMapper{

			public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
	            ResultSetMetaData rsmd = rs.getMetaData();
	            int columnCount = rsmd.getColumnCount();
	            Map<String, Object> mapOfColValues = createColumnMap(columnCount);
	            for (int i = 1; i <= columnCount; i++) {

	                String key = getColumnKey(JdbcUtils.lookupColumnName(rsmd, i));
	                Object obj = null;
	                if (rsmd.getColumnTypeName(i).equals("TINYINT")) {
	                    obj = rs.getInt(i);
	                } else {
	                    obj = getColumnValue(rs, i);
	                }
	                mapOfColValues.put(key, obj);

	            }
	            return mapOfColValues;
	        }
	    }


	/**
	 * 运行sql语句，返回结果集
	 * 
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> listSql(String sql) {
		return jdbcTemplate.query(sql,getColumnMapRowMapper());
	}

	/**
	 * 运行sql语句，返回结果集
	 * 
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> listSql(String sql, Object[] obj) {
		return jdbcTemplate.query(sql, obj,getColumnMapRowMapper());
	}
	

//	public String getRecordNo(String tableName, String columnName) {
//		String recordNo = CommonUtils.getRecordNo();
//		String sql = "select " + columnName + " from " + tableName + " where "
//				+ "`" + columnName + "`" + "=?";
//		Map<String, Object> map = this
//				.resultSql(sql, new Object[] { recordNo });
//		while (map != null && map.get(columnName) != null) {
//			recordNo = CommonUtils.getRecordNo();
//			map = this.resultSql(sql, new Object[] { recordNo });
//		}
//		return recordNo;
//	}

//	@Override
//	public String getApiOperationLogNo() {
//		String recordNo = CommonUtils.getRandom();
//		String sql = "select log_no from dw_api_log where `log_no`=?";
//		Map<String, Object> map = this
//				.resultSql(sql, new Object[] { recordNo });
//		while ((map != null && map.get("log_no") != null)) {
//			recordNo = CommonUtils.getRandom();
//			map = this.resultSql(sql, new Object[] { recordNo });
//		}
//		return recordNo;
//	}

	@Override
	public Map<String, Object> getObjectByPrimaryKey(String tableName,
			String[] primaryKey, Object[] primaryValue) {
		StringBuffer sql = new StringBuffer("select * from " + tableName + " where ");
		int i = 0;
		for (String key : primaryKey) {
			if (i > 0) {
				sql.append(" and ");
			}
			sql.append(" `" + key + "`" + "=?");
			i++;
		}
		return resultSql(sql.toString(), primaryValue);
	}

	@SuppressWarnings("unused")
	@Override
	public void addObject(String tableName, Map<String, String> data) {
		Set<String> keys = data.keySet();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into " + tableName + "(");
		int i = 0;
		for (String key : keys) {
			if (i > 0) {
				sql.append(",");
			}
			sql.append("`" + key + "`");
			i++;
		}
		sql.append(") values(");
		i = 0;
		for (String key : keys) {
			if (i > 0) {
				sql.append(",");
			}
			sql.append("?");
			i++;
		}
		sql.append(")");
		Object[] obj = new Object[data.size()];
		i = 0;
		for (String key : keys) {
			obj[i] = data.get(key);
			i++;
		}
		log.info(sql.toString());
		log.info(data.toString());
		this.runsql(sql.toString(), obj);
	}

	@Override
	public void updateObject(String tableName, Map<String, String> data,
			Map<String, String> where) {
		StringBuffer sql = new StringBuffer();
		sql.append("update " + tableName + " set ");
		Set<String> keys = data.keySet();
		int i = 0;
		for (String key : keys) {
			if (i > 0) {
				sql.append(",");
			}
			sql.append("`" + key + "`" + "=?");
			i++;
		}
		sql.append(" where ");
		keys = where.keySet();
		i = 0;
		for (String key : keys) {
			if (i > 0) {
				sql.append(" and ");
			}
			sql.append("`" + key + "`" + "=?");
			i++;
		}
		Object[] obj = new Object[data.size() + where.size()];
		i = 0;
		keys = data.keySet();
		Iterator<String> lt = keys.iterator();
		String m = "";
		while (lt.hasNext()) {
			m = lt.next();
			obj[i] = data.get(m);
			i++;
		}
		keys = where.keySet();
		for (String key : keys) {
			obj[i] = where.get(key);
			i++;
		}
		log.info(sql.toString());
		log.info(data.toString());
		log.info(where.toString());
		this.runsql(sql.toString(), obj);
	}

	@Override
	public Map<String, Object> getColumnByCondition(String tableName,
			String[] columns, Map<String, String> where) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		int i = 0;
		for (String c : columns) {
			if (i > 0) {
				sql.append(",");
			}
			sql.append(c);
			i++;
		}
		sql.append(" from " + tableName + " where ");
		Set<String> wheresSet = where.keySet();
		i = 0;
		for (String w : wheresSet) {
			if (i > 0) {
				sql.append(" and ");
			}
			sql.append("`" + w + "`" + "=?");
			i++;
		}
		Object[] obj = new Object[where.size()];
		i = 0;
		for (String w : wheresSet) {
			obj[i] = where.get(w);
			i++;
		}
		return resultSql(sql.toString(), obj);
	}

	public long insertAndGetKey(final String sql, final Object[] params) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public java.sql.PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				int i = 0;
				java.sql.PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				for (Object obj:params) {
					if(obj instanceof String){
						ps.setString(++i, String.valueOf(obj));
					}else if (obj instanceof Long){
						ps.setLong(++i, Long.valueOf(obj+""));
					}else if (obj instanceof Integer){
						ps.setInt(++i, Integer.valueOf(obj+""));
					}else if (obj instanceof Double){
						ps.setDouble(++i, Double.valueOf(obj+""));
					}
				}
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public long addObjectWithReturn(String tableName, Map<String, String> data) {
		Set<String> keys = data.keySet();
		StringBuffer sql = new StringBuffer();
		sql.append("insert into " + tableName + "(");
		int i = 0;
		for (String key : keys) {
			if (i > 0) {
				sql.append(",");
			}
			sql.append("`" + key + "`");
			i++;
		}
		sql.append(") values(");
		i = 0;
		for (String key : keys) {
			if (i > 0) {
				sql.append(",");
			}
			sql.append("?");
			i++;
		}
		sql.append(")");
		Object[] obj = new Object[data.size()];
		i = 0;
		for (String key : keys) {
			obj[i] = data.get(key);
			i++;
		}
		log.info(sql.toString());
		log.info(data.toString());
		return insertAndGetKey(sql.toString(), obj);
	}

}