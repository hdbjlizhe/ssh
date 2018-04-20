package com.info.config.filters;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

import com.info.domain.entity.Party;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				//添加装饰路径
		builder.addDecoratorPath("/index", "/decorators/default")
			   .addDecoratorPath("/*", "/decorators/default")
			   .addDecoratorPath("/about", "/decorators/about")
			   .addDecoratorPath("/admin", "/decorators/cms")
			   .addDecoratorPath("/party", "/decorators/party")
			   .addDecoratorPath("/office", "/decorators/cms")
			   .addDecoratorPath("/monthly-report","/decorators/report")
			    //.addDecoratorPath("/login", "/decorator")
				//排除装饰路径
			   .addExcludedPath("/static/**");
			   //.addExcludedPath("/login");
		
		//
		builder.addTagRuleBundles(new DivExtractingTagRuleBundle());
		builder.addTagRuleBundles(new WebSiteMeshFilterCustomTag());
	}
}