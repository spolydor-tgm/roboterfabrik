package tgm.sew.hit.roboterfabrik.test;

import org.junit.Before;
import org.junit.Test;
import tgm.sew.hit.roboterfabrik.Bauteil;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Stefan Polydor on 30.09.14.
 */
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
	public void testSetSeriennr() {
		this.bauteil[0].setSeriennr(new int[]{2, 1, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		assertArrayEquals(new int[]{2, 1, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, this.bauteil[0].getSeriennr());
	}

	@Test
	public void testIsTypArm() {
		assertEquals(1, this.bauteil[0].isTyp());
	}

	@Test
	public void testIsTypAuge() {
		assertEquals(2, this.bauteil[1].isTyp());
	}

	@Test
	public void testIsTypRumpf() {
		assertEquals(3, this.bauteil[2].isTyp());
	}

	@Test
	public void testIsTypKettenl() {
		assertEquals(4, this.bauteil[3].isTyp());
	}

	@Test
	public void testIsTypFalsch() {
		Bauteil bt = new Bauteil("haha", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		assertEquals(0, bt.isTyp());
	}

	@Test
	public void testGetTyp() {
		assertEquals("arm", this.bauteil[0].getTyp());
	}
}