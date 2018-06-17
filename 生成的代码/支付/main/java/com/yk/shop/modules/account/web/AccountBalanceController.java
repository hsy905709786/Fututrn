/**
 * 
 */
package com.yk.shop.modules.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.whs.shop.common.config.Global;
import com.whs.shop.baseentity.Page;
import com.whs.shop.common.web.BaseController;
import com.whs.shop.common.utils.StringUtils;
import com.yk.shop.modules.account.entity.AccountBalance;
import com.yk.shop.modules.account.service.AccountBalanceService;

/**
 * 支付配置Controller
 * @author 黄寿勇
 * @version 2018-05-14
 */
@Controller
@RequestMapping(value = "${adminPath}/account/accountBalance")
public class AccountBalanceController extends BaseController {

	@Autowired
	private AccountBalanceService accountBalanceService;
	
	@ModelAttribute
	public AccountBalance get(@RequestParam(required=false) String id) {
		AccountBalance entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = accountBalanceService.get(id);
		}
		if (entity == null){
			entity = new AccountBalance();
		}
		return entity;
	}
	
	@RequiresPermissions("account:accountBalance:view")
	@RequestMapping(value = {"list", ""})
	public String list(AccountBalance accountBalance, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AccountBalance> page = accountBalanceService.findPage(new Page<AccountBalance>(request, response), accountBalance); 
		model.addAttribute("page", page);
		return "modules/account/accountBalanceList";
	}

	@RequiresPermissions("account:accountBalance:view")
	@RequestMapping(value = "form")
	public String form(AccountBalance accountBalance, Model model) {
		model.addAttribute("accountBalance", accountBalance);
		return "modules/account/accountBalanceForm";
	}

	@RequiresPermissions("account:accountBalance:edit")
	@RequestMapping(value = "save")
	public String save(AccountBalance accountBalance, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, accountBalance)){
			return form(accountBalance, model);
		}
		accountBalanceService.save(accountBalance);
		addMessage(redirectAttributes, "保存支付配置成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountBalance/?repage";
	}
	
	@RequiresPermissions("account:accountBalance:edit")
	@RequestMapping(value = "delete")
	public String delete(AccountBalance accountBalance, RedirectAttributes redirectAttributes) {
		accountBalanceService.delete(accountBalance);
		addMessage(redirectAttributes, "删除支付配置成功");
		return "redirect:"+Global.getAdminPath()+"/account/accountBalance/?repage";
	}

}