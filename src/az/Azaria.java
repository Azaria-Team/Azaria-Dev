package az;
//SEX!
import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import az.utils.ManyPlanetSystems;
import az.utils.Utils;
import azaria.gen.EntityRegistry;
import mindustry.game.EventType;
import mindustry.mod.*;
import mindustry.ui.dialogs.BaseDialog;
import az.content.*;

import static mindustry.Vars.*;

public class Azaria extends Mod{
    private static boolean show = false;
    public static boolean dev = true;
    public static String text(String str){
        return Core.bundle.format(str);
    }

    public static void dialogToShow(){
        if(!mobile) {

            BaseDialog dialog = new BaseDialog("Azaria") {
                //for dev
                private float leave = 3f * 60;

                private boolean canClose = false;

                {
                    update(() -> {
                        leave -= Time.delta;
                        if (leave < 0 && !canClose) {
                            canClose = true;
                        }
                    });
                    //cont.add("m-project-hpl").row();
                    cont.image(Core.atlas.find("az-title")).pad(3f).height(70).width(700).row();
                    cont.add(text("d-attention")).row();
                    //cont.add(Core.bundle.format("h.name")).row();
                    cont.add(Core.bundle.format("d.description")).row();
                    buttons.button("", this::hide).update(b -> {
                        b.setDisabled(!canClose);
                        b.setText(canClose ? text("d-got-it") : "[accent]" + Math.floor(leave / 60) + text("d-seconds"));
                    }).size(150f, 50f).center();
                }
            };
            dialog.show();
        }
    }

    public static void dialogShow(){
        if(!dev) {
            if (!mobile) {
                dialogToShow();
            }
        }
    }
    @Override
    public void init() {
        super.init();
        ManyPlanetSystems.init();
    }

    public Azaria(){
        super();
        if(!mobile) {
            Events.on(EventType.ClientLoadEvent.class, e -> Time.runTask(10f, Azaria::dialogShow));
        }
        Events.on(EventType.FileTreeInitEvent.class, e -> AZSounds.load());

        Log.info("Loaded ExampleJavaMod constructor.");
        if(!headless){
            Utils.init();
        }
    }

    @Override
    public void loadContent(){
        EntityRegistry.register();
        AZItems.load();
        AZLiquids.load();
        AZStatusEffects.load();
        AZBullets.load();
        AZUnits.load();
        AZBlocks.load();
        AZLoadouts.load();
        AZPlanets.load();
        AZSectorPreset.load();
        AZWheather.load();
        AZTechTree.load();
    }
}
