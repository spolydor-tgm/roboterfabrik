package tgm.sew.hit.roboterfabrik.test;

import org.junit.Before;
import org.junit.Test;
import tgm.sew.hit.roboterfabrik.Bauteil;
import tgm.sew.hit.roboterfabrik.Roboter;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Stefan Polydor on 30.09.14.
 */
public class RoboterTest {

	private Roboter roboter;
	private Bauteil[] verwBauteil;

	@Before
	public void setUp() {
		verwBauteil = new Bauteil[6];
		verwBauteil[0] = new Bauteil("arm", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[1] = new Bauteil("arm", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[2] = new Bauteil("auge", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[3] = new Bauteil("auge", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[4] = new Bauteil("rumpf", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[5] = new Bauteil("kettenantrieb", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		this.roboter = new Roboter(verwBauteil, 1, "Mitarbeiter-ID123");
	}

	@Test
	public void testGetId() throws Exception {
		assertEquals(this.roboter.getId(), 1);
	}

	@Test
	public void testGetName() throws Exception {
		assertEquals(this.roboter.getName(), "Mitarbeiter-ID123");
	}

	@Test
	public void testGetBauteile() throws Exception {
		assertEquals(this.roboter.getBauteile(), verwBauteil);
	}
}