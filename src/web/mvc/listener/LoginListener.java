package web.mvc.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
@WebListener
public class LoginListener implements ServletRequestListener, ServletRequestAttributeListener {

	private String user = null;
    /**
     * Default constructor. 
     */
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub


    	
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	HttpServletRequest request = 
    			(HttpServletRequest)sre.getServletRequest();  
//    	System.out.println("----发向" + request.getRequestURI()  
//    			+ "请求被初始化----");  
    	StringBuffer cr = request.getRequestURL();
    	String dr = cr.toString();
    	String loginrequest = "http://localhost:8080/TEST_MVC/userlogin.mis";
    	String addprorequest = "http://localhost:8080/TEST_MVC/addProduct_do.mis";
    	String delprorequest = "http://localhost:8080/TEST_MVC/deleteProduct_do.mis";
    	if(dr.equals(loginrequest)){
        	String id = request.getParameter("login_id");
    		Date now = new Date();
        	SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        	String times = dateFormat.format(now);
    		System.out.println(id+" at "+times+" login the system");
    		user = id;
    	}
    	
    	if(dr.equals(addprorequest)){
    		String addproid = request.getParameter("productId");
    		Date now = new Date();
        	SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        	String times = dateFormat.format(now);
    		System.out.println(user+" at "+times+" add a product:"+addproid);
    	}
    	
    	if(dr.equals(delprorequest)){
    		String delproid = request.getParameter("productid");
    		Date now = new Date();
        	SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        	String times = dateFormat.format(now);
    		System.out.println(user+" at "+times+" delete a product:"+delproid);
    	}
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    }
    
}
