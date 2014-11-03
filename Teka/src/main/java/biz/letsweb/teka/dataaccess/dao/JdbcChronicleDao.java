package biz.letsweb.teka.dataaccess.dao;

import biz.letsweb.teka.dataaccess.mappers.ChronicleMapper;
import biz.letsweb.teka.dataaccess.model.ChronicleLine;
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
@Service("chronicleDao")
public class JdbcChronicleDao {

  private NamedParameterJdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public ChronicleLine findUserById(int id) {
        String sql = "select * from teka.chronicle where id=:id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(sql, params, new ChronicleMapper());
    }

  public List<ChronicleLine> findAll() {
    String sql = "select * from teka.chronicle";
    return jdbcTemplate.query(sql, new ChronicleMapper());
  }

  public void insertRecord(ChronicleLine loggerLine) {
        String sql = "insert into TEKA.chronicle values (DEFAULT, :description, DEFAULT)";
        Map<String, Object> params = new HashMap<>();
        params.put("description", loggerLine.getLine());
        jdbcTemplate.update(sql, params);
    }
  // public void deleteById(int id) {
  // String sql = "delete from teka.users where id=:id";
  // Map<String, Object> params = new HashMap<>();
  // params.put("id", id);
  // jdbcTemplate.update(sql, params);
  // }
}
