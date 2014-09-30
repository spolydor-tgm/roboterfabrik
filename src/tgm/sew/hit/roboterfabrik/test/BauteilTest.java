package tgm.sew.hit.roboterfabrik.test;

import org.junit.Before;
import org.junit.Test;
import tgm.sew.hit.roboterfabrik.Bauteil;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class BauteilTest {

	private Bauteil[] bauteil;

	@Before
	public void setUp() {
		this.bauteil = new Bauteil[4];
		bauteil[0] = new Bauteil("arm", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		bauteil[1] = new Bauteil("auge", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		bauteil[2] = new Bauteil("rumpf", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		bauteil[3] = new Bauteil("kettenantrieb", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
	}

	@Test
	public void testGetSeriennr() {
		assertArrayEquals(new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, this.bauteil[0].getSeriennr());
	}

	@Test
	public void testGetTypArm() {
		assertEquals("arm", this.bauteil[0].getTyp());
	}

	@Test
	public void testIsTypAuge() {
		assertEquals("auge", this.bauteil[1].getTyp());
	}

	@Test
	public void testIsTypRumpf() {
		assertEquals("rumpf", this.bauteil[2].getTyp());
	}

	@Test
	public void testIsTypKettenl() {
		assertEquals("kettenl", this.bauteil[3].getTyp());
	}
}