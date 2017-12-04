
public class Dva extends Hero_moreAbstraction{
	static Armor dvaArmor = new Armor(200, 5);
	static HP dvaHP = new HP(400, dvaArmor);
	static HeroInfo dvaInfo = new HeroInfo("D.Va", dvaHP, 5.5);
	Dva(){
		super(dvaInfo);
		PassiveSkill passive = new PassiveSkill();
		UltimateSkill ultimate = new UltimateSkill();
		Skill lMouse = new Skill();
		Skill rMouse = new Skill();
		Skill shift = new Skill();
		Skill e = new Skill();
		SkillSet skillSet = new SkillSet(passive, ultimate, lMouse, rMouse, shift, e);
		super.addSkillSet(skillSet);
	}
}
