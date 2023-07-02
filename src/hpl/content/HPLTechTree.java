package hpl.content;

import static mindustry.content.TechTree.*;
import static hpl.content.HPLItems.*;
import static hpl.content.HPLBlocks.*;

public class HPLTechTree {

    public static void load(){
        HPLPlanets.auriona.techTree = nodeRoot("auriona", coreLegion, () -> {
            //region distribution
            nodeProduce(impulseConveyor, () -> {
                nodeProduce(impulseJunction, () -> {
                    nodeProduce(impulseRouter, () -> {
                    });
                });
                nodeProduce(impulseBridge, () -> {
                });
            });
            //endregion distribution
            //region crafting
            node(forsDrill, () -> {
                node(pumpDrill, () -> {
                });
            });
            //endregion crafting
            //region power
            node(plasmaNode, () -> {
                node(plasmaDistributor, () -> {
                });
            });

            node(thermalEvaporator, () -> {
            });
            //endregion power
            //region defense
            node(forsWall, () -> {
                node(forsWallLarge, () -> {
                });
            });
            //endregion defense
            //region turrets
            node(forceTurret, () -> {
            });
            //endregion turrets
            //endregion blocks
        });
        //region items and liquids
        nodeProduce(HPLItems.fors, () -> {
            nodeProduce(craside, () -> {
                nodeProduce(khylid, () -> {
                    nodeProduce(ferbium, () -> {
                    });
                });
            });
        });
        //endregion items and liquids
    }
}
