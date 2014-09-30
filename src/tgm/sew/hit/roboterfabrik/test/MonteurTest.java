package tgm.sew.hit.roboterfabrik.test;

import org.junit.Before;
import org.junit.Test;
import tgm.sew.hit.roboterfabrik.Bauteil;
import tgm.sew.hit.roboterfabrik.Monteur;
import tgm.sew.hit.roboterfabrik.Roboter;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Stefan Polydor on 30.09.14.
 */
public class MonteurTest {

	private Monteur monteur;
	private Roboter roboter;
	private Bauteil[] verwBauteil;

	@Before
	public void setUp() {
		monteur = new Monteur(1);
		verwBauteil = new Bauteil[6];
		verwBauteil[0] = new Bauteil("arm", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[1] = new Bauteil("arm", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[2] = new Bauteil("auge", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[3] = new Bauteil("auge", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[4] = new Bauteil("rumpf", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		verwBauteil[5] = new Bauteil("kettenantrieb", new int[]{1, 2, 3, 5, 7, 4, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		this.monteur.setBauteile(verwBauteil);
		this.monteur.bauen(100);
		this.roboter = new Roboter(verwBauteil, 100, "Mitarbeiter-ID1");
	}

	@Test
	public void testGetID() throws Exception {
		int i = this.monteur.getID();
		assertEquals(1, i);
	}

	@Test
	public void testBauen() throws Exception {
		assertEquals(true, this.monteur.bauen(100));
	}

	@Test
	public void testGetRoboter() throws Exception {
		assertEquals(this.monteur.getRoboter(), this.monteur.getRoboter());
	}

	@Test
	public void testSetBauteile() throws Exception {
		this.monteur.setBauteile(this.verwBauteil);
		assertArrayEquals(this.verwBauteil, this.verwBauteil);
	}
}