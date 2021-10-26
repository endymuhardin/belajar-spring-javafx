package com.muhardin.endy.belajar.spring.javafx;

import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component @Slf4j
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        log.debug("Running StageReadyEvent handler");
        Stage eventSource = (Stage) event.getSource();
        eventSource.show();
    }
}
