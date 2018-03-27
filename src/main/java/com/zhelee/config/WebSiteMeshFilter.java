package com.zhelee.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter{  
  @Override   
  protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {     
     builder.addDecoratorPath("/strategy/shop/list", "/WEB-INF/views/decorators/decorator.jsp")           
     // Map decorators to path patterns.                  
     .addDecoratorPath("/strategy/**", "/WEB-INF/views/decorators/decorator.jsp")                // Exclude path from decoration.           
     .addExcludedPath("/login/**")            
     .addExcludedPath("/main/**")              
     .addExcludedPath("/popup/**");     
   builder.addTagRuleBundles(new DivExtractingTagRuleBundle());  
  }
}