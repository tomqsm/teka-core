package biz.letsweb.teka;

import biz.letsweb.teka.dataaccess.dao.JdbcChronicleDao;
import biz.letsweb.teka.dataaccess.model.ChronicleLine;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/chron"})
public class ChronController {

  final Logger logger = LoggerFactory.getLogger(ChronController.class);

  @Autowired
  private JdbcChronicleDao chronicleDao;

  @RequestMapping(method = RequestMethod.GET)
  public String sayHello(@RequestParam("tzo") String tzo, ModelMap model, Locale locale) {
    model.addAttribute("date", new Date());
    logger.info("ok here ? {}", tzo);
    ChronicleLine chronicleLine = new ChronicleLine();
    chronicleLine.setLine(tzo);
    chronicleDao.insertRecord(chronicleLine);
    return "index";
  }
}
