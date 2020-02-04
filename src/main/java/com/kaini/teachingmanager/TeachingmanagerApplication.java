package com.kaini.teachingmanager;

import com.kaini.teachingmanager.config.JsonParser;
import com.kaini.teachingmanager.config.TokenConfig;
import com.kaini.teachingmanager.modules.ConfigConsts;
import com.kaini.teachingmanager.modules.DefaultValues;
import com.kaini.teachingmanager.utils.FileExecutor;
import com.kaini.teachingmanager.utils.MailSender;
import com.kaini.teachingmanager.utils.ReflectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

@EnableSwagger2
@SpringBootApplication
public class TeachingmanagerApplication  {

    public static JsonParser settings = new JsonParser();

    public static List<Class<?>> controllers;

    public static Hashtable<String, Integer> tokens;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        settings.setJsonObject(FileExecutor.read(TeachingmanagerApplication.class.getResourceAsStream(DefaultValues.SETTING_PATH)));
        MailSender.config(settings.getObjectUseEval(ConfigConsts.EMAIL_CONFIG_OF_SETTINGS));
        controllers = ReflectUtils.getClasses(DefaultValues.CONTROLLER_PACKAGE);
        tokens = TokenConfig.loadToken();
        SpringApplication.run(TeachingmanagerApplication.class, args);
    }

}
