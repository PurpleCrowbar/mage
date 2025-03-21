
package mage.cards.v;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.AttachEffect;
import mage.abilities.effects.common.combat.CantAttackControllerAttachedEffect;
import mage.abilities.effects.common.continuous.BoostEnchantedEffect;
import mage.abilities.effects.common.continuous.GainAbilityAttachedEffect;
import mage.abilities.keyword.EnchantAbility;
import mage.abilities.keyword.VigilanceAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.AttachmentType;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Duration;
import mage.constants.Outcome;
import mage.constants.Zone;
import mage.target.TargetPermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author LevelX2
 */
public final class VowOfDuty extends CardImpl {

    public VowOfDuty(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{2}{W}");
        this.subtype.add(SubType.AURA);


        // Enchant creature
        TargetPermanent auraTarget = new TargetCreaturePermanent();
        this.getSpellAbility().addTarget(auraTarget);
        this.getSpellAbility().addEffect(new AttachEffect(Outcome.BoostCreature));
        Ability ability = new EnchantAbility(auraTarget);
        this.addAbility(ability);
        // Enchanted creature gets +2/+2, has vigilance, and can't attack you or a planeswalker you control.
        ability = new SimpleStaticAbility(new BoostEnchantedEffect(2,2,Duration.WhileOnBattlefield));
        Effect effect = new GainAbilityAttachedEffect(VigilanceAbility.getInstance(), AttachmentType.AURA, Duration.WhileOnBattlefield);
        effect.setText(", has vigilance");
        ability.addEffect(effect);
        effect = new CantAttackControllerAttachedEffect(AttachmentType.AURA, true);
        effect.setText(", and can't attack you or planeswalkers you control");
        ability.addEffect(effect);
        this.addAbility(ability);          
    }

    private VowOfDuty(final VowOfDuty card) {
        super(card);
    }

    @Override
    public VowOfDuty copy() {
        return new VowOfDuty(this);
    }
}
