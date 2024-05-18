package az.content;

import arc.math.Mathf;
import az.graphics.AZPal;
import mindustry.type.StatusEffect;

public class AZStatusEffects {
    public static StatusEffect weakness, decomposition, ultraSuperDuperMegaDohuaMoschniyBuff;

    public static void load() {
        weakness = new StatusEffect ("weakness") {{
            color = AZPal.unmakerColor;
            damage = 0.375f;
            healthMultiplier = 0.8f;
            speedMultiplier =  0.5f;
            damageMultiplier = 0.65f;
            reloadMultiplier = 2f/3;
        }};

        decomposition = new StatusEffect("decomposition") {{
            damage = 1.4f;
            healthMultiplier = 0.7f;
            buildSpeedMultiplier = 0.8f;

            effect = AZFx.cursedFire;
            transitionDamage = 8.0f;

            init(() -> {
                opposite(ultraSuperDuperMegaDohuaMoschniyBuff);
                affinity(weakness, (unit, result, time) -> {
                    unit.damagePierce(transitionDamage);
                    AZFx.cursedFire.at(unit.x + Mathf.range(unit.bounds() / 2.0f), unit.y + Mathf.range(unit.bounds() / 2.0f));
                    result.set(decomposition, Math.min(time + result.time, 300.0f));
                });
            });
        }};

        ultraSuperDuperMegaDohuaMoschniyBuff = new StatusEffect("ultra-super-duper-mega-dohua-moschniy-buff") {{
           healthMultiplier = 1.5f;
           speedMultiplier = 1.3f;
           buildSpeedMultiplier = 1.3f;
        }};
    }
}
