package hpl.world.blocks.defense;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.struct.Seq;
import arc.util.Nullable;
import mindustry.annotations.Annotations;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Damage;
import mindustry.entities.Effect;
import mindustry.entities.Lightning;
import mindustry.entities.Units;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Building;
import mindustry.gen.Bullet;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;
import mindustry.world.Block;

public class NavalMine extends Block {
    public final int timerDamage = timers++;

    public float cooldown = 40f;
    public float tileDamage = 10f;
    public float damage = 13;
    public int length = 10;
    public @Nullable BulletType bullet;
    public float teamAlpha = 0.3f;
    public TextureRegion teamRegion;

    public NavalMine(String name){
        super(name);
        update = false;
        destructible = true;
        solid = false;
        targetable = false;
    }

    @Override
    public void load(){
        super.load();
        teamRegion = Core.atlas.find(name + "-team");
    }

    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{region, teamRegion};
    }
    public class NavalMineBuild extends Building {
        @Override
        public void drawTeam() {
            //no
        }

        @Override
        public void draw() {
            super.draw();
            Draw.color(team.color, teamAlpha);
            Draw.rect(teamRegion, x, y);
            Draw.color();
        }

        @Override
        public void drawCracks() {
            //no
        }
        @Override
        public void unitOn(Unit unit){
            if(enabled && unit.team != team && timer(timerDamage, cooldown)){
                damage(tileDamage);
            }
        }
    }
}
