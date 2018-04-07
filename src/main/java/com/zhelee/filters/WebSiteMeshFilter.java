package com.zhelee.filters;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				//添加装饰路径
		builder.addDecoratorPath("/*", "/decorators/default")
			   .addDecoratorPath("/about", "/decorators/about")
			   .addDecoratorPath("/admin", "/decorators/about")
			    //.addDecoratorPath("/login", "/decorator")
				//排除装饰路径
			   .addExcludedPath("/static/**");
			   //.addExcludedPath("/login");
		
		//
		builder.addTagRuleBundles(new DivExtractingTagRuleBundle());
		builder.addTagRuleBundles(new WebSiteMeshFilterCustomTag());
	}
}