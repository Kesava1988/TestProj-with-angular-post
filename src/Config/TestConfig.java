package Config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * @author Kesava
 * Jersey configuration and url mapping
 */
@ApplicationPath("/api")
public class TestConfig extends ResourceConfig
{
	public TestConfig()
	{
		packages("Controller");
		
		//Bean config for swagger		
		register(io.swagger.jaxrs.listing.ApiListingResource.class);
		register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		
		BeanConfig config = new BeanConfig();
		config.setBasePath("/TestProj/api");
		config.setDescription("Test System");
		config.setVersion("1.0");
		config.setSchemes(new String [] {"http"});
		config.setResourcePackage("Controller");
		config.setTitle("Test API");
		config.setScan(true);
	}
}
