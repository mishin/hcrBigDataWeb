package com.hcrcms.cms.action.directive;

import static com.hcrcms.cms.Constants.TPL_STYLE_LIST;
import static com.hcrcms.cms.Constants.TPL_SUFFIX;
import static com.hcrcms.common.web.Constants.UTF8;
import static com.hcrcms.common.web.freemarker.DirectiveUtils.OUT_LIST;
import static com.hcrcms.core.web.util.FrontUtils.PARAM_STYLE_LIST;
import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcrcms.cms.entity.main.ContentTag;
import com.hcrcms.cms.manager.main.ContentTagMng;
import com.hcrcms.common.web.freemarker.DirectiveUtils;
import com.hcrcms.common.web.freemarker.ParamsRequiredException;
import com.hcrcms.common.web.freemarker.DirectiveUtils.InvokeType;
import com.hcrcms.core.entity.CmsSite;
import com.hcrcms.core.web.util.FrontUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * TAG列表标签
 */
public class ContentTagListDirective implements TemplateDirectiveModel {
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "tag_list";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		CmsSite site = FrontUtils.getSite(env);
		List<ContentTag> list = contentTagMng.getListForTag(FrontUtils
				.getCount(params));

		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(OUT_LIST, DEFAULT_WRAPPER.wrap(list));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		InvokeType type = DirectiveUtils.getInvokeType(params);
		String listStyle = DirectiveUtils.getString(PARAM_STYLE_LIST, params);
		if (InvokeType.sysDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			env.include(TPL_STYLE_LIST + listStyle + TPL_SUFFIX, UTF8, true);
		} else if (InvokeType.userDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			FrontUtils.includeTpl(TPL_STYLE_LIST, site, env);
		} else if (InvokeType.custom == type) {
			FrontUtils.includeTpl(TPL_NAME, site, params, env);
		} else if (InvokeType.body == type) {
			body.render(env.getOut());
		} else {
			throw new RuntimeException("invoke type not handled: " + type);
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}

	@Autowired
	private ContentTagMng contentTagMng;
}
