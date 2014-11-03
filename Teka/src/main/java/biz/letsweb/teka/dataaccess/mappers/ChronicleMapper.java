package biz.letsweb.teka.dataaccess.mappers;

import biz.letsweb.teka.dataaccess.model.ChronicleLine;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Tomasz
 */
public class ChronicleMapper implements RowMapper<ChronicleLine> {

  @Override
  public ChronicleLine mapRow(ResultSet rs, int i) throws SQLException {
    ChronicleLine chronicleLine = new ChronicleLine();
    chronicleLine.setId(rs.getInt("id"));
    chronicleLine.setLine(rs.getString("description"));
    return chronicleLine;
  }
}
