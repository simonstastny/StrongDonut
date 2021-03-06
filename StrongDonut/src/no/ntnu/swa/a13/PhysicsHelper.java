package no.ntnu.swa.a13;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;

public class PhysicsHelper {

	public static final String BALL = "BALL";
	public static final String CATAPULT = "TANK";

	public static boolean landHit(Contact contact) {
		return getBall(contact.getFixtureA(), contact.getFixtureB()) != null;
	}

	public static Fixture getBall(Fixture a, Fixture b) {
		Fixture result = null;

		if (a.getBody().getUserData() != null && a.getBody().getUserData().equals(BALL)) {
			result = a;
		} else if (b.getBody().getUserData() != null && b.getBody().getUserData().equals(BALL)) {
			result = b;
		}

		return result;
	}

	public static boolean tankHit(Contact contact) {
		boolean tankPresent = (getTank(contact.getFixtureA(), contact.getFixtureB()) != null);
		boolean ballPresent = (getBall(contact.getFixtureA(), contact.getFixtureB()) != null);
		
		return (tankPresent && ballPresent);
	}

	public static Fixture getTank(Fixture a, Fixture b) {
		Fixture result = null;
		if (a.getBody().getUserData() != null && a.getBody().getUserData().equals(CATAPULT)) {
			result = a;
		} else if (b.getBody().getUserData() != null && b.getBody().getUserData().equals(CATAPULT)) {
			result = b;
		}

		return result;
	}

}
