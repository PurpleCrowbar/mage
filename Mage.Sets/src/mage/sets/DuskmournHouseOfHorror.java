package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 * @author TheElk801
 */
public final class DuskmournHouseOfHorror extends ExpansionSet {

    private static final DuskmournHouseOfHorror instance = new DuskmournHouseOfHorror();

    public static DuskmournHouseOfHorror getInstance() {
        return instance;
    }

    private DuskmournHouseOfHorror() {
        super("Duskmourn: House of Horror", "DSK", ExpansionSet.buildDate(2024, 9, 27), SetType.EXPANSION);
        this.blockName = "Duskmourn: House of Horror"; // for sorting in GUI
        this.hasBasicLands = true;
        this.hasBoosters = false; // temporary

        cards.add(new SetCardInfo("Abandoned Campground", 255, Rarity.COMMON, mage.cards.a.AbandonedCampground.class));
        cards.add(new SetCardInfo("Bleeding Woods", 257, Rarity.COMMON, mage.cards.b.BleedingWoods.class));
        cards.add(new SetCardInfo("Chainsaw", 128, Rarity.RARE, mage.cards.c.Chainsaw.class));
        cards.add(new SetCardInfo("Cursed Recording", 131, Rarity.RARE, mage.cards.c.CursedRecording.class));
        cards.add(new SetCardInfo("Demonic Counsel", 92, Rarity.RARE, mage.cards.d.DemonicCounsel.class));
        cards.add(new SetCardInfo("Disturbing Mirth", 212, Rarity.UNCOMMON, mage.cards.d.DisturbingMirth.class));
        cards.add(new SetCardInfo("Doomsday Excruciator", 94, Rarity.RARE, mage.cards.d.DoomsdayExcruciator.class));
        cards.add(new SetCardInfo("Enduring Curiosity", 51, Rarity.RARE, mage.cards.e.EnduringCuriosity.class));
        cards.add(new SetCardInfo("Enduring Innocence", 6, Rarity.RARE, mage.cards.e.EnduringInnocence.class));
        cards.add(new SetCardInfo("Enduring Tenacity", 95, Rarity.RARE, mage.cards.e.EnduringTenacity.class));
        cards.add(new SetCardInfo("Etched Cornfield", 258, Rarity.COMMON, mage.cards.e.EtchedCornfield.class));
        cards.add(new SetCardInfo("Fear of Failed Tests", 55, Rarity.UNCOMMON, mage.cards.f.FearOfFailedTests.class));
        cards.add(new SetCardInfo("Fear of Immobility", 10, Rarity.COMMON, mage.cards.f.FearOfImmobility.class));
        cards.add(new SetCardInfo("Fear of Isolation", 58, Rarity.UNCOMMON, mage.cards.f.FearOfIsolation.class));
        cards.add(new SetCardInfo("Fear of Lost Teeth", 97, Rarity.COMMON, mage.cards.f.FearOfLostTeeth.class));
        cards.add(new SetCardInfo("Fear of Missing Out", 136, Rarity.RARE, mage.cards.f.FearOfMissingOut.class));
        cards.add(new SetCardInfo("Forest", 276, Rarity.LAND, mage.cards.basiclands.Forest.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Glimmer Seeker", 14, Rarity.UNCOMMON, mage.cards.g.GlimmerSeeker.class));
        cards.add(new SetCardInfo("Island", 273, Rarity.LAND, mage.cards.basiclands.Island.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Lakeside Shack", 262, Rarity.COMMON, mage.cards.l.LakesideShack.class));
        cards.add(new SetCardInfo("Leyline of Hope", 18, Rarity.RARE, mage.cards.l.LeylineOfHope.class));
        cards.add(new SetCardInfo("Mountain", 275, Rarity.LAND, mage.cards.basiclands.Mountain.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Murky Sewer", 263, Rarity.COMMON, mage.cards.m.MurkySewer.class));
        cards.add(new SetCardInfo("Neglected Manor", 264, Rarity.COMMON, mage.cards.n.NeglectedManor.class));
        cards.add(new SetCardInfo("Patched Plaything", 24, Rarity.UNCOMMON, mage.cards.p.PatchedPlaything.class));
        cards.add(new SetCardInfo("Peculiar Lighthouse", 265, Rarity.COMMON, mage.cards.p.PeculiarLighthouse.class));
        cards.add(new SetCardInfo("Peer Past the Veil", 226, Rarity.RARE, mage.cards.p.PeerPastTheVeil.class));
        cards.add(new SetCardInfo("Plains", 272, Rarity.LAND, mage.cards.basiclands.Plains.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Raucous Carnival", 266, Rarity.COMMON, mage.cards.r.RaucousCarnival.class));
        cards.add(new SetCardInfo("Razorkin Needlehead", 153, Rarity.RARE, mage.cards.r.RazorkinNeedlehead.class));
        cards.add(new SetCardInfo("Razortrap Gorge", 267, Rarity.COMMON, mage.cards.r.RazortrapGorge.class));
        cards.add(new SetCardInfo("Scrabbling Skullcrab", 71, Rarity.UNCOMMON, mage.cards.s.ScrabblingSkullcrab.class));
        cards.add(new SetCardInfo("Screaming Nemesis", 157, Rarity.MYTHIC, mage.cards.s.ScreamingNemesis.class));
        cards.add(new SetCardInfo("Split Up", 32, Rarity.RARE, mage.cards.s.SplitUp.class));
        cards.add(new SetCardInfo("Strangled Cemetery", 268, Rarity.COMMON, mage.cards.s.StrangledCemetery.class));
        cards.add(new SetCardInfo("Swamp", 274, Rarity.LAND, mage.cards.basiclands.Swamp.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("The Wandering Rescuer", 41, Rarity.MYTHIC, mage.cards.t.TheWanderingRescuer.class));
        cards.add(new SetCardInfo("Toby, Beastie Befriender", 35, Rarity.RARE, mage.cards.t.TobyBeastieBefriender.class));
        cards.add(new SetCardInfo("Unwanted Remake", 39, Rarity.UNCOMMON, mage.cards.u.UnwantedRemake.class));
        cards.add(new SetCardInfo("Valgavoth's Lair", 271, Rarity.RARE, mage.cards.v.ValgavothsLair.class));
        cards.add(new SetCardInfo("Veteran Survivor", 40, Rarity.UNCOMMON, mage.cards.v.VeteranSurvivor.class));
        cards.add(new SetCardInfo("Winter, Misanthropic Guide", 240, Rarity.RARE, mage.cards.w.WinterMisanthropicGuide.class));
        cards.add(new SetCardInfo("Zimone, All-Questioning", 241, Rarity.RARE, mage.cards.z.ZimoneAllQuestioning.class));
    }
}
