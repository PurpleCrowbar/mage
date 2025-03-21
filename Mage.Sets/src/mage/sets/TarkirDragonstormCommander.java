package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 * @author TheElk801
 */
public final class TarkirDragonstormCommander extends ExpansionSet {

    private static final TarkirDragonstormCommander instance = new TarkirDragonstormCommander();

    public static TarkirDragonstormCommander getInstance() {
        return instance;
    }

    private TarkirDragonstormCommander() {
        super("Tarkir: Dragonstorm Commander", "TDC", ExpansionSet.buildDate(2025, 4, 11), SetType.SUPPLEMENTAL);
        this.hasBasicLands = false;

        cards.add(new SetCardInfo("Abrade", 203, Rarity.UNCOMMON, mage.cards.a.Abrade.class));
        cards.add(new SetCardInfo("Adarkar Wastes", 338, Rarity.RARE, mage.cards.a.AdarkarWastes.class));
        cards.add(new SetCardInfo("Ancestral Vision", 144, Rarity.RARE, mage.cards.a.AncestralVision.class));
        cards.add(new SetCardInfo("Arcane Signet", 105, Rarity.UNCOMMON, mage.cards.a.ArcaneSignet.class));
        cards.add(new SetCardInfo("Archmage Emeritus", 145, Rarity.RARE, mage.cards.a.ArchmageEmeritus.class));
        cards.add(new SetCardInfo("Ash Barrens", 339, Rarity.COMMON, mage.cards.a.AshBarrens.class));
        cards.add(new SetCardInfo("Azorius Signet", 312, Rarity.UNCOMMON, mage.cards.a.AzoriusSignet.class));
        cards.add(new SetCardInfo("Baral and Kari Zev", 282, Rarity.RARE, mage.cards.b.BaralAndKariZev.class));
        cards.add(new SetCardInfo("Baral's Expertise", 146, Rarity.RARE, mage.cards.b.BaralsExpertise.class));
        cards.add(new SetCardInfo("Battlefield Forge", 340, Rarity.RARE, mage.cards.b.BattlefieldForge.class));
        cards.add(new SetCardInfo("Betor, Ancestor's Voice", 1, Rarity.MYTHIC, mage.cards.b.BetorAncestorsVoice.class));
        cards.add(new SetCardInfo("Big Score", 206, Rarity.COMMON, mage.cards.b.BigScore.class));
        cards.add(new SetCardInfo("Boros Signet", 314, Rarity.UNCOMMON, mage.cards.b.BorosSignet.class));
        cards.add(new SetCardInfo("Caldera Pyremaw", 33, Rarity.RARE, mage.cards.c.CalderaPyremaw.class));
        cards.add(new SetCardInfo("Cascade Bluffs", 345, Rarity.RARE, mage.cards.c.CascadeBluffs.class));
        cards.add(new SetCardInfo("Clifftop Retreat", 351, Rarity.RARE, mage.cards.c.ClifftopRetreat.class));
        cards.add(new SetCardInfo("Command Tower", 107, Rarity.COMMON, mage.cards.c.CommandTower.class));
        cards.add(new SetCardInfo("Compulsive Research", 147, Rarity.COMMON, mage.cards.c.CompulsiveResearch.class));
        cards.add(new SetCardInfo("Consider", 148, Rarity.COMMON, mage.cards.c.Consider.class));
        cards.add(new SetCardInfo("Curse of Opulence", 209, Rarity.UNCOMMON, mage.cards.c.CurseOfOpulence.class));
        cards.add(new SetCardInfo("Curse of the Swine", 149, Rarity.RARE, mage.cards.c.CurseOfTheSwine.class));
        cards.add(new SetCardInfo("Deep Analysis", 150, Rarity.COMMON, mage.cards.d.DeepAnalysis.class));
        cards.add(new SetCardInfo("Dismantling Wave", 112, Rarity.RARE, mage.cards.d.DismantlingWave.class));
        cards.add(new SetCardInfo("Electrodominance", 212, Rarity.RARE, mage.cards.e.Electrodominance.class));
        cards.add(new SetCardInfo("Exotic Orchard", 360, Rarity.RARE, mage.cards.e.ExoticOrchard.class));
        cards.add(new SetCardInfo("Expressive Iteration", 288, Rarity.UNCOMMON, mage.cards.e.ExpressiveIteration.class));
        cards.add(new SetCardInfo("Faithless Looting", 213, Rarity.COMMON, mage.cards.f.FaithlessLooting.class));
        cards.add(new SetCardInfo("Fellwar Stone", 318, Rarity.UNCOMMON, mage.cards.f.FellwarStone.class));
        cards.add(new SetCardInfo("Ferrous Lake", 361, Rarity.RARE, mage.cards.f.FerrousLake.class));
        cards.add(new SetCardInfo("Frantic Search", 153, Rarity.COMMON, mage.cards.f.FranticSearch.class));
        cards.add(new SetCardInfo("Ghostly Prison", 116, Rarity.UNCOMMON, mage.cards.g.GhostlyPrison.class));
        cards.add(new SetCardInfo("Glacial Fortress", 367, Rarity.RARE, mage.cards.g.GlacialFortress.class));
        cards.add(new SetCardInfo("Goblin Electromancer", 99, Rarity.COMMON, mage.cards.g.GoblinElectromancer.class));
        cards.add(new SetCardInfo("Guttersnipe", 217, Rarity.UNCOMMON, mage.cards.g.Guttersnipe.class));
        cards.add(new SetCardInfo("Haughty Djinn", 154, Rarity.RARE, mage.cards.h.HaughtyDjinn.class));
        cards.add(new SetCardInfo("Irrigated Farmland", 372, Rarity.RARE, mage.cards.i.IrrigatedFarmland.class));
        cards.add(new SetCardInfo("Izzet Signet", 320, Rarity.COMMON, mage.cards.i.IzzetSignet.class));
        cards.add(new SetCardInfo("Lier, Disciple of the Drowned", 157, Rarity.MYTHIC, mage.cards.l.LierDiscipleOfTheDrowned.class));
        cards.add(new SetCardInfo("Magma Opus", 296, Rarity.MYTHIC, mage.cards.m.MagmaOpus.class));
        cards.add(new SetCardInfo("Mana Geyser", 223, Rarity.COMMON, mage.cards.m.ManaGeyser.class));
        cards.add(new SetCardInfo("Manaform Hellkite", 224, Rarity.MYTHIC, mage.cards.m.ManaformHellkite.class));
        cards.add(new SetCardInfo("Mangara, the Diplomat", 124, Rarity.RARE, mage.cards.m.MangaraTheDiplomat.class));
        cards.add(new SetCardInfo("Monastery Mentor", 125, Rarity.MYTHIC, mage.cards.m.MonasteryMentor.class));
        cards.add(new SetCardInfo("Narset's Reversal", 92, Rarity.RARE, mage.cards.n.NarsetsReversal.class));
        cards.add(new SetCardInfo("Opt", 158, Rarity.COMMON, mage.cards.o.Opt.class));
        cards.add(new SetCardInfo("Path of Ancestry", 382, Rarity.COMMON, mage.cards.p.PathOfAncestry.class));
        cards.add(new SetCardInfo("Perilous Landscape", 383, Rarity.COMMON, mage.cards.p.PerilousLandscape.class));
        cards.add(new SetCardInfo("Ponder", 159, Rarity.COMMON, mage.cards.p.Ponder.class));
        cards.add(new SetCardInfo("Pongify", 160, Rarity.UNCOMMON, mage.cards.p.Pongify.class));
        cards.add(new SetCardInfo("Prairie Stream", 384, Rarity.RARE, mage.cards.p.PrairieStream.class));
        cards.add(new SetCardInfo("Preordain", 161, Rarity.COMMON, mage.cards.p.Preordain.class));
        cards.add(new SetCardInfo("Prismari Command", 299, Rarity.RARE, mage.cards.p.PrismariCommand.class));
        cards.add(new SetCardInfo("Reliquary Tower", 386, Rarity.UNCOMMON, mage.cards.r.ReliquaryTower.class));
        cards.add(new SetCardInfo("Rite of Replication", 165, Rarity.RARE, mage.cards.r.RiteOfReplication.class));
        cards.add(new SetCardInfo("Rugged Prairie", 389, Rarity.RARE, mage.cards.r.RuggedPrairie.class));
        cards.add(new SetCardInfo("Shiny Impetus", 231, Rarity.COMMON, mage.cards.s.ShinyImpetus.class));
        cards.add(new SetCardInfo("Shivan Reef", 393, Rarity.RARE, mage.cards.s.ShivanReef.class));
        cards.add(new SetCardInfo("Skycloud Expanse", 394, Rarity.RARE, mage.cards.s.SkycloudExpanse.class));
        cards.add(new SetCardInfo("Sol Ring", 106, Rarity.UNCOMMON, mage.cards.s.SolRing.class));
        cards.add(new SetCardInfo("Storm-Kiln Artist", 235, Rarity.UNCOMMON, mage.cards.s.StormKilnArtist.class));
        cards.add(new SetCardInfo("Sublime Epiphany", 167, Rarity.RARE, mage.cards.s.SublimeEpiphany.class));
        cards.add(new SetCardInfo("Sulfur Falls", 396, Rarity.RARE, mage.cards.s.SulfurFalls.class));
        cards.add(new SetCardInfo("Swords to Plowshares", 134, Rarity.UNCOMMON, mage.cards.s.SwordsToPlowshares.class));
        cards.add(new SetCardInfo("Talisman of Progress", 333, Rarity.UNCOMMON, mage.cards.t.TalismanOfProgress.class));
        cards.add(new SetCardInfo("Tempest Technique", 16, Rarity.RARE, mage.cards.t.TempestTechnique.class));
        cards.add(new SetCardInfo("Temple of Enlightenment", 401, Rarity.RARE, mage.cards.t.TempleOfEnlightenment.class));
        cards.add(new SetCardInfo("Temple of Epiphany", 402, Rarity.RARE, mage.cards.t.TempleOfEpiphany.class));
        cards.add(new SetCardInfo("Temple of Triumph", 407, Rarity.RARE, mage.cards.t.TempleOfTriumph.class));
        cards.add(new SetCardInfo("Teval, the Balanced Scale", 8, Rarity.MYTHIC, mage.cards.t.TevalTheBalancedScale.class));
        cards.add(new SetCardInfo("Think Twice", 168, Rarity.COMMON, mage.cards.t.ThinkTwice.class));
        cards.add(new SetCardInfo("Third Path Iconoclast", 307, Rarity.UNCOMMON, mage.cards.t.ThirdPathIconoclast.class));
        cards.add(new SetCardInfo("Time Wipe", 308, Rarity.RARE, mage.cards.t.TimeWipe.class));
        cards.add(new SetCardInfo("Vanquish the Horde", 91, Rarity.RARE, mage.cards.v.VanquishTheHorde.class));
        cards.add(new SetCardInfo("Velomachus Lorehold", 309, Rarity.MYTHIC, mage.cards.v.VelomachusLorehold.class));
        cards.add(new SetCardInfo("Veyran, Voice of Duality", 310, Rarity.MYTHIC, mage.cards.v.VeyranVoiceOfDuality.class));
        cards.add(new SetCardInfo("Whirlwind of Thought", 311, Rarity.RARE, mage.cards.w.WhirlwindOfThought.class));
        cards.add(new SetCardInfo("Young Pyromancer", 95, Rarity.UNCOMMON, mage.cards.y.YoungPyromancer.class));
    }
}
