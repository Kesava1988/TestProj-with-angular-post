package Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import Dao.TestDao;
import Modal.TestModal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/modal")
@Api(tags = {"/modal"})
public class TestController
{
	
	/**
	 * Create a new modal
	 * Returns modal with confirmation number and status
	 * @throws RRSException 
	 */
	@POST
	@Path("/newmodal")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(
			value = "Create a new modal",
			notes = "Create a new modal in the database")
	@ApiResponses( value = {
			@ApiResponse (code=200, message="Success"),
			@ApiResponse (code=500, message="Internal Server Error")
			})
	public TestModal createTest(TestModal modal)
	{
		try
		{
			//Add the modal into database
			TestDao custDao = new TestDao();
			return custDao.createTest(modal);
		} 
		catch (Exception e)
		{
			throw new WebApplicationException(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
		}
	}
	
}
