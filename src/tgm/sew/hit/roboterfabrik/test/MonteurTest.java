package tgm.sew.hit.roboterfabrik.test;

import org.junit.Before;
import org.junit.Test;
import tgm.sew.hit.roboterfabrik.Bauteil;
import tgm.sew.hit.roboterfabrik.Monteur;
import tgm.sew.hit.roboterfabrik.Roboter;

import static junit.framework.TestCase.assertEquals;

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
	}

	@Test
	public void testGetID() throws Exception {
		assertEquals(1, monteur.getId());
	}

	@Test
	public void testBauen() throws Exception {
		assertEquals(true, this.monteur.bauen(100));
	}

	@Test
	public void testGetRoboter() throws Exception {
		Roboter roboter = new Roboter(verwBauteil, 100, "Mitarbeiter-ID123");
		assertEquals(this.roboter, this.monteur.getRoboter());
	}

	@Test
	public void testSetBauteile() throws Exception {

	}
}