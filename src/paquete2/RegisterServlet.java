package paquete2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("HOLA");
		
		String user = req.getParameter("user");
		String pass = req.getParameter("password");
		String email = req.getParameter("email");

		System.out.println(user);
		System.out.println(pass);
		System.out.println(email);
		
		Pattern usuario = Pattern.compile("^[a-z0-9_-]{3,15}$");
		Matcher usuario2 = usuario.matcher(user);	
		
		System.out.println("HOLA");
		
		Pattern correo = Pattern.compile("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+");
		Matcher correo2 = correo.matcher(email);
		
		System.out.println("HOLAAAA");
		
        
		Pattern contra = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$");
		Matcher contra2 = contra.matcher(pass);
		
		System.out.println("HOLA");
		
		if (usuario2.find() && contra2.find() && correo2.find()) {
			response(resp, "login ok");
		} else {
			response(resp, "invalid login");
		}
		
    }
	
	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
}
