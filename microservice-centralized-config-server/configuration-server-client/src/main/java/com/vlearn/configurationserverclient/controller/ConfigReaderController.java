package com.vlearn.configurationserverclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigReaderController {

    @Value("${server.application.name: Unable to connect config server}")
    String configServer;

    @RequestMapping("/centralizedConfig")
    String centralizedConfigServer() {
        return configServer;
    }

}
