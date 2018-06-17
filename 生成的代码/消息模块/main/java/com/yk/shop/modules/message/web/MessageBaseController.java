/**
 * 
 */
package com.yk.shop.modules.message.controller;

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
import com.yk.shop.modules.message.entity.MessageBase;
import com.yk.shop.modules.message.service.MessageBaseService;

/**
 * 消息Controller
 * @author 黄寿勇
 * @version 2018-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/message/messageBase")
public class MessageBaseController extends BaseController {

	@Autowired
	private MessageBaseService messageBaseService;
	
	@ModelAttribute
	public MessageBase get(@RequestParam(required=false) String id) {
		MessageBase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = messageBaseService.get(id);
		}
		if (entity == null){
			entity = new MessageBase();
		}
		return entity;
	}
	
	@RequiresPermissions("message:messageBase:view")
	@RequestMapping(value = {"list", ""})
	public String list(MessageBase messageBase, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MessageBase> page = messageBaseService.findPage(new Page<MessageBase>(request, response), messageBase); 
		model.addAttribute("page", page);
		return "modules/message/messageBaseList";
	}

	@RequiresPermissions("message:messageBase:view")
	@RequestMapping(value = "form")
	public String form(MessageBase messageBase, Model model) {
		model.addAttribute("messageBase", messageBase);
		return "modules/message/messageBaseForm";
	}

	@RequiresPermissions("message:messageBase:edit")
	@RequestMapping(value = "save")
	public String save(MessageBase messageBase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, messageBase)){
			return form(messageBase, model);
		}
		messageBaseService.save(messageBase);
		addMessage(redirectAttributes, "保存消息成功");
		return "redirect:"+Global.getAdminPath()+"/message/messageBase/?repage";
	}
	
	@RequiresPermissions("message:messageBase:edit")
	@RequestMapping(value = "delete")
	public String delete(MessageBase messageBase, RedirectAttributes redirectAttributes) {
		messageBaseService.delete(messageBase);
		addMessage(redirectAttributes, "删除消息成功");
		return "redirect:"+Global.getAdminPath()+"/message/messageBase/?repage";
	}

}