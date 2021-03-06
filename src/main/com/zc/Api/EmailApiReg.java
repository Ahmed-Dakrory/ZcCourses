package main.com.zc.Api;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;




/**
 * A sample resource that provides access to 
 * server configuration properties
 */
@Path(value="/emailReg")
public class EmailApiReg {
	
    public EmailApiReg() {
    	
    }
    private static String[] list = new String[] {
        "Eric- 932 Deloraine Av.",
        "Yen - 687 Markham Rd.",
        "Keith - 4301 McCowan Rd.",
        "Ron - 465 Melrose St.",
        "Jane - 35 Cranbrooke Av.",
        "Sam - 146 Brooke Av."
        
    };
    
    @GET
    @Produces(value="text/plain")
    public String getList() {
    	
     	
/*

    	 AnnotationConfiguration cfg = new AnnotationConfiguration();
         cfg.addAnnotatedClass(courseReg.class);
         cfg.configure("hibernate.cfg.xml");

         new SchemaExport(cfg).create(true, true);

         SessionFactory factory = cfg.buildSessionFactory();
         Session session = factory.getCurrentSession();
         session.beginTransaction();

         courseReg course=new courseReg();
     	course.setStudentId(3);
     	course.setDate(Calendar.getInstance());
     	course.setCourseId(2);

         session.save(cfg);
         session.getTransaction().commit();
    	*/
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        for (int i = 0; i < list.length; ++i) {
            if (i != 0) 
                buffer.append(", ");
            buffer.append(list[i]);
        }
        buffer.append("}");
        
        return buffer.toString();
    }

    @GET
    @Produces(value="text/plain")
    @Path(value="{id}")
    public String getPropety(@PathParam("id") int id) {
        if (id > -1 && id < list.length -1) {
            return list[id];
        }
        else {
            return "Name Not Found";
        }
    }
    
    @GET
    @Produces(value="text/html")
    @Path(value="html")
    public String getHTMLList()
    {
    	return "<html><body><p><b>Hello</b></body></html>";
    }
    
    @POST
    @Produces(value="text/html")
    @Path(value="form")
    public String handlePost(@PathParam("name") String name,@PathParam("age") int age)
    {
    	return "<html><body><p>name: " + name + "<p>age: " + age;
    }

}
