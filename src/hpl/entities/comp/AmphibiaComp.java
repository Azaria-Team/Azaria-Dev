package hpl.entities.comp;

import arc.math.geom.Vec2;
import arc.util.Time;
import hpl.entities.units.AmphibiaUnitType;
import mindustry.annotations.Annotations;
import mindustry.game.Team;
import mindustry.gen.Unit;
import mindustry.gen.Unitc;
import mindustry.type.UnitType;

/*
* From AvantTeam/ProjectUnity
*/

@Annotations.Component
abstract class AmphibiaComp implements Unitc {
    @Annotations.SyncLocal
    float transformTime;

    @Annotations.Import
    UnitType type;
    @Annotations.Import
    Team team;

    @Annotations.Import
    float x, y, rotation;
    @Annotations.Import
    Vec2 vel;

    @Override
    public void setType(UnitType type){
        if(type instanceof AmphibiaUnitType amphibia){
            transformTime = amphibia.transformTime;
        }
    }

    @Override
    public void update(){
        AmphibiaUnitType type = (AmphibiaUnitType)this.type;
        if(type.transPred.get(self())){
            if(transformTime < 0f || transformTime > type.transformTime){
                Unit next = type.toTrans.get(self()).spawn(team, x, y);
                next.rotation = rotation;
                next.add();
                next.vel.set(vel);

                if(isPlayer()){
                    next.controller(controller());
                }

                remove();
            }else{
                transformTime -= Time.delta;
            }
        }
    }
}
