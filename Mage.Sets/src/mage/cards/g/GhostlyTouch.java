
package mage.cards.g;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.AttacksTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.AttachEffect;
import mage.abilities.effects.common.MayTapOrUntapTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityAttachedEffect;
import mage.abilities.keyword.EnchantAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.AttachmentType;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Outcome;
import mage.constants.Zone;
import mage.target.TargetPermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author noxx

 */
public final class GhostlyTouch extends CardImpl {

    public GhostlyTouch(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{1}{U}");
        this.subtype.add(SubType.AURA);


        // Enchant creature
        TargetPermanent auraTarget = new TargetCreaturePermanent();
        this.getSpellAbility().addTarget(auraTarget);
        this.getSpellAbility().addEffect(new AttachEffect(Outcome.AddAbility));
        Ability ability = new EnchantAbility(auraTarget);
        this.addAbility(ability);

        // Enchanted creature has "Whenever this creature attacks, you may tap or untap target permanent."
        Ability gainedAbility = new AttacksTriggeredAbility(new MayTapOrUntapTargetEffect(), true);
        gainedAbility.addTarget(new TargetPermanent());
        this.addAbility(new SimpleStaticAbility(new GainAbilityAttachedEffect(gainedAbility, AttachmentType.AURA)));
    }

    private GhostlyTouch(final GhostlyTouch card) {
        super(card);
    }

    @Override
    public GhostlyTouch copy() {
        return new GhostlyTouch(this);
    }
}
