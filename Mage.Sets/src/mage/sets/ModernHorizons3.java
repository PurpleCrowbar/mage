package mage.sets;

import mage.cards.Card;
import mage.cards.ExpansionSet;
import mage.cards.repository.CardInfo;
import mage.constants.Rarity;
import mage.constants.SetType;
import mage.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TheElk801
 */
public final class ModernHorizons3 extends ExpansionSet {

    private static final ModernHorizons3 instance = new ModernHorizons3();

    public static ModernHorizons3 getInstance() {
        return instance;
    }

    private ModernHorizons3() {
        super("Modern Horizons 3", "MH3", ExpansionSet.buildDate(2024, 6, 7), SetType.SUPPLEMENTAL_MODERN_LEGAL);
        this.blockName = "Modern Horizons 3";
        this.hasBasicLands = true;
        this.hasBoosters = true;
        this.maxCardNumberInBooster = 319;
        this.numBoosterDoubleFaced = -1;

        cards.add(new SetCardInfo("Abstruse Appropriation", 177, Rarity.RARE, mage.cards.a.AbstruseAppropriation.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Abstruse Appropriation", 342, Rarity.RARE, mage.cards.a.AbstruseAppropriation.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Accursed Marauder", 80, Rarity.COMMON, mage.cards.a.AccursedMarauder.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Accursed Marauder", 405, Rarity.COMMON, mage.cards.a.AccursedMarauder.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Accursed Marauder", 512, Rarity.COMMON, mage.cards.a.AccursedMarauder.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Aerie Auxiliary", 18, Rarity.COMMON, mage.cards.a.AerieAuxiliary.class));
        cards.add(new SetCardInfo("Aether Revolt", 113, Rarity.RARE, mage.cards.a.AetherRevolt.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Aether Revolt", 456, Rarity.RARE, mage.cards.a.AetherRevolt.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Aether Spike", 50, Rarity.COMMON, mage.cards.a.AetherSpike.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Aether Spike", 398, Rarity.COMMON, mage.cards.a.AetherSpike.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Ajani Fells the Godsire", 19, Rarity.UNCOMMON, mage.cards.a.AjaniFellsTheGodsire.class));
        cards.add(new SetCardInfo("Ajani, Nacatl Avenger", 237, Rarity.MYTHIC, mage.cards.a.AjaniNacatlAvenger.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ajani, Nacatl Avenger", 442, Rarity.MYTHIC, mage.cards.a.AjaniNacatlAvenger.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ajani, Nacatl Avenger", 468, Rarity.MYTHIC, mage.cards.a.AjaniNacatlAvenger.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ajani, Nacatl Pariah", 237, Rarity.MYTHIC, mage.cards.a.AjaniNacatlPariah.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ajani, Nacatl Pariah", 442, Rarity.MYTHIC, mage.cards.a.AjaniNacatlPariah.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ajani, Nacatl Pariah", 468, Rarity.MYTHIC, mage.cards.a.AjaniNacatlPariah.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Amped Raptor", 114, Rarity.UNCOMMON, mage.cards.a.AmpedRaptor.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Amped Raptor", 513, Rarity.UNCOMMON, mage.cards.a.AmpedRaptor.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Amphibian Downpour", 51, Rarity.RARE, mage.cards.a.AmphibianDownpour.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Amphibian Downpour", 449, Rarity.RARE, mage.cards.a.AmphibianDownpour.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Angel of the Ruins", 262, Rarity.UNCOMMON, mage.cards.a.AngelOfTheRuins.class));
        cards.add(new SetCardInfo("Annoyed Altisaur", 284, Rarity.UNCOMMON, mage.cards.a.AnnoyedAltisaur.class));
        cards.add(new SetCardInfo("Arcbound Condor", 81, Rarity.UNCOMMON, mage.cards.a.ArcboundCondor.class));
        cards.add(new SetCardInfo("Archway of Innovation", 214, Rarity.RARE, mage.cards.a.ArchwayOfInnovation.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Archway of Innovation", 350, Rarity.RARE, mage.cards.a.ArchwayOfInnovation.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Arena of Glory", 215, Rarity.RARE, mage.cards.a.ArenaOfGlory.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Arena of Glory", 351, Rarity.RARE, mage.cards.a.ArenaOfGlory.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Argent Dais", 20, Rarity.RARE, mage.cards.a.ArgentDais.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Argent Dais", 447, Rarity.RARE, mage.cards.a.ArgentDais.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Arna Kennerud, Skycaptain", 178, Rarity.MYTHIC, mage.cards.a.ArnaKennerudSkycaptain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Arna Kennerud, Skycaptain", 371, Rarity.MYTHIC, mage.cards.a.ArnaKennerudSkycaptain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Arna Kennerud, Skycaptain", 485, Rarity.MYTHIC, mage.cards.a.ArnaKennerudSkycaptain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ashling, Flame Dancer", 115, Rarity.MYTHIC, mage.cards.a.AshlingFlameDancer.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ashling, Flame Dancer", 367, Rarity.MYTHIC, mage.cards.a.AshlingFlameDancer.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ashling, Flame Dancer", 415, Rarity.MYTHIC, mage.cards.a.AshlingFlameDancer.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Ashling, Flame Dancer", 481, Rarity.MYTHIC, mage.cards.a.AshlingFlameDancer.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Barbarian Ring", 299, Rarity.UNCOMMON, mage.cards.b.BarbarianRing.class));
        cards.add(new SetCardInfo("Basking Broodscale", 145, Rarity.COMMON, mage.cards.b.BaskingBroodscale.class));
        cards.add(new SetCardInfo("Bespoke Battlewagon", 52, Rarity.UNCOMMON, mage.cards.b.BespokeBattlewagon.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Bespoke Battlewagon", 510, Rarity.UNCOMMON, mage.cards.b.BespokeBattlewagon.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Birthing Ritual", 146, Rarity.MYTHIC, mage.cards.b.BirthingRitual.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Birthing Ritual", 337, Rarity.MYTHIC, mage.cards.b.BirthingRitual.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Bloodsoaked Insight", 252, Rarity.UNCOMMON, mage.cards.b.BloodsoakedInsight.class));
        cards.add(new SetCardInfo("Bloodstained Mire", 216, Rarity.RARE, mage.cards.b.BloodstainedMire.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Bloodstained Mire", 352, Rarity.RARE, mage.cards.b.BloodstainedMire.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Bloodstained Mire", 435, Rarity.RARE, mage.cards.b.BloodstainedMire.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Bloodstained Mire", 463, Rarity.RARE, mage.cards.b.BloodstainedMire.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Boggart Trawler", 243, Rarity.UNCOMMON, mage.cards.b.BoggartTrawler.class));
        cards.add(new SetCardInfo("Bountiful Landscape", 217, Rarity.COMMON, mage.cards.b.BountifulLandscape.class));
        cards.add(new SetCardInfo("Brainsurge", 53, Rarity.UNCOMMON, mage.cards.b.Brainsurge.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Brainsurge", 399, Rarity.UNCOMMON, mage.cards.b.Brainsurge.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Branching Evolution", 285, Rarity.RARE, mage.cards.b.BranchingEvolution.class));
        cards.add(new SetCardInfo("Breaker of Creation", 1, Rarity.UNCOMMON, mage.cards.b.BreakerOfCreation.class));
        cards.add(new SetCardInfo("Breathe Your Last", 82, Rarity.COMMON, mage.cards.b.BreatheYourLast.class));
        cards.add(new SetCardInfo("Breya, Etherium Shaper", 289, Rarity.MYTHIC, mage.cards.b.BreyaEtheriumShaper.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Breya, Etherium Shaper", 372, Rarity.MYTHIC, mage.cards.b.BreyaEtheriumShaper.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Breya, Etherium Shaper", 486, Rarity.MYTHIC, mage.cards.b.BreyaEtheriumShaper.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Bridgeworks Battle", 249, Rarity.UNCOMMON, mage.cards.b.BridgeworksBattle.class));
        cards.add(new SetCardInfo("Buried Alive", 273, Rarity.UNCOMMON, mage.cards.b.BuriedAlive.class));
        cards.add(new SetCardInfo("Cephalid Coliseum", 300, Rarity.UNCOMMON, mage.cards.c.CephalidColiseum.class));
        cards.add(new SetCardInfo("Charitable Levy", 21, Rarity.UNCOMMON, mage.cards.c.CharitableLevy.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Charitable Levy", 390, Rarity.UNCOMMON, mage.cards.c.CharitableLevy.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Chthonian Nightmare", 83, Rarity.RARE, mage.cards.c.ChthonianNightmare.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Chthonian Nightmare", 330, Rarity.RARE, mage.cards.c.ChthonianNightmare.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Chthonian Nightmare", 406, Rarity.RARE, mage.cards.c.ChthonianNightmare.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Collective Resistance", 147, Rarity.UNCOMMON, mage.cards.c.CollectiveResistance.class));
        cards.add(new SetCardInfo("Colossal Dreadmask", 148, Rarity.COMMON, mage.cards.c.ColossalDreadmask.class));
        cards.add(new SetCardInfo("Conduit Goblin", 179, Rarity.COMMON, mage.cards.c.ConduitGoblin.class));
        cards.add(new SetCardInfo("Consign to Memory", 54, Rarity.UNCOMMON, mage.cards.c.ConsignToMemory.class));
        cards.add(new SetCardInfo("Consuming Corruption", 84, Rarity.UNCOMMON, mage.cards.c.ConsumingCorruption.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Consuming Corruption", 407, Rarity.UNCOMMON, mage.cards.c.ConsumingCorruption.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Contaminated Landscape", 218, Rarity.COMMON, mage.cards.c.ContaminatedLandscape.class));
        cards.add(new SetCardInfo("Copycrook", 55, Rarity.UNCOMMON, mage.cards.c.Copycrook.class));
        cards.add(new SetCardInfo("Corrupted Shapeshifter", 56, Rarity.COMMON, mage.cards.c.CorruptedShapeshifter.class));
        cards.add(new SetCardInfo("Crabomination", 85, Rarity.RARE, mage.cards.c.Crabomination.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Crabomination", 452, Rarity.RARE, mage.cards.c.Crabomination.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Cranial Ram", 180, Rarity.COMMON, mage.cards.c.CranialRam.class));
        cards.add(new SetCardInfo("Cursed Mirror", 279, Rarity.RARE, mage.cards.c.CursedMirror.class));
        cards.add(new SetCardInfo("Cursed Wombat", 181, Rarity.UNCOMMON, mage.cards.c.CursedWombat.class));
        cards.add(new SetCardInfo("Cyclops Superconductor", 182, Rarity.COMMON, mage.cards.c.CyclopsSuperconductor.class));
        cards.add(new SetCardInfo("Deceptive Landscape", 219, Rarity.COMMON, mage.cards.d.DeceptiveLandscape.class));
        cards.add(new SetCardInfo("Decree of Justice", 263, Rarity.UNCOMMON, mage.cards.d.DecreeOfJustice.class));
        cards.add(new SetCardInfo("Deem Inferior", 57, Rarity.COMMON, mage.cards.d.DeemInferior.class));
        cards.add(new SetCardInfo("Deep Analysis", 268, Rarity.UNCOMMON, mage.cards.d.DeepAnalysis.class));
        cards.add(new SetCardInfo("Depth Defiler", 58, Rarity.UNCOMMON, mage.cards.d.DepthDefiler.class));
        cards.add(new SetCardInfo("Deserted Temple", 301, Rarity.RARE, mage.cards.d.DesertedTemple.class));
        cards.add(new SetCardInfo("Detective's Phoenix", 116, Rarity.RARE, mage.cards.d.DetectivesPhoenix.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Detective's Phoenix", 457, Rarity.RARE, mage.cards.d.DetectivesPhoenix.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Devourer of Destiny", 2, Rarity.RARE, mage.cards.d.DevourerOfDestiny.class));
        cards.add(new SetCardInfo("Disciple of Freyalise", 250, Rarity.UNCOMMON, mage.cards.d.DiscipleOfFreyalise.class));
        cards.add(new SetCardInfo("Disruptor Flute", 209, Rarity.RARE, mage.cards.d.DisruptorFlute.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Disruptor Flute", 461, Rarity.RARE, mage.cards.d.DisruptorFlute.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Distinguished Conjurer", 264, Rarity.UNCOMMON, mage.cards.d.DistinguishedConjurer.class));
        cards.add(new SetCardInfo("Dog Umbra", 22, Rarity.COMMON, mage.cards.d.DogUmbra.class));
        cards.add(new SetCardInfo("Dreadmobile", 87, Rarity.UNCOMMON, mage.cards.d.Dreadmobile.class));
        cards.add(new SetCardInfo("Dreamdrinker Vampire", 88, Rarity.COMMON, mage.cards.d.DreamdrinkerVampire.class));
        cards.add(new SetCardInfo("Dreamtide Whale", 59, Rarity.RARE, mage.cards.d.DreamtideWhale.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Dreamtide Whale", 450, Rarity.RARE, mage.cards.d.DreamtideWhale.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Drossclaw", 89, Rarity.COMMON, mage.cards.d.Drossclaw.class));
        cards.add(new SetCardInfo("Drowner of Truth", 253, Rarity.UNCOMMON, mage.cards.d.DrownerOfTruth.class));
        cards.add(new SetCardInfo("Drownyard Lurker", 3, Rarity.COMMON, mage.cards.d.DrownyardLurker.class));
        cards.add(new SetCardInfo("Echoes of Eternity", 4, Rarity.RARE, mage.cards.e.EchoesOfEternity.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Echoes of Eternity", 320, Rarity.RARE, mage.cards.e.EchoesOfEternity.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Eladamri, Korvecdal", 149, Rarity.MYTHIC, mage.cards.e.EladamriKorvecdal.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Eladamri, Korvecdal", 369, Rarity.MYTHIC, mage.cards.e.EladamriKorvecdal.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Eladamri, Korvecdal", 423, Rarity.MYTHIC, mage.cards.e.EladamriKorvecdal.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Eladamri, Korvecdal", 483, Rarity.MYTHIC, mage.cards.e.EladamriKorvecdal.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Eldrazi Linebreaker", 117, Rarity.RARE, mage.cards.e.EldraziLinebreaker.class));
        cards.add(new SetCardInfo("Eldrazi Ravager", 5, Rarity.UNCOMMON, mage.cards.e.EldraziRavager.class));
        cards.add(new SetCardInfo("Eldrazi Repurposer", 150, Rarity.COMMON, mage.cards.e.EldraziRepurposer.class));
        cards.add(new SetCardInfo("Electrozoa", 60, Rarity.COMMON, mage.cards.e.Electrozoa.class));
        cards.add(new SetCardInfo("Emerald Medallion", 291, Rarity.RARE, mage.cards.e.EmeraldMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Emerald Medallion", 345, Rarity.RARE, mage.cards.e.EmeraldMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Emissary of Soulfire", 183, Rarity.UNCOMMON, mage.cards.e.EmissaryOfSoulfire.class));
        cards.add(new SetCardInfo("Emperor of Bones", 90, Rarity.RARE, mage.cards.e.EmperorOfBones.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Emperor of Bones", 453, Rarity.RARE, mage.cards.e.EmperorOfBones.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Emrakul's Messenger", 61, Rarity.UNCOMMON, mage.cards.e.EmrakulsMessenger.class));
        cards.add(new SetCardInfo("Emrakul, the World Anew", 6, Rarity.MYTHIC, mage.cards.e.EmrakulTheWorldAnew.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Emrakul, the World Anew", 381, Rarity.MYTHIC, mage.cards.e.EmrakulTheWorldAnew.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Emrakul, the World Anew", "381z", Rarity.MYTHIC, mage.cards.e.EmrakulTheWorldAnew.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Emrakul, the World Anew", 384, Rarity.MYTHIC, mage.cards.e.EmrakulTheWorldAnew.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Emrakul, the World Anew", 473, Rarity.MYTHIC, mage.cards.e.EmrakulTheWorldAnew.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Envoy of the Ancestors", 23, Rarity.UNCOMMON, mage.cards.e.EnvoyOfTheAncestors.class));
        cards.add(new SetCardInfo("Essence Reliquary", 24, Rarity.UNCOMMON, mage.cards.e.EssenceReliquary.class));
        cards.add(new SetCardInfo("Estrid's Invocation", 269, Rarity.RARE, mage.cards.e.EstridsInvocation.class));
        cards.add(new SetCardInfo("Etched Slith", 91, Rarity.UNCOMMON, mage.cards.e.EtchedSlith.class));
        cards.add(new SetCardInfo("Etherium Pteramander", 92, Rarity.UNCOMMON, mage.cards.e.EtheriumPteramander.class));
        cards.add(new SetCardInfo("Eviscerator's Insight", 93, Rarity.COMMON, mage.cards.e.EvisceratorsInsight.class));
        cards.add(new SetCardInfo("Evolution Witness", 151, Rarity.COMMON, mage.cards.e.EvolutionWitness.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Evolution Witness", 424, Rarity.COMMON, mage.cards.e.EvolutionWitness.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Expanding Ooze", 184, Rarity.COMMON, mage.cards.e.ExpandingOoze.class));
        cards.add(new SetCardInfo("Expel the Unworthy", 25, Rarity.COMMON, mage.cards.e.ExpelTheUnworthy.class));
        cards.add(new SetCardInfo("Faithful Watchdog", 185, Rarity.COMMON, mage.cards.f.FaithfulWatchdog.class));
        cards.add(new SetCardInfo("Fanatic of Rhonas", 152, Rarity.RARE, mage.cards.f.FanaticOfRhonas.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Fanatic of Rhonas", 458, Rarity.RARE, mage.cards.f.FanaticOfRhonas.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Fanged Flames", 118, Rarity.COMMON, mage.cards.f.FangedFlames.class));
        cards.add(new SetCardInfo("Fangs of Kalonia", 153, Rarity.UNCOMMON, mage.cards.f.FangsOfKalonia.class));
        cards.add(new SetCardInfo("Fell the Profane", 244, Rarity.UNCOMMON, mage.cards.f.FellTheProfane.class));
        cards.add(new SetCardInfo("Fetid Gargantua", 94, Rarity.COMMON, mage.cards.f.FetidGargantua.class));
        cards.add(new SetCardInfo("Flare of Cultivation", 154, Rarity.RARE, mage.cards.f.FlareOfCultivation.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Cultivation", 338, Rarity.RARE, mage.cards.f.FlareOfCultivation.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Cultivation", 425, Rarity.RARE, mage.cards.f.FlareOfCultivation.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Denial", 62, Rarity.RARE, mage.cards.f.FlareOfDenial.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Denial", 326, Rarity.RARE, mage.cards.f.FlareOfDenial.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Denial", 400, Rarity.RARE, mage.cards.f.FlareOfDenial.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Duplication", 119, Rarity.RARE, mage.cards.f.FlareOfDuplication.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Duplication", 333, Rarity.RARE, mage.cards.f.FlareOfDuplication.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Duplication", 416, Rarity.RARE, mage.cards.f.FlareOfDuplication.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Fortitude", 26, Rarity.RARE, mage.cards.f.FlareOfFortitude.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Fortitude", 321, Rarity.RARE, mage.cards.f.FlareOfFortitude.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Fortitude", 391, Rarity.RARE, mage.cards.f.FlareOfFortitude.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Malice", 95, Rarity.RARE, mage.cards.f.FlareOfMalice.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Malice", 331, Rarity.RARE, mage.cards.f.FlareOfMalice.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flare of Malice", 408, Rarity.RARE, mage.cards.f.FlareOfMalice.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Fledgling Dragon", 280, Rarity.UNCOMMON, mage.cards.f.FledglingDragon.class));
        cards.add(new SetCardInfo("Flooded Strand", 220, Rarity.RARE, mage.cards.f.FloodedStrand.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flooded Strand", 353, Rarity.RARE, mage.cards.f.FloodedStrand.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flooded Strand", 436, Rarity.RARE, mage.cards.f.FloodedStrand.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Flooded Strand", 464, Rarity.RARE, mage.cards.f.FloodedStrand.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Flusterstorm", 496, Rarity.RARE, mage.cards.f.Flusterstorm.class, RETRO_ART));
        cards.add(new SetCardInfo("Foreboding Landscape", 221, Rarity.COMMON, mage.cards.f.ForebodingLandscape.class));
        cards.add(new SetCardInfo("Forest", 308, Rarity.LAND, mage.cards.basiclands.Forest.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Forest", 318, Rarity.LAND, mage.cards.basiclands.Forest.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Forest", 319, Rarity.LAND, mage.cards.basiclands.Forest.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Forest", 505, Rarity.LAND, mage.cards.basiclands.Forest.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Forest", 506, Rarity.LAND, mage.cards.basiclands.Forest.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Fowl Strike", 155, Rarity.COMMON, mage.cards.f.FowlStrike.class));
        cards.add(new SetCardInfo("Frogmyr Enforcer", 120, Rarity.UNCOMMON, mage.cards.f.FrogmyrEnforcer.class));
        cards.add(new SetCardInfo("Furnace Hellkite", 121, Rarity.UNCOMMON, mage.cards.f.FurnaceHellkite.class));
        cards.add(new SetCardInfo("Galvanic Discharge", 122, Rarity.COMMON, mage.cards.g.GalvanicDischarge.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Galvanic Discharge", 417, Rarity.COMMON, mage.cards.g.GalvanicDischarge.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Genku, Future Shaper", 186, Rarity.RARE, mage.cards.g.GenkuFutureShaper.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Genku, Future Shaper", 373, Rarity.RARE, mage.cards.g.GenkuFutureShaper.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Genku, Future Shaper", 487, Rarity.RARE, mage.cards.g.GenkuFutureShaper.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ghostfire Slice", 123, Rarity.UNCOMMON, mage.cards.g.GhostfireSlice.class));
        cards.add(new SetCardInfo("Gift of the Viper", 156, Rarity.COMMON, mage.cards.g.GiftOfTheViper.class));
        cards.add(new SetCardInfo("Glaring Fleshraker", 7, Rarity.UNCOMMON, mage.cards.g.GlaringFleshraker.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Glaring Fleshraker", 507, Rarity.UNCOMMON, mage.cards.g.GlaringFleshraker.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Glasswing Grace", 254, Rarity.UNCOMMON, mage.cards.g.GlasswingGrace.class));
        cards.add(new SetCardInfo("Glimpse the Impossible", 124, Rarity.COMMON, mage.cards.g.GlimpseTheImpossible.class));
        cards.add(new SetCardInfo("Glyph Elemental", 27, Rarity.UNCOMMON, mage.cards.g.GlyphElemental.class));
        cards.add(new SetCardInfo("Golden-Tail Trainer", 187, Rarity.UNCOMMON, mage.cards.g.GoldenTailTrainer.class));
        cards.add(new SetCardInfo("Gravedig", 96, Rarity.COMMON, mage.cards.g.Gravedig.class));
        cards.add(new SetCardInfo("Grim Servant", 97, Rarity.UNCOMMON, mage.cards.g.GrimServant.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Grim Servant", 409, Rarity.UNCOMMON, mage.cards.g.GrimServant.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Grist, the Plague Swarm", 251, Rarity.MYTHIC, mage.cards.g.GristThePlagueSwarm.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Grist, the Plague Swarm", 446, Rarity.MYTHIC, mage.cards.g.GristThePlagueSwarm.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Grist, the Plague Swarm", 472, Rarity.MYTHIC, mage.cards.g.GristThePlagueSwarm.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Grist, Voracious Larva", 251, Rarity.MYTHIC, mage.cards.g.GristVoraciousLarva.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Grist, Voracious Larva", 446, Rarity.MYTHIC, mage.cards.g.GristVoraciousLarva.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Grist, Voracious Larva", 472, Rarity.MYTHIC, mage.cards.g.GristVoraciousLarva.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Guardian of the Forgotten", 28, Rarity.UNCOMMON, mage.cards.g.GuardianOfTheForgotten.class));
        cards.add(new SetCardInfo("Guide of Souls", 29, Rarity.RARE, mage.cards.g.GuideOfSouls.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Guide of Souls", 448, Rarity.RARE, mage.cards.g.GuideOfSouls.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Harbinger of the Seas", 63, Rarity.RARE, mage.cards.h.HarbingerOfTheSeas.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Harbinger of the Seas", 451, Rarity.RARE, mage.cards.h.HarbingerOfTheSeas.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Herigast, Erupting Nullkite", 8, Rarity.MYTHIC, mage.cards.h.HerigastEruptingNullkite.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Herigast, Erupting Nullkite", 362, Rarity.MYTHIC, mage.cards.h.HerigastEruptingNullkite.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Herigast, Erupting Nullkite", 474, Rarity.MYTHIC, mage.cards.h.HerigastEruptingNullkite.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Hexgold Slith", 30, Rarity.COMMON, mage.cards.h.HexgoldSlith.class));
        cards.add(new SetCardInfo("Hope-Ender Coatl", 64, Rarity.UNCOMMON, mage.cards.h.HopeEnderCoatl.class));
        cards.add(new SetCardInfo("Horrid Shadowspinner", 188, Rarity.UNCOMMON, mage.cards.h.HorridShadowspinner.class));
        cards.add(new SetCardInfo("Horrific Assault", 157, Rarity.COMMON, mage.cards.h.HorrificAssault.class));
        cards.add(new SetCardInfo("Hydra Trainer", 159, Rarity.UNCOMMON, mage.cards.h.HydraTrainer.class));
        cards.add(new SetCardInfo("Hydroelectric Specimen", 240, Rarity.UNCOMMON, mage.cards.h.HydroelectricSpecimen.class));
        cards.add(new SetCardInfo("Idol of False Gods", 210, Rarity.UNCOMMON, mage.cards.i.IdolOfFalseGods.class));
        cards.add(new SetCardInfo("Imskir Iron-Eater", 189, Rarity.RARE, mage.cards.i.ImskirIronEater.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Imskir Iron-Eater", 374, Rarity.RARE, mage.cards.i.ImskirIronEater.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Imskir Iron-Eater", 431, Rarity.RARE, mage.cards.i.ImskirIronEater.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Imskir Iron-Eater", 488, Rarity.RARE, mage.cards.i.ImskirIronEater.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Indebted Spirit", 31, Rarity.UNCOMMON, mage.cards.i.IndebtedSpirit.class));
        cards.add(new SetCardInfo("Infernal Captor", 125, Rarity.COMMON, mage.cards.i.InfernalCaptor.class));
        cards.add(new SetCardInfo("Inspired Inventor", 32, Rarity.COMMON, mage.cards.i.InspiredInventor.class));
        cards.add(new SetCardInfo("Inventor's Axe", 126, Rarity.COMMON, mage.cards.i.InventorsAxe.class));
        cards.add(new SetCardInfo("Invert Polarity", 190, Rarity.RARE, mage.cards.i.InvertPolarity.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Invert Polarity", 459, Rarity.RARE, mage.cards.i.InvertPolarity.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Island", 305, Rarity.LAND, mage.cards.basiclands.Island.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Island", 312, Rarity.LAND, mage.cards.basiclands.Island.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Island", 313, Rarity.LAND, mage.cards.basiclands.Island.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Island", 499, Rarity.LAND, mage.cards.basiclands.Island.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Island", 500, Rarity.LAND, mage.cards.basiclands.Island.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("It That Heralds the End", 9, Rarity.UNCOMMON, mage.cards.i.ItThatHeraldsTheEnd.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("It That Heralds the End", 385, Rarity.UNCOMMON, mage.cards.i.ItThatHeraldsTheEnd.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Izzet Generatorium", 191, Rarity.UNCOMMON, mage.cards.i.IzzetGeneratorium.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Izzet Generatorium", 515, Rarity.UNCOMMON, mage.cards.i.IzzetGeneratorium.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Jet Medallion", 292, Rarity.RARE, mage.cards.j.JetMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Jet Medallion", 346, Rarity.RARE, mage.cards.j.JetMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Jolted Awake", 33, Rarity.COMMON, mage.cards.j.JoltedAwake.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Jolted Awake", 392, Rarity.COMMON, mage.cards.j.JoltedAwake.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Jolted Awake", 509, Rarity.COMMON, mage.cards.j.JoltedAwake.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Junk Diver", 293, Rarity.UNCOMMON, mage.cards.j.JunkDiver.class));
        cards.add(new SetCardInfo("K'rrik, Son of Yawgmoth", 274, Rarity.RARE, mage.cards.k.KrrikSonOfYawgmoth.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("K'rrik, Son of Yawgmoth", 365, Rarity.RARE, mage.cards.k.KrrikSonOfYawgmoth.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("K'rrik, Son of Yawgmoth", 479, Rarity.RARE, mage.cards.k.KrrikSonOfYawgmoth.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kaalia of the Vast", 290, Rarity.MYTHIC, mage.cards.k.KaaliaOfTheVast.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kaalia of the Vast", 343, Rarity.MYTHIC, mage.cards.k.KaaliaOfTheVast.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kaalia of the Vast", 375, Rarity.MYTHIC, mage.cards.k.KaaliaOfTheVast.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kaalia of the Vast", 489, Rarity.MYTHIC, mage.cards.k.KaaliaOfTheVast.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kami of Jealous Thirst", 98, Rarity.COMMON, mage.cards.k.KamiOfJealousThirst.class));
        cards.add(new SetCardInfo("Kappa Cannoneer", 270, Rarity.RARE, mage.cards.k.KappaCannoneer.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kappa Cannoneer", 401, Rarity.RARE, mage.cards.k.KappaCannoneer.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Kozilek's Command", 11, Rarity.RARE, mage.cards.k.KozileksCommand.class));
        cards.add(new SetCardInfo("Kozilek's Unsealing", 65, Rarity.UNCOMMON, mage.cards.k.KozileksUnsealing.class));
        cards.add(new SetCardInfo("Kozilek, the Broken Reality", 10, Rarity.MYTHIC, mage.cards.k.KozilekTheBrokenReality.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kozilek, the Broken Reality", 382, Rarity.MYTHIC, mage.cards.k.KozilekTheBrokenReality.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kozilek, the Broken Reality", "382z", Rarity.MYTHIC, mage.cards.k.KozilekTheBrokenReality.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kozilek, the Broken Reality", 386, Rarity.MYTHIC, mage.cards.k.KozilekTheBrokenReality.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Kozilek, the Broken Reality", 475, Rarity.MYTHIC, mage.cards.k.KozilekTheBrokenReality.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kudo, King Among Bears", 192, Rarity.RARE, mage.cards.k.KudoKingAmongBears.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kudo, King Among Bears", 376, Rarity.RARE, mage.cards.k.KudoKingAmongBears.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Kudo, King Among Bears", 432, Rarity.RARE, mage.cards.k.KudoKingAmongBears.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Kudo, King Among Bears", 490, Rarity.RARE, mage.cards.k.KudoKingAmongBears.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Laelia, the Blade Reforged", 281, Rarity.RARE, mage.cards.l.LaeliaTheBladeReforged.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Laelia, the Blade Reforged", 368, Rarity.RARE, mage.cards.l.LaeliaTheBladeReforged.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Laelia, the Blade Reforged", 482, Rarity.RARE, mage.cards.l.LaeliaTheBladeReforged.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Legion Leadership", 255, Rarity.UNCOMMON, mage.cards.l.LegionLeadership.class));
        cards.add(new SetCardInfo("Lethal Throwdown", 99, Rarity.UNCOMMON, mage.cards.l.LethalThrowdown.class));
        cards.add(new SetCardInfo("Lion Umbra", 160, Rarity.UNCOMMON, mage.cards.l.LionUmbra.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Lion Umbra", 426, Rarity.UNCOMMON, mage.cards.l.LionUmbra.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Malevolent Rumble", 161, Rarity.COMMON, mage.cards.m.MalevolentRumble.class));
        cards.add(new SetCardInfo("Mandibular Kite", 34, Rarity.COMMON, mage.cards.m.MandibularKite.class));
        cards.add(new SetCardInfo("Marionette Apprentice", 100, Rarity.UNCOMMON, mage.cards.m.MarionetteApprentice.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Marionette Apprentice", 410, Rarity.UNCOMMON, mage.cards.m.MarionetteApprentice.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Meltdown", 282, Rarity.UNCOMMON, mage.cards.m.Meltdown.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Meltdown", 418, Rarity.UNCOMMON, mage.cards.m.Meltdown.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Metastatic Evangel", 35, Rarity.UNCOMMON, mage.cards.m.MetastaticEvangel.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Metastatic Evangel", 393, Rarity.UNCOMMON, mage.cards.m.MetastaticEvangel.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Meteoric Mace", 283, Rarity.UNCOMMON, mage.cards.m.MeteoricMace.class));
        cards.add(new SetCardInfo("Mindless Conscription", 101, Rarity.UNCOMMON, mage.cards.m.MindlessConscription.class));
        cards.add(new SetCardInfo("Mogg Mob", 127, Rarity.UNCOMMON, mage.cards.m.MoggMob.class));
        cards.add(new SetCardInfo("Molten Gatekeeper", 128, Rarity.COMMON, mage.cards.m.MoltenGatekeeper.class));
        cards.add(new SetCardInfo("Monstrous Vortex", 162, Rarity.UNCOMMON, mage.cards.m.MonstrousVortex.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Monstrous Vortex", 427, Rarity.UNCOMMON, mage.cards.m.MonstrousVortex.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Monumental Henge", 222, Rarity.RARE, mage.cards.m.MonumentalHenge.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Monumental Henge", 354, Rarity.RARE, mage.cards.m.MonumentalHenge.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Mountain", 307, Rarity.LAND, mage.cards.basiclands.Mountain.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Mountain", 316, Rarity.LAND, mage.cards.basiclands.Mountain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Mountain", 317, Rarity.LAND, mage.cards.basiclands.Mountain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Mountain", 503, Rarity.LAND, mage.cards.basiclands.Mountain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Mountain", 504, Rarity.LAND, mage.cards.basiclands.Mountain.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Muster the Departed", 36, Rarity.UNCOMMON, mage.cards.m.MusterTheDeparted.class));
        cards.add(new SetCardInfo("Nadier's Nightblade", 275, Rarity.UNCOMMON, mage.cards.n.NadiersNightblade.class));
        cards.add(new SetCardInfo("Nadu, Winged Wisdom", 193, Rarity.RARE, mage.cards.n.NaduWingedWisdom.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Nadu, Winged Wisdom", 377, Rarity.RARE, mage.cards.n.NaduWingedWisdom.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Nadu, Winged Wisdom", 491, Rarity.RARE, mage.cards.n.NaduWingedWisdom.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Necrodominance", 102, Rarity.MYTHIC, mage.cards.n.Necrodominance.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Necrodominance", 411, Rarity.MYTHIC, mage.cards.n.Necrodominance.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Nesting Grounds", 302, Rarity.UNCOMMON, mage.cards.n.NestingGrounds.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Nesting Grounds", 437, Rarity.UNCOMMON, mage.cards.n.NestingGrounds.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Nethergoyf", 103, Rarity.MYTHIC, mage.cards.n.Nethergoyf.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Nethergoyf", 454, Rarity.MYTHIC, mage.cards.n.Nethergoyf.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Nightshade Dryad", 163, Rarity.COMMON, mage.cards.n.NightshadeDryad.class));
        cards.add(new SetCardInfo("Null Elemental Blast", 12, Rarity.UNCOMMON, mage.cards.n.NullElementalBlast.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Null Elemental Blast", 387, Rarity.UNCOMMON, mage.cards.n.NullElementalBlast.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Nulldrifter", 13, Rarity.RARE, mage.cards.n.Nulldrifter.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Nulldrifter", 388, Rarity.RARE, mage.cards.n.Nulldrifter.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Nyxborn Hydra", 164, Rarity.COMMON, mage.cards.n.NyxbornHydra.class));
        cards.add(new SetCardInfo("Nyxborn Unicorn", 37, Rarity.COMMON, mage.cards.n.NyxbornUnicorn.class));
        cards.add(new SetCardInfo("Obstinate Gargoyle", 195, Rarity.COMMON, mage.cards.o.ObstinateGargoyle.class));
        cards.add(new SetCardInfo("Ocelot Pride", 38, Rarity.MYTHIC, mage.cards.o.OcelotPride.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ocelot Pride", 322, Rarity.MYTHIC, mage.cards.o.OcelotPride.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ocelot Pride", 394, Rarity.MYTHIC, mage.cards.o.OcelotPride.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Ondu Knotmaster", 196, Rarity.UNCOMMON, mage.cards.o.OnduKnotmaster.class));
        cards.add(new SetCardInfo("Ophiomancer", 276, Rarity.RARE, mage.cards.o.Ophiomancer.class));
        cards.add(new SetCardInfo("Orim's Chant", 265, Rarity.RARE, mage.cards.o.OrimsChant.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Orim's Chant", 323, Rarity.RARE, mage.cards.o.OrimsChant.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Party Thrasher", 129, Rarity.RARE, mage.cards.p.PartyThrasher.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Party Thrasher", 334, Rarity.RARE, mage.cards.p.PartyThrasher.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Party Thrasher", 419, Rarity.RARE, mage.cards.p.PartyThrasher.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Path of Annihilation", 165, Rarity.UNCOMMON, mage.cards.p.PathOfAnnihilation.class));
        cards.add(new SetCardInfo("Pearl Medallion", 294, Rarity.RARE, mage.cards.p.PearlMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Pearl Medallion", 347, Rarity.RARE, mage.cards.p.PearlMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Pearl-Ear, Imperial Advisor", 39, Rarity.RARE, mage.cards.p.PearlEarImperialAdvisor.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Pearl-Ear, Imperial Advisor", 363, Rarity.RARE, mage.cards.p.PearlEarImperialAdvisor.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Pearl-Ear, Imperial Advisor", 477, Rarity.RARE, mage.cards.p.PearlEarImperialAdvisor.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Perilous Landscape", 223, Rarity.COMMON, mage.cards.p.PerilousLandscape.class));
        cards.add(new SetCardInfo("Petrifying Meddler", 66, Rarity.COMMON, mage.cards.p.PetrifyingMeddler.class));
        cards.add(new SetCardInfo("Phelia, Exuberant Shepherd", 40, Rarity.RARE, mage.cards.p.PheliaExuberantShepherd.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Phelia, Exuberant Shepherd", 364, Rarity.RARE, mage.cards.p.PheliaExuberantShepherd.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Phelia, Exuberant Shepherd", 478, Rarity.RARE, mage.cards.p.PheliaExuberantShepherd.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Phlage, Titan of Fire's Fury", 197, Rarity.MYTHIC, mage.cards.p.PhlageTitanOfFiresFury.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Phlage, Titan of Fire's Fury", 379, Rarity.MYTHIC, mage.cards.p.PhlageTitanOfFiresFury.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Phlage, Titan of Fire's Fury", 493, Rarity.MYTHIC, mage.cards.p.PhlageTitanOfFiresFury.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Phyrexian Ironworks", 130, Rarity.UNCOMMON, mage.cards.p.PhyrexianIronworks.class));
        cards.add(new SetCardInfo("Phyrexian Tower", 303, Rarity.MYTHIC, mage.cards.p.PhyrexianTower.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Phyrexian Tower", 355, Rarity.MYTHIC, mage.cards.p.PhyrexianTower.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Pinnacle Monk", 246, Rarity.UNCOMMON, mage.cards.p.PinnacleMonk.class));
        cards.add(new SetCardInfo("Plains", 304, Rarity.LAND, mage.cards.basiclands.Plains.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Plains", 310, Rarity.LAND, mage.cards.basiclands.Plains.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Plains", 311, Rarity.LAND, mage.cards.basiclands.Plains.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Plains", 497, Rarity.LAND, mage.cards.basiclands.Plains.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Plains", 498, Rarity.LAND, mage.cards.basiclands.Plains.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Planar Genesis", 198, Rarity.UNCOMMON, mage.cards.p.PlanarGenesis.class));
        cards.add(new SetCardInfo("Polluted Delta", 224, Rarity.RARE, mage.cards.p.PollutedDelta.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Polluted Delta", 356, Rarity.RARE, mage.cards.p.PollutedDelta.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Polluted Delta", 438, Rarity.RARE, mage.cards.p.PollutedDelta.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Polluted Delta", 465, Rarity.RARE, mage.cards.p.PollutedDelta.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Powerbalance", 131, Rarity.RARE, mage.cards.p.Powerbalance.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Powerbalance", 335, Rarity.RARE, mage.cards.p.Powerbalance.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Powerbalance", 495, Rarity.RARE, mage.cards.p.Powerbalance.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Priest of Titania", 286, Rarity.UNCOMMON, mage.cards.p.PriestOfTitania.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Priest of Titania", 428, Rarity.UNCOMMON, mage.cards.p.PriestOfTitania.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Primal Prayers", 166, Rarity.RARE, mage.cards.p.PrimalPrayers.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Primal Prayers", 339, Rarity.RARE, mage.cards.p.PrimalPrayers.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Primal Prayers", 429, Rarity.RARE, mage.cards.p.PrimalPrayers.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Propagator Drone", 167, Rarity.UNCOMMON, mage.cards.p.PropagatorDrone.class));
        cards.add(new SetCardInfo("Proud Pack-Rhino", 41, Rarity.UNCOMMON, mage.cards.p.ProudPackRhino.class));
        cards.add(new SetCardInfo("Psychic Frog", 199, Rarity.RARE, mage.cards.p.PsychicFrog.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Psychic Frog", 344, Rarity.RARE, mage.cards.p.PsychicFrog.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Psychic Frog", 433, Rarity.RARE, mage.cards.p.PsychicFrog.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Pyretic Rebirth", 200, Rarity.UNCOMMON, mage.cards.p.PyreticRebirth.class));
        cards.add(new SetCardInfo("Quest for the Necropolis", 104, Rarity.UNCOMMON, mage.cards.q.QuestForTheNecropolis.class));
        cards.add(new SetCardInfo("Ral and the Implicit Maze", 132, Rarity.UNCOMMON, mage.cards.r.RalAndTheImplicitMaze.class));
        cards.add(new SetCardInfo("Ral, Leyline Prodigy", 247, Rarity.MYTHIC, mage.cards.r.RalLeylineProdigy.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ral, Leyline Prodigy", 445, Rarity.MYTHIC, mage.cards.r.RalLeylineProdigy.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ral, Leyline Prodigy", 471, Rarity.MYTHIC, mage.cards.r.RalLeylineProdigy.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ral, Monsoon Mage", 247, Rarity.MYTHIC, mage.cards.r.RalMonsoonMage.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ral, Monsoon Mage", 445, Rarity.MYTHIC, mage.cards.r.RalMonsoonMage.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ral, Monsoon Mage", 471, Rarity.MYTHIC, mage.cards.r.RalMonsoonMage.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Razorgrass Ambush", 238, Rarity.UNCOMMON, mage.cards.r.RazorgrassAmbush.class));
        cards.add(new SetCardInfo("Reckless Pyrosurfer", 133, Rarity.UNCOMMON, mage.cards.r.RecklessPyrosurfer.class));
        cards.add(new SetCardInfo("Recruiter of the Guard", 266, Rarity.MYTHIC, mage.cards.r.RecruiterOfTheGuard.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Recruiter of the Guard", 395, Rarity.MYTHIC, mage.cards.r.RecruiterOfTheGuard.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Reef Worm", 271, Rarity.UNCOMMON, mage.cards.r.ReefWorm.class));
        cards.add(new SetCardInfo("Refurbished Familiar", 105, Rarity.COMMON, mage.cards.r.RefurbishedFamiliar.class));
        cards.add(new SetCardInfo("Reiterating Bolt", 134, Rarity.UNCOMMON, mage.cards.r.ReiteratingBolt.class));
        cards.add(new SetCardInfo("Retrofitted Transmogrant", 106, Rarity.COMMON, mage.cards.r.RetrofittedTransmogrant.class));
        cards.add(new SetCardInfo("Revitalizing Repast", 256, Rarity.UNCOMMON, mage.cards.r.RevitalizingRepast.class));
        cards.add(new SetCardInfo("Riddle Gate Gargoyle", 201, Rarity.COMMON, mage.cards.r.RiddleGateGargoyle.class));
        cards.add(new SetCardInfo("Ripples of Undeath", 107, Rarity.RARE, mage.cards.r.RipplesOfUndeath.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ripples of Undeath", 455, Rarity.RARE, mage.cards.r.RipplesOfUndeath.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Roil Cartographer", 67, Rarity.UNCOMMON, mage.cards.r.RoilCartographer.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Roil Cartographer", 511, Rarity.UNCOMMON, mage.cards.r.RoilCartographer.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Rosecot Knight", 42, Rarity.COMMON, mage.cards.r.RosecotKnight.class));
        cards.add(new SetCardInfo("Rosheen, Roaring Prophet", 202, Rarity.RARE, mage.cards.r.RosheenRoaringProphet.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Rosheen, Roaring Prophet", 380, Rarity.RARE, mage.cards.r.RosheenRoaringProphet.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Rosheen, Roaring Prophet", 434, Rarity.RARE, mage.cards.r.RosheenRoaringProphet.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Rosheen, Roaring Prophet", 494, Rarity.RARE, mage.cards.r.RosheenRoaringProphet.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ruby Medallion", 295, Rarity.RARE, mage.cards.r.RubyMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ruby Medallion", 348, Rarity.RARE, mage.cards.r.RubyMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Rush of Inspiration", 257, Rarity.UNCOMMON, mage.cards.r.RushOfInspiration.class));
        cards.add(new SetCardInfo("Sage of the Unknowable", 68, Rarity.COMMON, mage.cards.s.SageOfTheUnknowable.class));
        cards.add(new SetCardInfo("Sapphire Medallion", 296, Rarity.RARE, mage.cards.s.SapphireMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sapphire Medallion", 349, Rarity.RARE, mage.cards.s.SapphireMedallion.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sarpadian Simulacrum", 135, Rarity.COMMON, mage.cards.s.SarpadianSimulacrum.class));
        cards.add(new SetCardInfo("Scurrilous Sentry", 108, Rarity.COMMON, mage.cards.s.ScurrilousSentry.class));
        cards.add(new SetCardInfo("Scurry of Gremlins", 203, Rarity.UNCOMMON, mage.cards.s.ScurryOfGremlins.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Scurry of Gremlins", 516, Rarity.UNCOMMON, mage.cards.s.ScurryOfGremlins.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Seething Landscape", 225, Rarity.COMMON, mage.cards.s.SeethingLandscape.class));
        cards.add(new SetCardInfo("Serum Visionary", 69, Rarity.COMMON, mage.cards.s.SerumVisionary.class));
        cards.add(new SetCardInfo("Sevinne's Reclamation", 267, Rarity.RARE, mage.cards.s.SevinnesReclamation.class));
        cards.add(new SetCardInfo("Shadow of the Second Sun", 70, Rarity.MYTHIC, mage.cards.s.ShadowOfTheSecondSun.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Shadow of the Second Sun", 402, Rarity.MYTHIC, mage.cards.s.ShadowOfTheSecondSun.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Shattered Landscape", 226, Rarity.COMMON, mage.cards.s.ShatteredLandscape.class));
        cards.add(new SetCardInfo("Sheltering Landscape", 227, Rarity.COMMON, mage.cards.s.ShelteringLandscape.class));
        cards.add(new SetCardInfo("Shifting Woodland", 228, Rarity.RARE, mage.cards.s.ShiftingWoodland.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Shifting Woodland", 357, Rarity.RARE, mage.cards.s.ShiftingWoodland.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Shilgengar, Sire of Famine", 109, Rarity.RARE, mage.cards.s.ShilgengarSireOfFamine.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Shilgengar, Sire of Famine", 366, Rarity.RARE, mage.cards.s.ShilgengarSireOfFamine.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Shilgengar, Sire of Famine", 480, Rarity.RARE, mage.cards.s.ShilgengarSireOfFamine.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Shrieking Drake", 272, Rarity.UNCOMMON, mage.cards.s.ShriekingDrake.class));
        cards.add(new SetCardInfo("Siege Smash", 136, Rarity.COMMON, mage.cards.s.SiegeSmash.class));
        cards.add(new SetCardInfo("Signature Slam", 168, Rarity.UNCOMMON, mage.cards.s.SignatureSlam.class));
        cards.add(new SetCardInfo("Sink into Stupor", 241, Rarity.UNCOMMON, mage.cards.s.SinkIntoStupor.class));
        cards.add(new SetCardInfo("Six", 169, Rarity.RARE, mage.cards.s.Six.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Six", 370, Rarity.RARE, mage.cards.s.Six.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Six", 430, Rarity.RARE, mage.cards.s.Six.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Six", 484, Rarity.RARE, mage.cards.s.Six.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Skittering Precursor", 137, Rarity.UNCOMMON, mage.cards.s.SkitteringPrecursor.class));
        cards.add(new SetCardInfo("Skoa, Embermage", 138, Rarity.COMMON, mage.cards.s.SkoaEmbermage.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Skoa, Embermage", 420, Rarity.COMMON, mage.cards.s.SkoaEmbermage.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Smelted Chargebug", 139, Rarity.COMMON, mage.cards.s.SmeltedChargebug.class));
        cards.add(new SetCardInfo("Snapping Voidcraw", 204, Rarity.COMMON, mage.cards.s.SnappingVoidcraw.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Snapping Voidcraw", 517, Rarity.COMMON, mage.cards.s.SnappingVoidcraw.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sneaky Snacker", 205, Rarity.COMMON, mage.cards.s.SneakySnacker.class));
        cards.add(new SetCardInfo("Snow-Covered Wastes", 229, Rarity.LAND, mage.cards.s.SnowCoveredWastes.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Snow-Covered Wastes", 309, Rarity.LAND, mage.cards.s.SnowCoveredWastes.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Snow-Covered Wastes", 439, Rarity.LAND, mage.cards.s.SnowCoveredWastes.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Solar Transformer", 211, Rarity.UNCOMMON, mage.cards.s.SolarTransformer.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Solar Transformer", 519, Rarity.UNCOMMON, mage.cards.s.SolarTransformer.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Solstice Zealot", 43, Rarity.COMMON, mage.cards.s.SolsticeZealot.class));
        cards.add(new SetCardInfo("Sorin of House Markov", 245, Rarity.MYTHIC, mage.cards.s.SorinOfHouseMarkov.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sorin of House Markov", 444, Rarity.MYTHIC, mage.cards.s.SorinOfHouseMarkov.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sorin of House Markov", 470, Rarity.MYTHIC, mage.cards.s.SorinOfHouseMarkov.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sorin, Ravenous Neonate", 245, Rarity.MYTHIC, mage.cards.s.SorinRavenousNeonate.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sorin, Ravenous Neonate", 444, Rarity.MYTHIC, mage.cards.s.SorinRavenousNeonate.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sorin, Ravenous Neonate", 470, Rarity.MYTHIC, mage.cards.s.SorinRavenousNeonate.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sowing Mycospawn", 170, Rarity.RARE, mage.cards.s.SowingMycospawn.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sowing Mycospawn", 340, Rarity.RARE, mage.cards.s.SowingMycospawn.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Spawn-Gang Commander", 140, Rarity.UNCOMMON, mage.cards.s.SpawnGangCommander.class));
        cards.add(new SetCardInfo("Springheart Nantuko", 171, Rarity.RARE, mage.cards.s.SpringheartNantuko.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Springheart Nantuko", 341, Rarity.RARE, mage.cards.s.SpringheartNantuko.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Spymaster's Vault", 230, Rarity.RARE, mage.cards.s.SpymastersVault.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Spymaster's Vault", 358, Rarity.RARE, mage.cards.s.SpymastersVault.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Static Prison", 44, Rarity.UNCOMMON, mage.cards.s.StaticPrison.class));
        cards.add(new SetCardInfo("Strength of the Harvest", 258, Rarity.UNCOMMON, mage.cards.s.StrengthOfTheHarvest.class));
        cards.add(new SetCardInfo("Strix Serenade", 71, Rarity.RARE, mage.cards.s.StrixSerenade.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Strix Serenade", 327, Rarity.RARE, mage.cards.s.StrixSerenade.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Stump Stomp", 259, Rarity.UNCOMMON, mage.cards.s.StumpStomp.class));
        cards.add(new SetCardInfo("Sundering Eruption", 248, Rarity.UNCOMMON, mage.cards.s.SunderingEruption.class));
        cards.add(new SetCardInfo("Suppression Ray", 260, Rarity.UNCOMMON, mage.cards.s.SuppressionRay.class));
        cards.add(new SetCardInfo("Swamp", 306, Rarity.LAND, mage.cards.basiclands.Swamp.class, FULL_ART_BFZ_VARIOUS));
        cards.add(new SetCardInfo("Swamp", 314, Rarity.LAND, mage.cards.basiclands.Swamp.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Swamp", 315, Rarity.LAND, mage.cards.basiclands.Swamp.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Swamp", 501, Rarity.LAND, mage.cards.basiclands.Swamp.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Swamp", 502, Rarity.LAND, mage.cards.basiclands.Swamp.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Sylvan Safekeeper", 287, Rarity.RARE, mage.cards.s.SylvanSafekeeper.class));
        cards.add(new SetCardInfo("Tamiyo Meets the Story Circle", 72, Rarity.UNCOMMON, mage.cards.t.TamiyoMeetsTheStoryCircle.class));
        cards.add(new SetCardInfo("Tamiyo, Inquisitive Student", 242, Rarity.MYTHIC, mage.cards.t.TamiyoInquisitiveStudent.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Tamiyo, Inquisitive Student", 443, Rarity.MYTHIC, mage.cards.t.TamiyoInquisitiveStudent.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Tamiyo, Inquisitive Student", 469, Rarity.MYTHIC, mage.cards.t.TamiyoInquisitiveStudent.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Tamiyo, Seasoned Scholar", 242, Rarity.MYTHIC, mage.cards.t.TamiyoSeasonedScholar.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Tamiyo, Seasoned Scholar", 443, Rarity.MYTHIC, mage.cards.t.TamiyoSeasonedScholar.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Tamiyo, Seasoned Scholar", 469, Rarity.MYTHIC, mage.cards.t.TamiyoSeasonedScholar.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Temperamental Oozewagg", 172, Rarity.COMMON, mage.cards.t.TemperamentalOozewagg.class));
        cards.add(new SetCardInfo("Tempest Harvester", 73, Rarity.COMMON, mage.cards.t.TempestHarvester.class));
        cards.add(new SetCardInfo("Territory Culler", 173, Rarity.UNCOMMON, mage.cards.t.TerritoryCuller.class));
        cards.add(new SetCardInfo("The Creation of Avacyn", 86, Rarity.UNCOMMON, mage.cards.t.TheCreationOfAvacyn.class));
        cards.add(new SetCardInfo("The Hunger Tide Rises", 158, Rarity.UNCOMMON, mage.cards.t.TheHungerTideRises.class));
        cards.add(new SetCardInfo("The Necrobloom", 194, Rarity.RARE, mage.cards.t.TheNecrobloom.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("The Necrobloom", 378, Rarity.RARE, mage.cards.t.TheNecrobloom.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("The Necrobloom", 492, Rarity.RARE, mage.cards.t.TheNecrobloom.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Thief of Existence", 174, Rarity.RARE, mage.cards.t.ThiefOfExistence.class));
        cards.add(new SetCardInfo("Thraben Charm", 45, Rarity.COMMON, mage.cards.t.ThrabenCharm.class));
        cards.add(new SetCardInfo("Thriving Skyclaw", 141, Rarity.COMMON, mage.cards.t.ThrivingSkyclaw.class));
        cards.add(new SetCardInfo("Titans' Vanguard", 206, Rarity.UNCOMMON, mage.cards.t.TitansVanguard.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Titans' Vanguard", 518, Rarity.UNCOMMON, mage.cards.t.TitansVanguard.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Toxic Deluge", 277, Rarity.RARE, mage.cards.t.ToxicDeluge.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Toxic Deluge", 412, Rarity.RARE, mage.cards.t.ToxicDeluge.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Tranquil Landscape", 231, Rarity.COMMON, mage.cards.t.TranquilLandscape.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Tranquil Landscape", 520, Rarity.COMMON, mage.cards.t.TranquilLandscape.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Trickster's Elk", 175, Rarity.UNCOMMON, mage.cards.t.TrickstersElk.class));
        cards.add(new SetCardInfo("Triton Wavebreaker", 74, Rarity.UNCOMMON, mage.cards.t.TritonWavebreaker.class));
        cards.add(new SetCardInfo("Tune the Narrative", 75, Rarity.COMMON, mage.cards.t.TuneTheNarrative.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Tune the Narrative", 403, Rarity.COMMON, mage.cards.t.TuneTheNarrative.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Twisted Landscape", 232, Rarity.COMMON, mage.cards.t.TwistedLandscape.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Twisted Landscape", 521, Rarity.COMMON, mage.cards.t.TwistedLandscape.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Twisted Riddlekeeper", 14, Rarity.UNCOMMON, mage.cards.t.TwistedRiddlekeeper.class));
        cards.add(new SetCardInfo("Ugin's Binding", 76, Rarity.MYTHIC, mage.cards.u.UginsBinding.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ugin's Binding", 328, Rarity.MYTHIC, mage.cards.u.UginsBinding.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ugin's Labyrinth", 233, Rarity.MYTHIC, mage.cards.u.UginsLabyrinth.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ugin's Labyrinth", 359, Rarity.MYTHIC, mage.cards.u.UginsLabyrinth.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ulamog, the Defiler", 15, Rarity.MYTHIC, mage.cards.u.UlamogTheDefiler.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ulamog, the Defiler", 383, Rarity.MYTHIC, mage.cards.u.UlamogTheDefiler.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ulamog, the Defiler", "383z", Rarity.MYTHIC, mage.cards.u.UlamogTheDefiler.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Ulamog, the Defiler", 389, Rarity.MYTHIC, mage.cards.u.UlamogTheDefiler.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Ulamog, the Defiler", 476, Rarity.MYTHIC, mage.cards.u.UlamogTheDefiler.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Unfathomable Truths", 77, Rarity.COMMON, mage.cards.u.UnfathomableTruths.class));
        cards.add(new SetCardInfo("Unstable Amulet", 142, Rarity.UNCOMMON, mage.cards.u.UnstableAmulet.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Unstable Amulet", 421, Rarity.UNCOMMON, mage.cards.u.UnstableAmulet.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Unstable Amulet", 514, Rarity.UNCOMMON, mage.cards.u.UnstableAmulet.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Urza's Cave", 234, Rarity.UNCOMMON, mage.cards.u.UrzasCave.class));
        cards.add(new SetCardInfo("Urza's Incubator", 297, Rarity.RARE, mage.cards.u.UrzasIncubator.class));
        cards.add(new SetCardInfo("Utter Insignificance", 78, Rarity.COMMON, mage.cards.u.UtterInsignificance.class));
        cards.add(new SetCardInfo("Vexing Bauble", 212, Rarity.UNCOMMON, mage.cards.v.VexingBauble.class));
        cards.add(new SetCardInfo("Victimize", 278, Rarity.UNCOMMON, mage.cards.v.Victimize.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Victimize", 413, Rarity.UNCOMMON, mage.cards.v.Victimize.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Voidpouncer", 143, Rarity.COMMON, mage.cards.v.Voidpouncer.class));
        cards.add(new SetCardInfo("Volatile Stormdrake", 79, Rarity.RARE, mage.cards.v.VolatileStormdrake.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Volatile Stormdrake", 329, Rarity.RARE, mage.cards.v.VolatileStormdrake.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Volatile Stormdrake", 404, Rarity.RARE, mage.cards.v.VolatileStormdrake.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Voltstorm Angel", 46, Rarity.UNCOMMON, mage.cards.v.VoltstormAngel.class));
        cards.add(new SetCardInfo("Warped Tusker", 16, Rarity.COMMON, mage.cards.w.WarpedTusker.class));
        cards.add(new SetCardInfo("Warren Soultrader", 110, Rarity.RARE, mage.cards.w.WarrenSoultrader.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Warren Soultrader", 332, Rarity.RARE, mage.cards.w.WarrenSoultrader.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Warren Soultrader", 414, Rarity.RARE, mage.cards.w.WarrenSoultrader.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Wastescape Battlemage", 17, Rarity.UNCOMMON, mage.cards.w.WastescapeBattlemage.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wastescape Battlemage", 508, Rarity.UNCOMMON, mage.cards.w.WastescapeBattlemage.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Waterlogged Teachings", 261, Rarity.UNCOMMON, mage.cards.w.WaterloggedTeachings.class));
        cards.add(new SetCardInfo("Wheel of Potential", 144, Rarity.RARE, mage.cards.w.WheelOfPotential.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wheel of Potential", 336, Rarity.RARE, mage.cards.w.WheelOfPotential.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wheel of Potential", 422, Rarity.RARE, mage.cards.w.WheelOfPotential.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("White Orchid Phantom", 47, Rarity.RARE, mage.cards.w.WhiteOrchidPhantom.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("White Orchid Phantom", 324, Rarity.RARE, mage.cards.w.WhiteOrchidPhantom.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("White Orchid Phantom", 396, Rarity.RARE, mage.cards.w.WhiteOrchidPhantom.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Wight of the Reliquary", 207, Rarity.RARE, mage.cards.w.WightOfTheReliquary.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wight of the Reliquary", 460, Rarity.RARE, mage.cards.w.WightOfTheReliquary.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Windswept Heath", 235, Rarity.RARE, mage.cards.w.WindsweptHeath.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Windswept Heath", 360, Rarity.RARE, mage.cards.w.WindsweptHeath.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Windswept Heath", 440, Rarity.RARE, mage.cards.w.WindsweptHeath.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Windswept Heath", 466, Rarity.RARE, mage.cards.w.WindsweptHeath.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wing It", 48, Rarity.COMMON, mage.cards.w.WingIt.class));
        cards.add(new SetCardInfo("Winter Moon", 213, Rarity.RARE, mage.cards.w.WinterMoon.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Winter Moon", 462, Rarity.RARE, mage.cards.w.WinterMoon.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wirewood Symbiote", 288, Rarity.UNCOMMON, mage.cards.w.WirewoodSymbiote.class));
        cards.add(new SetCardInfo("Witch Enchanter", 239, Rarity.UNCOMMON, mage.cards.w.WitchEnchanter.class));
        cards.add(new SetCardInfo("Wither and Bloom", 111, Rarity.COMMON, mage.cards.w.WitherAndBloom.class));
        cards.add(new SetCardInfo("Wooded Foothills", 236, Rarity.RARE, mage.cards.w.WoodedFoothills.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wooded Foothills", 361, Rarity.RARE, mage.cards.w.WoodedFoothills.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wooded Foothills", 441, Rarity.RARE, mage.cards.w.WoodedFoothills.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Wooded Foothills", 467, Rarity.RARE, mage.cards.w.WoodedFoothills.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Worn Powerstone", 298, Rarity.UNCOMMON, mage.cards.w.WornPowerstone.class));
        cards.add(new SetCardInfo("Wrath of the Skies", 49, Rarity.RARE, mage.cards.w.WrathOfTheSkies.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wrath of the Skies", 325, Rarity.RARE, mage.cards.w.WrathOfTheSkies.class, NON_FULL_USE_VARIOUS));
        cards.add(new SetCardInfo("Wrath of the Skies", 397, Rarity.RARE, mage.cards.w.WrathOfTheSkies.class, RETRO_ART_USE_VARIOUS));
        cards.add(new SetCardInfo("Writhing Chrysalis", 208, Rarity.COMMON, mage.cards.w.WrithingChrysalis.class));
        cards.add(new SetCardInfo("Wumpus Aberration", 176, Rarity.UNCOMMON, mage.cards.w.WumpusAberration.class));
        cards.add(new SetCardInfo("Wurmcoil Larva", 112, Rarity.UNCOMMON, mage.cards.w.WurmcoilLarva.class));
    }

    @Override
    public List<Card> tryBooster() {
        // TODO: make part of this more generic, this is the second try at a play booster generation so we try to see what can be shared.
        // source https://magic.wizards.com/en/news/feature/collecting-modern-horizons-3

        // We start by deciding the various slots.
        // some slots have guarantee rarity
        int rareOrMythic = 1;
        int newToModern = 1;
        int uncommon = 3;
        int common = 5; // 6 common slots, one being sometimes replaced by a secret guest

        // Land Slot: 1/2 chance for a basic, 1/2 chance for a common
        int basicLand = 0;
        {
            if (RandomUtil.nextDouble() <= 0.5) {
                basicLand++;
            } else {
                common++;
            }
        }

        // 1 slot is 1/64 chance to be spg, and 1/5 - 1/64 to be otp, 4/5 to be common
        int spg = 0;
        {
            double rollSpg = RandomUtil.nextDouble();
            if (rollSpg <= 1.0 / 64.0) { // know probability of 1/64 to be spg
                spg++;
            } else {
                common++;
            }
        }

        int commander = 0;
        // 1 slot is a wildcard:
        // 41.7% chance to be among 80 common
        // 41.7% chance to be among 101 uncommons
        // 7.8% chance to be among rare/mythic (with weight 2:1 individually)
        // 4.2% chance to be among 8 Commander Mythic Rares (4.2% in total).
        // TODO: only that part has been generated (up to 95.6%).
        //       miss some new to modern (not all) that have retro frames, (4.2%),
        //       some variants (0.4%), and full art snow covered wastes (<0.1%)
        {
            double total = 0.417 * 2 + 0.078 + 0.042;
            double rollWildcard = RandomUtil.nextDouble() * total;
            if (rollWildcard <= 0.417) {
                common++;
            } else if (rollWildcard <= 0.417 * 2) {
                uncommon++;
            } else if (rollWildcard <= 0.417 * 2 + 0.078) {
                rareOrMythic++;
            } else {
                commander++;
            }
        }

        // wildcard foil slot, reusing the previous wildcard slot, altough maybe it is different.
        {
            double total = 0.417 * 2 + 0.078 + 0.042;
            double rollWildcard = RandomUtil.nextDouble() * total;
            if (rollWildcard <= 0.417) {
                common++;
            } else if (rollWildcard <= 0.417 * 2) {
                uncommon++;
            } else if (rollWildcard <= 0.417 * 2 + 0.078) {
                rareOrMythic++;
            } else {
                commander++;
            }
        }

        // The booster we are building
        List<Card> booster = new ArrayList<>();

        // 1 -> 261 are the 261 regular common/uncommon/rare/mythic
        // 262 -> 303 are the 42 new to modern reprint cards (uncommon/rare/mythic)
        // 304 -> 319 are basics lands (with 309 being Snow-Covered Waste)
        List<CardInfo> list_MH3_C =
                getCardsByRarity(Rarity.COMMON).stream()
                        .filter(info -> info.getCardNumberAsInt() <= 261)
                        .collect(Collectors.toList());
        List<CardInfo> list_MH3_U =
                getCardsByRarity(Rarity.UNCOMMON).stream()
                        .filter(info -> info.getCardNumberAsInt() <= 261)
                        .collect(Collectors.toList());
        List<CardInfo> list_MH3_R =
                getCardsByRarity(Rarity.RARE)
                        .stream()
                        .filter(info -> info.getCardNumberAsInt() <= 261)
                        .collect(Collectors.toList());
        List<CardInfo> list_MH3_M =
                getCardsByRarity(Rarity.MYTHIC)
                        .stream()
                        .filter(info -> info.getCardNumberAsInt() <= 261)
                        .collect(Collectors.toList());
        List<CardInfo> list_MH3_Basic =
                getCardsByRarity(Rarity.LAND)
                        .stream()
                        .filter(info -> info.getCardNumberAsInt() <= maxCardNumberInBooster)
                        .collect(Collectors.toList());
        List<CardInfo> list_RTM_U =
                getCardsByRarity(Rarity.UNCOMMON)
                        .stream()
                        .filter(info -> info.getCardNumberAsInt() >= 262 && info.getCardNumberAsInt() <= 303)
                        .collect(Collectors.toList());
        List<CardInfo> list_RTM_R =
                getCardsByRarity(Rarity.RARE)
                        .stream()
                        .filter(info -> info.getCardNumberAsInt() >= 262 && info.getCardNumberAsInt() <= 303)
                        .collect(Collectors.toList());
        List<CardInfo> list_RTM_M =
                getCardsByRarity(Rarity.MYTHIC)
                        .stream()
                        .filter(info -> info.getCardNumberAsInt() >= 262 && info.getCardNumberAsInt() <= 303)
                        .collect(Collectors.toList());
        List<CardInfo> list_SPG =
                SpecialGuests.getInstance().getCardsByRarity(Rarity.MYTHIC)
                        .stream()
                        .filter(info -> {
                            int cn = info.getCardNumberAsInt();
                            return cn >= 39 && cn <= 48;
                        })
                        .collect(Collectors.toList());
        List<CardInfo> list_M3C =
                ModernHorizons3Commander.getInstance().getCardsByRarity(Rarity.MYTHIC)
                        .stream()
                        .filter(info -> info.getCardNumberAsInt() <= 8)
                        .collect(Collectors.toList());

        for (int i = 0; i < spg; i++) {
            addToBooster(booster, list_SPG);
        }
        double ratioMythic = (double) list_MH3_M.size() / (double) (list_MH3_M.size() + list_MH3_R.size() * 2);
        for (int i = 0; i < rareOrMythic; i++) {
            if (RandomUtil.nextDouble() <= ratioMythic) {
                addToBooster(booster, list_MH3_M);
            } else {
                addToBooster(booster, list_MH3_R);
            }
        }
        for (int i = 0; i < commander; i++) {
            addToBooster(booster, list_M3C);
        }
        double ratioUncommonRTM = 0.75; // Uncommons relative to rare+mythic
        double ratioMythicRTM = (double) list_RTM_M.size() / (double) (list_RTM_M.size() + list_RTM_R.size() * 2); // mythics relative to rare
        for (int i = 0; i < newToModern; i++) {
            if (RandomUtil.nextDouble() <= ratioUncommonRTM) {
                addToBooster(booster, list_RTM_U);
            } else if (RandomUtil.nextDouble() <= ratioMythicRTM) {
                addToBooster(booster, list_RTM_M);
            } else {
                addToBooster(booster, list_RTM_R);
            }
        }
        for (int i = 0; i < uncommon; i++) {
            addToBooster(booster, list_MH3_U);
        }
        for (int i = 0; i < common; i++) {
            addToBooster(booster, list_MH3_C);
        }
        for (int i = 0; i < basicLand; i++) {
            addToBooster(booster, list_MH3_Basic);
        }

        return booster;
    }
}
