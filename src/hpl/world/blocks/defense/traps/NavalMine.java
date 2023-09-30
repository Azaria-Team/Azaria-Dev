package hpl.world.blocks.defense.traps;

import arc.Events;
import arc.audio.Sound;
import arc.graphics.g2d.Draw;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.game.EventType;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.gen.Unit;
import mindustry.world.Block;

public class NavalMine extends Block {

    public float damage = 50f;
    public float tileDamage = 50;
    public float teamAlpha = 0.3f;
    public float activateRange = 50;
    public float explosionShake = 6f;
    public float explosionShakeDuration = 16f;
    public float explosionRadius = 19;
    public float explosionDamage = 1250 * 4;

    public Effect explodeEffect = Fx.reactorExplosion;
    public Sound explodeSound = Sounds.explosionbig;

    public NavalMine(String name) {
        super(name);
        update = false;
        destructible = true;
        solid = false;
        targetable = false;
    }

    public class NavalMineBuild extends Building {
        @Override
        public void drawTeam() {
            //no(because anuk said so)
        }

        @Override
        public void draw() {
            super.draw();
            Draw.color(team.color, teamAlpha);
            Draw.rect(teamRegion, x, y);
            Draw.color();
        }

        @Override
        public void unitOn(Unit unit) {
            if(enabled && unit.team != team) {
                Events.fire(EventType.Trigger.thoriumReactorOverheat);
                damage(tileDamage);
                kill();
            }
        }

    }
}
