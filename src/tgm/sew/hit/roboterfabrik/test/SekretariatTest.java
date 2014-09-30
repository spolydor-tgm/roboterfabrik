package tgm.sew.hit.roboterfabrik.test;

import org.junit.Before;
import org.junit.Test;
import tgm.sew.hit.roboterfabrik.Sekretariat;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class SekretariatTest {
	private Sekretariat sekretariat;

	@Before
	public void setUp() {
		sekretariat = new Sekretariat(2);
	}

	@Test
	public void testGetUniqueIDs() throws Exception {
		assertArrayEquals(new int[]{100,101}, this.sekretariat.getUniqueIDs());
	}

	@Test
	public void testGetId() throws Exception {
		assertEquals(1, this.sekretariat.getId());
	}
}