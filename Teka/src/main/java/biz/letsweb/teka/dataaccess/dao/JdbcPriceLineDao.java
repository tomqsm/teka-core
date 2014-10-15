package biz.letsweb.teka.dataaccess.dao;

import biz.letsweb.teka.dataaccess.mappers.PriceLineMapper;
import biz.letsweb.teka.dataaccess.model.PriceLine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Tomasz
 */
@Service("pricesDao")
public class JdbcPriceLineDao {

  private NamedParameterJdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public PriceLine findUserById(int id){
        String sql = "select * from teka.prices where id=:id";
        Map<String,Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(sql, params, new PriceLineMapper());
    }

  public List<PriceLine> findAll() {
    String sql = "select * from teka.prices";
    return jdbcTemplate.query(sql, new PriceLineMapper());
  }

  public void deleteById(int id){
      String sql = "delete from teka.prices where id=:id";
      Map<String,Object> params = new HashMap<>();
      params.put("id", id);
      jdbcTemplate.update(sql, params);
  }
}
