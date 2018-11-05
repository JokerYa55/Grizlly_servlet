/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pkg;

import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vasil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static EntityManagerFactory emf = null;

    public static EntityManager getEM() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("base_JPA");
        }
        return emf.createEntityManager();
    }

    public static void main(String[] args) throws IOException {
        // static content is linked from here
        GrizzlyWebServer gws = new GrizzlyWebServer(8080, "/var/www");
        // Jersey web resources
        ServletAdapter jerseyAdapter = new ServletAdapter();
        jerseyAdapter.addInitParameter("com.sun.jersey.config.property.packages",
                "com.example");
        jerseyAdapter.setContextPath("/jersey");
        jerseyAdapter.setServletInstance(new ServletContainer());
        // Another non-Jersey servlet
        ServletAdapter simpleServletAdapter = new ServletAdapter();
        simpleServletAdapter.setContextPath("/simple");
        simpleServletAdapter.setProperty( "load-on-startup", 1);
        simpleServletAdapter.setServletInstance(new SimpleServlet());
        
        /*ServletAdapter freemarkerAdapter = new ServletAdapter();
        
        freemarkerAdapter.setServletInstance(new freemarker.ext.servlet.FreemarkerServlet());
        freemarkerAdapter.addInitParameter("TemplatePath", "/var/www");
        freemarkerAdapter.addInitParameter("NoCache", "true");
        freemarkerAdapter.addInitParameter("NoCache", "true");
        freemarkerAdapter.addInitParameter("ContentType", "text/html; charset=UTF-8");
        freemarkerAdapter.addInitParameter("template_update_delay", "0");
        freemarkerAdapter.addInitParameter("default_encoding", "UTF-8");
        freemarkerAdapter.addInitParameter("number_format", "0.##########");
        freemarkerAdapter.setProperty( "load-on-startup", 1);*/
        //freemarkerAdapter.add
        
        
        
        // register all above defined adapters
        gws.addGrizzlyAdapter(jerseyAdapter, new String[]{"/jersey"});
        gws.addGrizzlyAdapter(simpleServletAdapter, new String[]{"/simple"});
        //gws.addGrizzlyAdapter(freemarkerAdapter, new String[]{"*.ftl"});
        // let Grizzly run
        gws.start();
    }

}
