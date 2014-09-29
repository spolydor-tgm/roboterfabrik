package tgm.sew.hit.roboterfabrik;

/**
 * Created by Patrick on 29.09.14.
 */
public class Controller {

	public static void main(String[] args) {
		CLI commandlineinterface = new CLI();
		/*
		 * logverzeichnis(commandlineinterface.getLager());
		 *
		 *
		 */
		Lagermitarbeiter lagermit = new Lagermitarbeiter(commandlineinterface.getLager());

	}


}
