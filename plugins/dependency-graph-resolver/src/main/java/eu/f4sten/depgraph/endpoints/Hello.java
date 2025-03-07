package eu.f4sten.depgraph.endpoints;

import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.f4sten.depgraph.data.Coordinates;
import eu.f4sten.depgraph.data.Naming;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

    private static final Logger LOG = LoggerFactory.getLogger(Hello.class);

    public final String name;
    private final Coordinates coords;

    @Inject
    public Hello(Naming n, Coordinates coords) {
        this.coords = coords;
        LOG.info("init");
        this.name = n.name;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello " + name + "! (plain text)";
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello " + name + "! (XML)</hello>";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Hello sayJSonHello() {
        return this;
    }

    @GET
    @Path("/coords")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<String> getProcessedCoordinates() {
        return coords.processed;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        LOG.info("html");
        return "<html><body>" + "Hello " + name + "! (HTML)</body></html> ";
    }
}