package org.ict.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// ������ �������� ������ Connection pool ���� ������ �������� ���ؼ�
// root-context.xml�� ��ġ�� �������ݴϴ�.
@RunWith(SpringJUnit4ClassRunner.class)
// Beans Graph ���ο� �����Ǿ��ִ� dataSource�� ���� ���� ��ġ ����
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class OjdbcConnectionPoolTest {

	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()) {
			log.info(con);
			log.info("hikariCP connection");
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}