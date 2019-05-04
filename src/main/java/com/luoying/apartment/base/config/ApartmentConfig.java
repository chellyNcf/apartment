package com.luoying.apartment.base.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApartmentConfig {

    @Value("${apartment.filePath}")
    private String filePath; //配置文件配置的物理保存地址

}
