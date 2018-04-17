package com.info.config.filters;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

public class WebSiteMeshFilterCustomTag implements TagRuleBundle {

	@Override
	public void install(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {
		defaultState.addRule("left",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("left"), false));
		defaultState.addRule("right",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("right"), false));
		defaultState.addRule("top",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("top"), false));
		defaultState.addRule("bottom",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("bottom"), false));
		defaultState.addRule("middle",
				new ExportTagToContentRule(siteMeshContext, contentProperty.getChild("middle"), false));}

	@Override
	public void cleanUp(State defaultState, ContentProperty contentProperty, SiteMeshContext siteMeshContext) {

	}

}
