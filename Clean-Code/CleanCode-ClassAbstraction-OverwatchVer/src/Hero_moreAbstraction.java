import java.util.*;

public abstract class Hero_moreAbstraction {
	HeroInfo info;
	ArrayList<SkillSet> skills;
	
	Hero_moreAbstraction(){}
	
	Hero_moreAbstraction(HeroInfo _info){
		info = _info;
		skills = new ArrayList<SkillSet>();
	}
	
	void addSkillSet(SkillSet skillSet) {
		skills.add(skillSet);
	}
}

class HeroInfo{
	String name;
	HP hp;
	double runSpeed;
	boolean isMultiWeapon;
	
	// default, hero has one weapon.
	HeroInfo(String _name, HP _hp, double _runSpeed){
		name = _name;
		hp = _hp;
		runSpeed = _runSpeed;
		isMultiWeapon = false;
	}
	
	// when hero has more then one weapon. e.g Torbjorn.
	HeroInfo(String _name, HP _hp, double _runSpeed, boolean _isMultiWeapon){
		name = _name;
		hp = _hp;
		runSpeed = _runSpeed;
		isMultiWeapon = _isMultiWeapon;
	}
}

class HP{
	int hp;
	Armor armor;
	Shield shield;
	HP(int hp){
		
	}
	HP(int _hp, Armor _armor){
		hp = _hp;
		armor = _armor;
	}
	HP(int _hp, Armor _armor, Shield _shield){
		hp = _hp;
		armor = _armor;
		shield = _shield;
	}
	HP(int _hp, Shield _shield){
		hp = _hp;
		shield = _shield;
	}
}

class Armor{
	int armor;
	int armorDef;
	Armor(int _armor, int _armorDef){
		armor = _armor;
		armorDef = _armorDef;
	}
}

class Shield{
	int shield;
	int shieldRechargeRate;
	Shield(int _shield, int _shieldRechargeRate){
		shield = _shield;
		shieldRechargeRate = _shieldRechargeRate;
	}
}

class SkillSet{
	PassiveSkill passive;
	UltimateSkill ultimate;
	Skill lMouse;
	Skill rMouse;
	Skill shift;
	Skill space;
	Skill e;
	SkillSet(PassiveSkill _passive, UltimateSkill _ultimate, Skill _lMouse, Skill _rMouse, Skill _e, Skill _shift, Skill _space){
		passive = _passive;
		ultimate = _ultimate;
		lMouse = _lMouse;
		rMouse = _rMouse;
		shift = _shift;
		space = _space;
		e = _e;
	}
	SkillSet(PassiveSkill _passive, UltimateSkill _ultimate, Skill _lMouse, Skill _rMouse, Skill _e, Skill _shift){
		passive = _passive;
		ultimate = _ultimate;
		lMouse = _lMouse;
		rMouse = _rMouse;
		shift = _shift;
		e = _e;
	}
}

class PassiveSkill{
	// TODO - implement
	SkillEffect effect;
}

class Skill{
	KEY activateKey;
	SkillEffect effect;
	// TODO - implement
}

class UltimateSkill extends Skill{
	double fullCharge;
}

class KEY{
	char inputKey; // LMouse Click, Q, E, Shift et cetera.
}

class SkillEffect{
	HashSet<SoundAsset> soundSet;
	// TODO - implement
}

class SoundAsset{
	// TODO - implement 
}