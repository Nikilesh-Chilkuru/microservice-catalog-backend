package edu.iu.uits.mscatalog;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link MicroServiceCatalogApplication}.
 *
 * @author Naveen Jetty
 * @author Andy Wilkinson
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroServiceCatalogApplicationTest {

    @ClassRule
    public static OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        String output = MicroServiceCatalogApplicationTest.outputCapture.toString();
        assertThat(output).contains("title=Micro Service Catalog");
    }

}