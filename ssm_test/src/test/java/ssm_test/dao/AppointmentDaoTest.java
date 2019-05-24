package ssm_test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.su.dao.AppointmentDao;

import ssm_test.BaseTest;

public class AppointmentDaoTest extends BaseTest{
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Test
	public void testInsert() {
		appointmentDao.insertAppointment(1000, 1);
		System.out.println(appointmentDao.queryByKeyWithBook(1000, 1));
	}
}
