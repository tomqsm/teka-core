package biz.letsweb.teka.dataaccess.dao;

import biz.letsweb.teka.dataaccess.mappers.PageMapper;
import biz.letsweb.teka.dataaccess.model.Page;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Tomasz
 */
@Service("pagesDao")
public class JdbcPagesDao {

  private NamedParameterJdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public Page findPageByTitle(String title) {
        String sql = "select * from pages where title like :title";
        String t = "%" + title + "%";
        Map<String, Object> params = new HashMap<>();
        params.put("title", t);
        return jdbcTemplate.queryForObject(sql, params, new PageMapper());
    }
}
