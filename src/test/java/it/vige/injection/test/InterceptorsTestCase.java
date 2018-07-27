package it.vige.injection.test;

import static java.util.logging.Logger.getLogger;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.vige.injection.interceptors.OK;
import it.vige.injection.service.ItemService;

@RunWith(Arquillian.class)
public class InterceptorsTestCase {

	private static final Logger logger = getLogger(InterceptorsTestCase.class.getName());

	@Deployment
	public static JavaArchive createCDIDeployment() {
		final JavaArchive jar = create(JavaArchive.class, "interceptors-cdi-test.jar");
		jar.addPackage(OK.class.getPackage());
		jar.addPackage(ItemService.class.getPackage());
		jar.addAsManifestResource(new FileAsset(new File("src/test/resources/META-INF/beans.xml")), "beans.xml");
		return jar;
	}

	@Inject
	private ItemService itemService;

	@Test
	public void testInterceptor() {
		logger.info("Start interceptor test");
		String item = "testItem";
		try {
			itemService.create(item);
		} catch (javax.ejb.EJBException e) {
			fail();
		}
	}
}
