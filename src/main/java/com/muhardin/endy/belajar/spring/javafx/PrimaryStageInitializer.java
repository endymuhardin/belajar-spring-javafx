package com.muhardin.endy.belajar.spring.javafx;

import com.muhardin.endy.belajar.spring.javafx.controller.FormContactController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {

    private final FxWeaver fxWeaver;

    @Autowired
    public PrimaryStageInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        log.debug("Running StageReadyEvent handler");
        Stage stage = event.stage;
        Parent root = fxWeaver.loadView(FormContactController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
