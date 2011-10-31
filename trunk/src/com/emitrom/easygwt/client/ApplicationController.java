package com.emitrom.easygwt.client;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.easygwt.client.core.authentication.SampleLoginAuthenticator;
import com.emitrom.easygwt.client.core.injection.SampleInjector;
import com.emitrom.easygwt.client.resources.SampleIcons;
import com.emitrom.easygwt.client.resources.SampleImages;
import com.emitrom.easygwt.client.resources.I18N.SampleConstants;
import com.emitrom.easygwt.wf.client.column.core.ColumnNavigationChild;
import com.emitrom.easygwt.wf.client.column.core.ColumnNavigationParent;
import com.emitrom.easygwt.wf.client.column.core.ColumnViewPort;
import com.emitrom.easygwt.wf.client.widgets.effects.fisheye.FishEye;
import com.emitrom.easygwt.wf.client.widgets.effects.fisheye.FishEyeClickHandler;
import com.emitrom.easygwt.wf.client.widgets.effects.fisheye.FishEyeImage;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Image;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ApplicationController implements EntryPoint {
	
	private static SampleIcons icons = GWT.create(SampleIcons.class);
	private static SampleImages images = GWT.create(SampleImages.class);
	private static SampleConstants constants = GWT.create(SampleConstants.class);
	private static SampleInjector injector = GWT.create(SampleInjector.class);
	
	public void onModuleLoad() {
		
		/**
		 * Removing the loading gif.
		 */
		DOM.getElementById("loading").removeFromParent();
		
		/**
		 * Authenticate
		 */
		new SampleLoginAuthenticator() {

			@Override
			public void onSuccess() {
				/**
				 * Column View Sample
				 */
				ColumnViewPort columnView = ColumnViewPort.getInstance(100, 200, 100, 200);
				
				columnView.getNorthPanel().add(new Image(images.leftBanner()));
				
				HorizontalPanel imagePanel = new HorizontalPanel();
				imagePanel.setStyleAttribute("float", "right");
				imagePanel.add(new Image(images.rightBanner()));
				
				columnView.getNorthPanel().add(imagePanel);
				
				columnView.getNorthPanel().getNorthPanelToolBar().add(new FillToolItem());
				
				Button logoutButton = new Button();
				logoutButton.setIcon(AbstractImagePrototype.create(icons.doorOut()));
				logoutButton.setToolTip("Logout");
				logoutButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						logout();
					}
				});

				columnView.getNorthPanel().getNorthPanelToolBar().add(new Html("<b>" + loginDialog.getUsernameTextField().getValue() + "<b/>"));
				
				columnView.getSouthPanel().add(new FishEye(getFishImageList(), 40, 80, 2));
				columnView.getNorthPanel().getNorthPanelToolBar().add(new SeparatorToolItem());
				columnView.getNorthPanel().getNorthPanelToolBar().add(logoutButton);
				
				List<ColumnNavigationParent> navigationParentsList = new ArrayList<ColumnNavigationParent>();
				
				ColumnNavigationParent parent1 = new ColumnNavigationParent();
				parent1.setHeading(constants.usersViewHeading());
				parent1.setIcon(AbstractImagePrototype.create(icons.chartBar()));
				
				ColumnNavigationChild parent1Child1 = new ColumnNavigationChild(injector.getUsersView(), 
						constants.usersViewHeading());
				parent1Child1.setIcon(icons.house());
				parent1.addNavigationChild(parent1Child1);
				
				navigationParentsList.add(parent1);

				columnView.addNavigationItems(navigationParentsList);

			}

		};
		
	}
	
	private List<FishEyeImage> getFishImageList() {
		
		List<FishEyeImage> fishImageList = new ArrayList<FishEyeImage>();

		FishEyeImage fishEyeImage = new FishEyeImage();

		fishEyeImage.setImageName("resources/easygwt/images/icons/mac-icon-");
		fishEyeImage.setLowSize(40);
		fishEyeImage.setHighSize(80);
		fishEyeImage.setExtension(".png");
		fishEyeImage.setClickHandler(new FishEyeClickHandler() {

			@Override
			public void onClick() {
				MessageBox.alert("Click Handler", "Activated Click Handler", null);
			}
		});
		fishImageList.add(fishEyeImage);

		fishEyeImage = new FishEyeImage();
		fishEyeImage.setImageName("resources/easygwt/images/icons/mac-icon-");
		fishEyeImage.setLowSize(40);
		fishEyeImage.setHighSize(80);
		fishEyeImage.setExtension(".png");
		fishEyeImage.setClickHandler(new FishEyeClickHandler() {

			@Override
			public void onClick() {
				MessageBox.alert("Click Handler", "Activated Click Handler", null);
			}
		});
		fishImageList.add(fishEyeImage);
		
		fishEyeImage = new FishEyeImage();
		fishEyeImage.setImageName("resources/easygwt/images/icons/mac-icon-");
		fishEyeImage.setLowSize(40);
		fishEyeImage.setHighSize(80);
		fishEyeImage.setExtension(".png");
		fishEyeImage.setClickHandler(new FishEyeClickHandler() {

			@Override
			public void onClick() {
				MessageBox.alert("Click Handler", "Activated Click Handler", null);
			}
		});
		fishImageList.add(fishEyeImage);

		fishEyeImage = new FishEyeImage();
		fishEyeImage.setImageName("resources/easygwt/images/icons/mac-icon-");
		fishEyeImage.setLowSize(40);
		fishEyeImage.setHighSize(80);
		fishEyeImage.setExtension(".png");
		fishEyeImage.setClickHandler(new FishEyeClickHandler() {

			@Override
			public void onClick() {
				MessageBox.alert("Click Handler", "Activated Click Handler", null);
			}
		});
		fishImageList.add(fishEyeImage);

		fishEyeImage = new FishEyeImage();
		fishEyeImage.setImageName("resources/easygwt/images/icons/mac-icon-");
		fishEyeImage.setLowSize(40);
		fishEyeImage.setHighSize(80);
		fishEyeImage.setExtension(".png");
		fishEyeImage.setClickHandler(new FishEyeClickHandler() {

			@Override
			public void onClick() {
				MessageBox.alert("Click Handler", "Activated Click Handler", null);
			}
		});
		fishImageList.add(fishEyeImage);

		fishEyeImage = new FishEyeImage();
		fishEyeImage.setImageName("resources/easygwt/images/icons/mac-icon-");
		fishEyeImage.setLowSize(40);
		fishEyeImage.setHighSize(80);
		fishEyeImage.setExtension(".png");
		fishEyeImage.setClickHandler(new FishEyeClickHandler() {

			@Override
			public void onClick() {
				MessageBox.alert("Click Handler", "Activated Click Handler", null);
			}
		});
		fishImageList.add(fishEyeImage);

		fishEyeImage = new FishEyeImage();
		fishEyeImage.setImageName("resources/easygwt/images/icons/mac-icon-");
		fishEyeImage.setLowSize(40);
		fishEyeImage.setHighSize(80);
		fishEyeImage.setExtension(".png");
		fishEyeImage.setClickHandler(new FishEyeClickHandler() {

			@Override
			public void onClick() {
				MessageBox.alert("Click Handler", "Activated Click Handler", null);
			}
		});
		fishImageList.add(fishEyeImage);
		
		return fishImageList;
		
	}
	
}
