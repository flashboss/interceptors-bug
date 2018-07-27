package it.vige.injection.test;

import static java.util.logging.Logger.getLogger;
import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.vige.injection.interceptors.ItemServiceBean;

@RunWith(Arquillian.class)
public class InterceptorsTestCase {

	private static final Logger logger = getLogger(InterceptorsTestCase.class.getName());

	@Deployment
	public static JavaArchive createCDIDeployment() {
		final JavaArchive jar = create(JavaArchive.class, "interceptors-cdi-test.jar");
		jar.addPackage(ItemServiceBean.class.getPackage());
		jar.addAsManifestResource(new FileAsset(new File("src/test/resources/META-INF/beans.xml")), "beans.xml");
		return jar;
	}

	@Inject
	private ItemServiceBean itemService;

	@Test
	public void testOk() {
		logger.info("Start Ok test");
		try {
			itemService.ok();
		} catch (EJBException e) {
			fail("test Ok failed");
		}
	}

	@Test
	public void testNotOk() {
		logger.info("Start not Ok test");
		try {
			itemService.notOk();
		} catch (EJBException e) {
			fail("test not Ok failed");
		}
	}
}
