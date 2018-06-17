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
import com.yk.shop.modules.account.entity.YkCfgPayment;
import com.yk.shop.modules.account.service.YkCfgPaymentService;

/**
 * 支付配置Controller
 * @author 黄寿勇
 * @version 2018-05-15
 */
@Controller
@RequestMapping(value = "${adminPath}/account/ykCfgPayment")
public class YkCfgPaymentController extends BaseController {

	@Autowired
	private YkCfgPaymentService ykCfgPaymentService;
	
	@ModelAttribute
	public YkCfgPayment get(@RequestParam(required=false) String id) {
		YkCfgPayment entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ykCfgPaymentService.get(id);
		}
		if (entity == null){
			entity = new YkCfgPayment();
		}
		return entity;
	}
	
	@RequiresPermissions("account:ykCfgPayment:view")
	@RequestMapping(value = {"list", ""})
	public String list(YkCfgPayment ykCfgPayment, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YkCfgPayment> page = ykCfgPaymentService.findPage(new Page<YkCfgPayment>(request, response), ykCfgPayment); 
		model.addAttribute("page", page);
		return "modules/account/ykCfgPaymentList";
	}

	@RequiresPermissions("account:ykCfgPayment:view")
	@RequestMapping(value = "form")
	public String form(YkCfgPayment ykCfgPayment, Model model) {
		model.addAttribute("ykCfgPayment", ykCfgPayment);
		return "modules/account/ykCfgPaymentForm";
	}

	@RequiresPermissions("account:ykCfgPayment:edit")
	@RequestMapping(value = "save")
	public String save(YkCfgPayment ykCfgPayment, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ykCfgPayment)){
			return form(ykCfgPayment, model);
		}
		ykCfgPaymentService.save(ykCfgPayment);
		addMessage(redirectAttributes, "保存支付配置成功");
		return "redirect:"+Global.getAdminPath()+"/account/ykCfgPayment/?repage";
	}
	
	@RequiresPermissions("account:ykCfgPayment:edit")
	@RequestMapping(value = "delete")
	public String delete(YkCfgPayment ykCfgPayment, RedirectAttributes redirectAttributes) {
		ykCfgPaymentService.delete(ykCfgPayment);
		addMessage(redirectAttributes, "删除支付配置成功");
		return "redirect:"+Global.getAdminPath()+"/account/ykCfgPayment/?repage";
	}

}