package com.info.config.filters;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				//添加装饰路径
		builder.addDecoratorPath("/index", "/decorators/default")
			   .addDecoratorPath("/*", "/decorators/default")
			   .addDecoratorPath("/about", "/decorators/about")
			   .addDecoratorPath("/admin", "/decorators/cms")
			   .addDecoratorPath("/party", "/decorators/party")
			   .addDecoratorPath("/office", "/decorators/office")
			   .addDecoratorPath("/daily","/decorators/daily")
			   .addDecoratorPath("/daily/monthReport","/decorators/report")
			   .addDecoratorPath("/daily/monthReport/overview", "/decorators/default")
			   .addDecoratorPath("/daily/monthReport/fill", "/decorators/report")
			   .addDecoratorPath("/daily/monthReport/**", "/decorators/report")	
			   .addDecoratorPath("/personel", "/decorators/personel")
			   .addDecoratorPath("/user/details", "/decorators/userdetails")
			   .addDecoratorPath("/personel/evaluationDept", "/decorators/personel")
			   .addDecoratorPath("/personel/evaluationQuery", "/decorators/personel")
			   .addDecoratorPath("/personel/evaluationFill", "/decorators/default")
			   .addDecoratorPath("/personel/employees/info/**", "/decorators/personel")
			   .addDecoratorPath("/personel/employees/details/**", "/decorators/default")
				//排除装饰路径
			   .addExcludedPath("/static/**");
			   //.addExcludedPath("/login")
			   //.addExcludedPath("/register");
		
		//
		builder.addTagRuleBundles(new DivExtractingTagRuleBundle());
		builder.addTagRuleBundles(new WebSiteMeshFilterCustomTag());
	}
}