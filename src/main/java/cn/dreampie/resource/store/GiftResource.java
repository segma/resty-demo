package cn.dreampie.resource.store;

import cn.dreampie.common.util.Maper;
import cn.dreampie.resource.ApiResource;
import cn.dreampie.resource.store.model.GiftMonthly;
import cn.dreampie.route.core.annotation.API;
import cn.dreampie.route.core.annotation.GET;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by ice on 15-1-22.
 */
@API("/gifts")
public class GiftResource extends ApiResource {

  @GET("/monthlys")
  public Map monthly(String month) {
    if (month == null || "".equals(month)) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
      month = sdf.format(new Date());
    }
    return Maper.of("month", month, "data", GiftMonthly.dao.findBy("date = ? ", month));
  }

}
