package hlp.content;

import static mindustry.content.TechTree.*;
import static hlp.content.HLPItems.*;
import static hlp.content.HLPBlocks.*;
import hlp.content.HLPUnits.*;

public class HLPTechTree{

    public static void load(){
        HLPPlanets.auriona.techTree = nodeRoot("auriona", coreLegion, () -> {
            //region crafting
            node(forsDrill, () -> {
                });
            });
            //endregion crafting

            //region items and liquids
            nodeProduce(HLPItems.fors, () -> {
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
