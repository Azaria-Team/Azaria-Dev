package hlp;
//SEX!
import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import hlp.utils.ManyPlanetSystems;
import mindustry.game.EventType;
import mindustry.mod.*;
import mindustry.ui.dialogs.BaseDialog;
import hlp.content.*;

public class HLP extends Mod{

    public HLP(){
        Log.info("Loaded ExampleJavaMod constructor.");

        Events.on(EventType.ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {

                BaseDialog dialog = new BaseDialog("Attention!");
                dialog.cont.add("The mod is under development and there you can see unfinished content/bugs!").row();
                dialog.cont.image(Core.atlas.find("HLP-fors")).pad(20f).row();
                dialog.cont.button("Okay", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });

    }
    @Override
    public void init() {
        super.init();
        ManyPlanetSystems.init();
    }

    @Override
    public void loadContent(){
        HLPItems.load();
        HLPLiquids.load();
        HLPStatusEffects.load();
        HLPBullets.load();
        HLPUnits.load();
        HLPBlocks.load();
        HLPPlanets.load();
    }
}
