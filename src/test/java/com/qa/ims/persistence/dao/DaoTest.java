package com.qa.ims.persistence.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;



import nl.jqno.equalsverifier.EqualsVerifier;

@RunWith(MockitoJUnitRunner.class)
public class DaoTest {
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Dao.class).verify();
	}
	
	
	
}
