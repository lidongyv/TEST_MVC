package web.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.mvc.controller.action.AddProductAction;
import web.mvc.controller.action.AddUserAction;
import web.mvc.controller.action.DelProdAction;
import web.mvc.controller.action.DelUserAction;
import web.mvc.controller.action.DoModifyProdAction;
import web.mvc.controller.action.FrozenUserAction;
import web.mvc.controller.action.GetAllProAction;
import web.mvc.controller.action.GetAllSortAction;
import web.mvc.controller.action.ModifyProdAction;
import web.mvc.controller.action.SearchProductByCategoryAction;
import web.mvc.controller.action.UserLoginAction;
import web.mvc.controller.action.WakeUserAction;
import web.mvc.controller.factory.ActionsFactory;

public class CoreControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String app_name = request.getContextPath();
		System.out.println(uri);
		String servlet_path = uri
				.substring(app_name.length(), uri.length() - 4);
		
		
		if (servlet_path.equals("/addProduct_do")) {
			AddProductAction addProAction = ActionsFactory
					.getAddProActionInstance();
			addProAction.execute(request, response);
		}
		
		if (servlet_path.equals("/viewCategory")) {
			GetAllSortAction gasAction = ActionsFactory
					.getAllSortActionInstance();
			gasAction.execute(request, response);
		}
		
		if (servlet_path.equals("/viewProduct")) {
			GetAllProAction gapAction = ActionsFactory
					.getAllProActionInstance();
			gapAction.execute(request, response);
		}
		
		if (servlet_path.equals("/deleteProduct_do")) {
			DelProdAction delPro = ActionsFactory.getDelProActionInstance();
			delPro.execute(request, response);
		}
		
		if (servlet_path.equals("/deleteUser_do")) {
			DelUserAction delUser = ActionsFactory.getDelUserActionInstance();
			delUser.execute(request, response);
		}
		
		if (servlet_path.equals("/modifyProduct_do")) {
			ModifyProdAction modifyPro = ActionsFactory
					.getModifyProActionInstance();
			modifyPro.execute(request, response);
		}
		
		if (servlet_path.equals("/to_modifyProduct_do")) {
			DoModifyProdAction doModifyPro = ActionsFactory
					.getDoModifyProActionInstance();
			doModifyPro.execute(request, response);
		}
		
		if (servlet_path.equals("/userlogin")) {
			UserLoginAction doUserLogin = ActionsFactory
					.getDoUserLoginActionInstance();
			doUserLogin.execute(request, response);
		}
		
		if (servlet_path.equals("/addUser_do")) {
			AddUserAction addUserAction = ActionsFactory
					.getAddUserActionInstance();
			addUserAction.execute(request, response);
		}
		
		if (servlet_path.equals("/wakeUser_do")) {
			WakeUserAction wakeUserAction = ActionsFactory
					.getWakeUserActionInstance();
			wakeUserAction.execute(request, response);
		}
		
		if (servlet_path.equals("/frozenUser_do")) {
			FrozenUserAction frozenUserAction = ActionsFactory
					.getFrozenUserActionInstance();
			frozenUserAction.execute(request, response);
		}
		
		if (servlet_path.equals("/searchProductByCategory")) {
			SearchProductByCategoryAction sbpcAction = ActionsFactory
					.getSearchCategoryActionInstance();
			sbpcAction.execute(request, response);
		}
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.processRequest(request, response);
	}
}
