package hpl.world.blocks.defense;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.struct.Seq;
import arc.util.Nullable;
import hpl.content.HPLStatusEffects;
import mindustry.annotations.Annotations;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.Damage;
import mindustry.entities.Effect;
import mindustry.entities.Lightning;
import mindustry.entities.Units;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.logic.Ranged;
import mindustry.type.StatusEffect;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

import static mindustry.Vars.tilesize;

public class NavalMine extends Block {
    public final int timerDamage = timers++;

    public float splashDamageRadius = 50f;
    public boolean collidesAir = false, collidesGround = true;
    /** If true, splash damage pierces through tiles. */
    public boolean splashDamagePierce = false;

    public float cooldown = 40f;
    public float tileDamage = 10f;
    public float range = 20f;
    public float statusDuration = 60f;
    public StatusEffect status = HPLStatusEffects.decomposition;
    public Effect acceptEffect = Fx.none;
    public float damage = 130;
    public int length = 10;
    public float teamAlpha = 0.3f;
    public boolean targetHost = true;
    public boolean targetFriendly = false;
  //  public TextureRegion teamRegion;

    public NavalMine(String name){
        super(name);
        update = true;
        destructible = true;
        solid = false;
        targetable = false;
    }

    @Override
    public void setStats(){
        super.setStats();
        stats.add(Stat.range, range / tilesize, StatUnit.blocks);
        stats.add(Stat.damage, damage);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid) {
        super.drawPlace(x, y, rotation, valid);
        Drawf.dashCircle(x * tilesize + offset, y * tilesize + offset, range, Pal.accent);
    }

    @Override
    public void load(){
        super.load();
        // teamRegion = Core.atlas.find(name + "-team");
    }

/*
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{region, teamRegion};
    }

 */
    public class NavalMineBuild extends Building implements Ranged {
        public Posc target;
        @Override
        public void drawTeam() {
            //no
        }

        @Override
        public float range() {
            return range;
        }

        protected void findTarget() {
            target = Units.closestTarget(team, x, y, range());
        }

        protected boolean validateTarget() {
            return !(Units.invalidateTarget(target, team, x, y) || !(target instanceof Unitc));
        }

        @Override
        public void updateTile() {
            if (!validateTarget()) target = null;


            if(validateTarget()){
                if(targetHost)blast();
                //if(targetFriendly)effectFriend();
                damage(tileDamage);
            }
 /*
            if(timer(0, 20)){
                findTarget();
            }

            if(enabled && unitc.team() != team && timer(timerDamage, cooldown)){







            }
            */
        }

        protected void blast() {
            Units.nearbyEnemies(team, x, y, range, unit -> {
                unit.apply(status, statusDuration);
                Damage.damage(unit.team, x, y, splashDamageRadius, damage , splashDamagePierce, collidesAir, collidesGround);
                //unit.impulse(Tmp.v3.set(unit).sub(x, y).nor().scl(knockback * 40.0f));
                acceptEffect.at(unit);
                //unit.damage(damage);
            });
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
        /*
        @Override
        public void unitOn(Unit unit){
            if(enabled && unit.team != team && timer(timerDamage, cooldown)){
                damage(tileDamage);
            }
        }

         */
    }
}
