package biz.letsweb.teka.dataaccess.mappers;

import biz.letsweb.teka.dataaccess.model.PriceLine;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author Tomasz
 */
public class PriceLineMapper implements RowMapper<PriceLine> {

  @Override
  public PriceLine mapRow(ResultSet rs, int i) throws SQLException {
    PriceLine priceLine = new PriceLine();
    priceLine.setId(rs.getInt("id"));
    priceLine.setService(rs.getString("service"));
    priceLine.setUnit(rs.getString("unit"));
    priceLine.setPriceMin(rs.getDouble("priceMin"));
    priceLine.setPriceMax(rs.getDouble("priceMax"));
    priceLine.setInserted(rs.getTimestamp("inserted"));
    return priceLine;
  }
}
