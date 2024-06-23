package com.example.hello;

import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class ApplicationStart {

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}