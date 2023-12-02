package io.isiflix.web;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class IsiSpringWebApplication {
    public static void run() {
        try {
            Tomcat tomcat = new Tomcat();
            Connector connector = new Connector();
            connector.setPort(8080);
            tomcat.setConnector(connector);

            Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());
            Tomcat.addServlet(ctx, "IsiDispatchServlet", new IsiDispatchServlet());
            ctx.addServletMappingDecoded("/*", "IsiDispatchServlet");
            tomcat.start();
            tomcat.getServer().await();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
