/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pkg;

/**
 *
 * @author vasil
 */
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path(value = "/lol")
public class LolCat {

    @Context
    HttpServletRequest hsr;

    @GET
    @Path(value = "/cat")
    public String list() {
        return "meow";
    }

}
