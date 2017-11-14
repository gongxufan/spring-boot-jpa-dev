package gxf.dev.topology.repository;

import com.mysql.jdbc.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 支持自定义SQL查询
 * Created by gongxufan on 2017/3/17.
 */
@Component
public class CustomSqlDao {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public int getMaxColumn(final String filedName, final String tableName) {
        String sql = "select nvl(max(" + filedName + "), 0)  as max_num from " + tableName;
        Map map =  entityManagerFactory.getProperties();
        String dialect = (String) map.get("hibernate.dialect");
        //determine which database use
        if(!StringUtils.isNullOrEmpty(dialect)){
            if(dialect.contains("MySQL")){
                sql = "select ifnull(max(" + filedName + "), 0)  as max_num from " + tableName;
            }
            if(dialect.contains("Oracle")){
                sql = "select nvl(max(" + filedName + "), 0)  as max_num from " + tableName;
            }
        }
        int maxID = 0;
        List<Map<String, Object>> list = this.querySqlObjects(sql);
        if (list.size() > 0) {
            Object maxNum = list.get(0).get("max_num");
            if(maxNum instanceof Number)
                maxID = ((Number)maxNum).intValue();
            if(maxNum instanceof String)
                maxID = Integer.valueOf((String)maxNum);
        }
        return maxID + 1;
    }

    public List<Map<String, Object>> querySqlObjects(String sql, Integer currentPage, Integer rowsInPage) {
        return this.querySqlObjects(sql, null, currentPage, rowsInPage);
    }

    public List<Map<String, Object>> querySqlObjects(String sql) {
        return this.querySqlObjects(sql, null, null, null);
    }

    public List<Map<String, Object>> querySqlObjects(String sql, Map params) {
        return this.querySqlObjects(sql, params, null, null);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> querySqlObjects(String sql, Object params, Integer currentPage, Integer rowsInPage) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query qry = entityManager.createNativeQuery(sql);
        SQLQuery s = qry.unwrap(SQLQuery.class);

        //设置参数
        if (params != null) {
            if (params instanceof List) {
                List<Object> paramList = (List<Object>) params;
                for (int i = 0, size = paramList.size(); i < size; i++) {
                    qry.setParameter(i + 1, paramList.get(i));
                }
            } else if (params instanceof Map) {
                Map<String, Object> paramMap = (Map<String, Object>) params;
                Object o = null;
                for (String key : paramMap.keySet()) {
                    o = paramMap.get(key);
                    if (o != null)
                        qry.setParameter(key, o);
                }
            }
        }

        if (currentPage != null && rowsInPage != null) {//判断是否有分页
            // 起始对象位置
            qry.setFirstResult(rowsInPage * (currentPage - 1));
            // 查询对象个数
            qry.setMaxResults(rowsInPage);
        }
        s.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        try {
            List list = qry.getResultList();
            resultList = s.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return resultList;
    }


    public int getCount(String sql) {
        String sqlCount = "select count(0) as count_num from " + sql;
        List<Map<String, Object>> list = this.querySqlObjects(sqlCount);
        if (list.size() > 0) {
            int countNum = ((BigDecimal) list.get(0).get("COUNT_NUM")).intValue();
            return countNum;
        } else {
            return 0;
        }
    }

    /**
     * 处理sql语句
     *
     * @param _strSql
     * @return
     */
    public String toSql(String _strSql) {
        String strNewSql = _strSql;

        if (strNewSql != null) {
            strNewSql = regReplace("'", "''", strNewSql);
        } else {
            strNewSql = "";
        }

        return strNewSql;
    }

    private String regReplace(String strFind, String strReplacement, String strOld) {
        String strNew = strOld;
        Pattern p = null;
        Matcher m = null;
        try {
            p = Pattern.compile(strFind);
            m = p.matcher(strOld);
            strNew = m.replaceAll(strReplacement);
        } catch (Exception e) {
        }

        return strNew;
    }

    /**
     * 根据hql语句查询数据
     *
     * @param hql
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List queryForList(String hql, List<Object> params) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(hql);
        List list = null;
        try {
            if (params != null && !params.isEmpty()) {
                for (int i = 0, size = params.size(); i < size; i++) {
                    query.setParameter(i + 1, params.get(i));
                }
            }
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return list;
    }

    @SuppressWarnings("rawtypes")
    public List queryByMapParams(String hql, Map<String, Object> params, Integer currentPage, Integer pageSize) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(hql);
        List list = null;
        try {
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }

            if (currentPage != null && pageSize != null) {
                query.setFirstResult((currentPage - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return list;
    }

    @SuppressWarnings("rawtypes")
    public List queryByMapParams(String hql, Map<String, Object> params) {
        return queryByMapParams(hql, params, null, null);
    }

    @SuppressWarnings("rawtypes")
    public List queryForList(String hql) {
        return queryForList(hql, null);
    }


    /**
     * 查询总数
     *
     * @param hql
     * @param params
     * @return
     */
    public Long queryCount(String hql, Map<String, Object> params) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(hql);
        Long count = null;
        try {
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return count;
    }

    /**
     * 查询总数
     *
     * @param sql
     * @param params
     * @return
     */
    public Integer queryCountBySql(String sql, Map<String, Object> params) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Integer count = null;
        try {
            Query query = entityManager.createNativeQuery(sql);
            if (params != null && !params.isEmpty()) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }

            Object obj = query.getSingleResult();
            if (obj instanceof BigDecimal) {
                count = ((BigDecimal) obj).intValue();
            } else {
                count = (Integer) obj;
            }

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return count;
    }

    /**
     * select count(*) from table
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeSql(String sql, List<Object> params) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNativeQuery(sql);
            if (params != null && !params.isEmpty()) {
                for (int i = 0, size = params.size(); i < size; i++) {
                    query.setParameter(i + 1, params.get(i));
                }
            }
            return query.executeUpdate();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
