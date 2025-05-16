package com.dhbw.advsoft.project.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@Theme("my-theme")
public class WmsApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(WmsApplication.class, args);
    }

    public WmsApplication() {}
}
