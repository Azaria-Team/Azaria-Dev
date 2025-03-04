package az.type.weapons;

import arc.graphics.Color;
import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.core.World;
import mindustry.entities.Effect;
import mindustry.entities.Units;
import mindustry.entities.units.WeaponMount;
import mindustry.gen.Building;
import mindustry.gen.Healthc;
import mindustry.gen.Teamc;
import mindustry.gen.Unit;
import mindustry.type.weapons.RepairBeamWeapon;

import static mindustry.Vars.tilesize;

public class BeamWeapon extends RepairBeamWeapon {
    public boolean damageEnemies = true;
    public float damagePerSecond = 0.1f;
    public Color enemyLaserColor = Color.valueOf("ff0000");
    public Effect damageEffect = Fx.hitLaser;

    public BeamWeapon(String name){
        super(name);
        targetBuildings = true;
    }

    public BeamWeapon(){
    }
    @Override
    protected Teamc findTarget(Unit unit, float x, float y, float range, boolean air, boolean ground){

        if(damageEnemies){
            Teamc enemy = Units.closestEnemy(unit.team, x, y, range, u -> true);
            if(enemy != null) return enemy;
        }

        Teamc ally = targetUnits ?
                Units.closest(unit.team, x, y, range, u -> u != unit && u.damaged()) :
                null;
        if(ally != null) return ally;

        return targetBuildings ?
                Units.findAllyTile(unit.team, x, y, range, Building::damaged) :
                null;
    }

    @Override
    protected boolean checkTarget(Unit unit, Teamc target, float x, float y, float range){
        return !(target.within(unit, range + unit.hitSize/2f) ||
                !((target.team() == unit.team && target instanceof Healthc h && h.damaged()) ||
                        (target.team() != unit.team)));
    }

    @Override
    public void update(Unit unit, WeaponMount mount){
        super.update(unit, mount);

        float
                weaponRotation = unit.rotation - 90,
                wx = unit.x + Angles.trnsx(weaponRotation, x, y),
                wy = unit.y + Angles.trnsy(weaponRotation, x, y);

        HealBeamMount beamMount = (HealBeamMount)mount;
        boolean canShoot = mount.shoot;

        if(!autoTarget){
            beamMount.target = null;
            if(canShoot){
                beamMount.lastEnd.set(beamMount.aimX, beamMount.aimY);

                if(!rotate && !Angles.within(Angles.angle(wx, wy, beamMount.aimX, beamMount.aimY), unit.rotation, shootCone)){
                    canShoot = false;
                }
            }


            //limit range
            beamMount.lastEnd.sub(wx, wy).limit(range()).add(wx, wy);

            if(targetBuildings){
                //snap to closest building
                World.raycastEachWorld(wx, wy, beamMount.lastEnd.x, beamMount.lastEnd.y, (x, y) -> {
                    var build = Vars.world.build(x, y);
                    if(build != null && build.team == unit.team && build.damaged()){
                        beamMount.target = build;
                        beamMount.lastEnd.set(x * tilesize, y * tilesize);
                        return true;
                    }
                    return false;
                });
            }
            if(targetUnits){
                //TODO does not support healing units manually yet
            }
        }
        beamMount.strength = Mathf.lerpDelta(beamMount.strength,
                Mathf.num(autoTarget ? mount.target != null : canShoot), 0.2f);

        if(canShoot && mount.target instanceof Healthc u && u.isValid()){

            if(u instanceof Teamc t && t.team() != unit.team()){

                float damage = damagePerSecond * Time.delta;
                u.damage(damage);

            }else if(u instanceof Teamc t && t.team() == unit.team()){

                float baseAmount = repairSpeed * beamMount.strength * Time.delta
                        + fractionRepairSpeed * beamMount.strength * Time.delta * u.maxHealth()/100f;

                if(u instanceof Building b){
                    baseAmount *= b.wasRecentlyDamaged() ? recentDamageMultiplier : 1f;
                    if(beamMount.effectTimer >= reload){
                        healEffect.at(b.x, b.y, 0f, healColor, b.block);
                        beamMount.effectTimer = 0f;
                    }
                }

                u.heal(baseAmount);
            }
            beamMount.effectTimer += Time.delta;
        }
    }
}
