package creditoAlfa.Beans.Util;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class CalculaMeses {

	public Date setMont(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, 1);
		return calendar.getTime();
	}
}
