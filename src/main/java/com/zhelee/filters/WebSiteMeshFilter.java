package com.zhelee.filters;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				//添加装饰路径
		builder.addDecoratorPath("/*", "/decorator.html")
			   .addDecoratorPath("/strategy/**", "/decorator.html")
				//排除装饰路径
			   .addExcludedPath("/static/**")
				.addExcludedPath("/login/**")
				.addExcludedPath("/main/**")
				.addExcludedPath("/popup/**");
		builder.addTagRuleBundles(new DivExtractingTagRuleBundle());
	}
}