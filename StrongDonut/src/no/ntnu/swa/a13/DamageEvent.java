package no.ntnu.swa.a13;

public class DamageEvent extends Event {
	private Player target;
	private Player source;
	private float damage;
	
	public Player getTarget() {
		return target;
	}
	public Player getSource() {
		return source;
	}
	public float getDamage() {
		return damage;
	}
	
	public DamageEvent(Player target, Player source, float damage) {
		super();
		this.target = target;
		this.source = source;
		this.damage = damage;
	}
	
}
