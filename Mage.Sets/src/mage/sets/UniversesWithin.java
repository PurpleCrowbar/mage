package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 * @author TheElk801
 */
public final class UniversesWithin extends ExpansionSet {

    private static final UniversesWithin instance = new UniversesWithin();

    public static UniversesWithin getInstance() {
        return instance;
    }

    private UniversesWithin() {
        super("Universes Within", "SLX", ExpansionSet.buildDate(2022, 3, 3), SetType.SUPPLEMENTAL);
        this.hasBasicLands = false;
        this.hasBoosters = false;

        cards.add(new SetCardInfo("Aisha of Sparks and Smoke", 12, Rarity.RARE, mage.cards.a.AishaOfSparksAndSmoke.class));
        cards.add(new SetCardInfo("Arvinox, the Mind Flail", 1, Rarity.MYTHIC, mage.cards.a.ArvinoxTheMindFlail.class));
        cards.add(new SetCardInfo("Baldin, Century Herdmaster", 10, Rarity.RARE, mage.cards.b.BaldinCenturyHerdmaster.class));
        cards.add(new SetCardInfo("Bohn, Beguiling Balladeer", 30, Rarity.RARE, mage.cards.b.BohnBeguilingBalladeer.class));
        cards.add(new SetCardInfo("Bjorna, Nightfall Alchemist", 2, Rarity.RARE, mage.cards.b.BjornaNightfallAlchemist.class));
        cards.add(new SetCardInfo("Casal, Lurkwood Pathfinder", 29, Rarity.RARE, mage.cards.c.CasalLurkwoodPathfinder.class));
        cards.add(new SetCardInfo("Casal, Pathbreaker Owlbear", 29, Rarity.RARE, mage.cards.c.CasalPathbreakerOwlbear.class));
        cards.add(new SetCardInfo("Cecily, Haunted Mage", 3, Rarity.RARE, mage.cards.c.CecilyHauntedMage.class));
        cards.add(new SetCardInfo("Elmar, Ulvenwald Informant", 4, Rarity.RARE, mage.cards.e.ElmarUlvenwaldInformant.class));
        cards.add(new SetCardInfo("Enkira, Hostile Scavenger", 20, Rarity.MYTHIC, mage.cards.e.EnkiraHostileScavenger.class));
        cards.add(new SetCardInfo("Evin, Waterdeep Opportunist", 26, Rarity.RARE, mage.cards.e.EvinWaterdeepOpportunist.class));
        cards.add(new SetCardInfo("Gisa's Favorite Shovel", 19, Rarity.MYTHIC, mage.cards.g.GisasFavoriteShovel.class));
        cards.add(new SetCardInfo("Gregor, Shrewd Magistrate", 21, Rarity.MYTHIC, mage.cards.g.GregorShrewdMagistrate.class));
        cards.add(new SetCardInfo("Greymond, Avacyn's Stalwart", 18, Rarity.MYTHIC, mage.cards.g.GreymondAvacynsStalwart.class));
        cards.add(new SetCardInfo("Hansk, Slayer Zealot", 22, Rarity.MYTHIC, mage.cards.h.HanskSlayerZealot.class));
        cards.add(new SetCardInfo("Hargilde, Kindly Runechanter", 5, Rarity.RARE, mage.cards.h.HargildeKindlyRunechanter.class));
        cards.add(new SetCardInfo("Havengul Laboratory", 9, Rarity.RARE, mage.cards.h.HavengulLaboratory.class));
        cards.add(new SetCardInfo("Havengul Mystery", 9, Rarity.RARE, mage.cards.h.HavengulMystery.class));
        cards.add(new SetCardInfo("Immard, the Stormcleaver", 14, Rarity.RARE, mage.cards.i.ImmardTheStormcleaver.class));
        cards.add(new SetCardInfo("Jurin, Leading the Charge", 27, Rarity.RARE, mage.cards.j.JurinLeadingTheCharge.class));
        cards.add(new SetCardInfo("Maarika, Brutal Gladiator", 15, Rarity.RARE, mage.cards.m.MaarikaBrutalGladiator.class));
        cards.add(new SetCardInfo("Malik, Grim Manipulator", 23, Rarity.MYTHIC, mage.cards.m.MalikGrimManipulator.class));
        cards.add(new SetCardInfo("Mathise, Surge Channeler", 25, Rarity.RARE, mage.cards.m.MathiseSurgeChanneler.class));
        cards.add(new SetCardInfo("Othelm, Sigardian Outcast", 6, Rarity.RARE, mage.cards.o.OthelmSigardianOutcast.class));
        cards.add(new SetCardInfo("Rashel, Fist of Torm", 24, Rarity.RARE, mage.cards.r.RashelFistOfTorm.class));
        cards.add(new SetCardInfo("Sophina, Spearsage Deserter", 7, Rarity.RARE, mage.cards.s.SophinaSpearsageDeserter.class));
        cards.add(new SetCardInfo("Tadeas, Juniper Ascendant", 16, Rarity.RARE, mage.cards.t.TadeasJuniperAscendant.class));
        cards.add(new SetCardInfo("Themberchaud", 28, Rarity.RARE, mage.cards.t.Themberchaud.class));
        cards.add(new SetCardInfo("The Howling Abomination", 13, Rarity.RARE, mage.cards.t.TheHowlingAbomination.class));
        cards.add(new SetCardInfo("Vikya, Scorching Stalwart", 11, Rarity.RARE, mage.cards.v.VikyaScorchingStalwart.class));
        cards.add(new SetCardInfo("Wernog, Rider's Chaplain", 8, Rarity.RARE, mage.cards.w.WernogRidersChaplain.class));
        cards.add(new SetCardInfo("Zethi, Arcane Blademaster", 17, Rarity.RARE, mage.cards.z.ZethiArcaneBlademaster.class));
    }
}
