/**
 * 
 */
package com.whs.shop.dubbo.services.modules.member.controller;

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
import com.whs.shop.dubbo.services.modules.member.entity.YkMember;
import com.whs.shop.dubbo.services.modules.member.service.YkMemberService;

/**
 * 会员业务Controller
 * @author xie
 * @version 2018-05-02
 */
@Controller
@RequestMapping(value = "${adminPath}/member/ykMember")
public class YkMemberController extends BaseController {

	@Autowired
	private YkMemberService ykMemberService;
	
	@ModelAttribute
	public YkMember get(@RequestParam(required=false) String id) {
		YkMember entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = ykMemberService.get(id);
		}
		if (entity == null){
			entity = new YkMember();
		}
		return entity;
	}
	
	@RequiresPermissions("member:ykMember:view")
	@RequestMapping(value = {"list", ""})
	public String list(YkMember ykMember, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YkMember> page = ykMemberService.findPage(new Page<YkMember>(request, response), ykMember); 
		model.addAttribute("page", page);
		return "modules/member/ykMemberList";
	}

	@RequiresPermissions("member:ykMember:view")
	@RequestMapping(value = "form")
	public String form(YkMember ykMember, Model model) {
		model.addAttribute("ykMember", ykMember);
		return "modules/member/ykMemberForm";
	}

	@RequiresPermissions("member:ykMember:edit")
	@RequestMapping(value = "save")
	public String save(YkMember ykMember, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ykMember)){
			return form(ykMember, model);
		}
		ykMemberService.save(ykMember);
		addMessage(redirectAttributes, "保存会员业务成功");
		return "redirect:"+Global.getAdminPath()+"/member/ykMember/?repage";
	}
	
	@RequiresPermissions("member:ykMember:edit")
	@RequestMapping(value = "delete")
	public String delete(YkMember ykMember, RedirectAttributes redirectAttributes) {
		ykMemberService.delete(ykMember);
		addMessage(redirectAttributes, "删除会员业务成功");
		return "redirect:"+Global.getAdminPath()+"/member/ykMember/?repage";
	}

}