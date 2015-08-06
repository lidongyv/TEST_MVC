package web.mvc.controller.factory;

import java.util.HashMap;

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

public class ActionsFactory {

	private static HashMap<String, Object> action_map = new HashMap<String, Object>();

	public static AddProductAction getAddProActionInstance() {
		AddProductAction action = (AddProductAction) action_map.get("addPro");
		if (action == null) {
			action = new AddProductAction();
			action_map.put("addPro", action);
		}
		return action;
	}
	
	public static AddUserAction getAddUserActionInstance() {
		AddUserAction action = (AddUserAction) action_map.get("addUser");
		if (action == null) {
			action = new AddUserAction();
			action_map.put("addUser", action);
		}
		return action;
	}
	
	public static WakeUserAction getWakeUserActionInstance() {
		WakeUserAction action = (WakeUserAction) action_map.get("wakeUser");
		if (action == null) {
			action = new WakeUserAction();
			action_map.put("wakeUser", action);
		}
		return action;
	}
	
	public static FrozenUserAction getFrozenUserActionInstance() {
		FrozenUserAction action = (FrozenUserAction) action_map.get("frozenUser");
		if (action == null) {
			action = new FrozenUserAction();
			action_map.put("frozenUser", action);
		}
		return action;
	}

	public static GetAllSortAction getAllSortActionInstance() {
		GetAllSortAction action = (GetAllSortAction) action_map
				.get("gasAction");
		if (action == null) {
			action = new GetAllSortAction();
			action_map.put("gasAction", action);
		}
		return action;
	}

	public static GetAllProAction getAllProActionInstance() {
		GetAllProAction action = (GetAllProAction) action_map.get("getAllPro");
		if (action == null) {
			action = new GetAllProAction();
			action_map.put("getAllPro", action);
		}
		return action;
	}
	
	public static SearchProductByCategoryAction getSearchCategoryActionInstance() {
		SearchProductByCategoryAction action = (SearchProductByCategoryAction) action_map.get("searchAllPro");
		if (action == null) {
			action = new SearchProductByCategoryAction();
			action_map.put("searchAllPro", action);
		}
		return action;
	}

	public static DelProdAction getDelProActionInstance() {
		DelProdAction action = (DelProdAction) action_map.get("delPro");
		if (action == null) {
			action = new DelProdAction();
			action_map.put("delPro", action);
		}
		return action;
	}
	
	public static DelUserAction getDelUserActionInstance() {
		DelUserAction action = (DelUserAction) action_map.get("delUser");
		if (action == null) {
			action = new DelUserAction();
			action_map.put("delUser", action);
		}
		return action;
	}

	public static ModifyProdAction getModifyProActionInstance() {
		ModifyProdAction action = (ModifyProdAction) action_map
				.get("modifyPro");
		if (action == null) {
			action = new ModifyProdAction();
			action_map.put("modifyPro", action);
		}
		return action;
	}

	// DoModifyProdAction
	public static DoModifyProdAction getDoModifyProActionInstance() {
		DoModifyProdAction action = (DoModifyProdAction) action_map
				.get("doModifyPro");
		if (action == null) {
			action = new DoModifyProdAction();
			action_map.put("doModifyPro", action);
		}
		return action;
	}
	
	public static UserLoginAction getDoUserLoginActionInstance() {
		UserLoginAction action = (UserLoginAction) action_map
				.get("doUserLogin");
		if (action == null) {
			action = new UserLoginAction();
			action_map.put("doUserLogin", action);
		}
		return action;
	}
}
