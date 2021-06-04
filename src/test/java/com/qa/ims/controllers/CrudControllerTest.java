package com.qa.ims.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CrudController;
import nl.jqno.equalsverifier.EqualsVerifier;

@RunWith(MockitoJUnitRunner.class)
public class CrudControllerTest {
		@Test
		public void testEquals() {
			EqualsVerifier.simple().forClass(CrudController.class).verify();
		}
	}


