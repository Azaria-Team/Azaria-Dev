package hpl.content;

import static mindustry.content.TechTree.*;
import static hpl.content.HPLItems.*;
import static hpl.content.HPLBlocks.*;

public class HPLTechTree {

    public static void load(){
        HPLPlanets.auriona.techTree = nodeRoot("auriona", coreLegion, () -> {
            //region crafting
            node(forsDrill, () -> {
                });
            });
            //endregion crafting

            //region items and liquids
            nodeProduce(HPLItems.fors, () -> {
                nodeProduce(craside, () -> {
                    nodeProduce(khylid, () -> {
                        nodeProduce(ferbium, () -> {
                        });
                    });
                });
            });
        //endregion turrets
        //endregion blocks
    }
}
