/*
 * Copyright 2002-2012 SCOOP Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.scoopgmbh.copper.gui.ui.workflowsummery.filter;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.converter.LongStringConverter;
import de.scoopgmbh.copper.gui.context.FormContext;
import de.scoopgmbh.copper.gui.form.FxmlController;
import de.scoopgmbh.copper.gui.form.filter.FilterController;
import de.scoopgmbh.copper.gui.util.WorkflowVersion;

public class WorkflowSummeryFilterController implements Initializable, FilterController<WorkflowSummeryFilterModel>, FxmlController {
	private final WorkflowSummeryFilterModel model= new WorkflowSummeryFilterModel();
	private final FormContext formFactory;

	public WorkflowSummeryFilterController(FormContext formFactory) {
		super();
		this.formFactory = formFactory;
	}
	
	
	public void setFilter(WorkflowVersion workflowVersion){
		model.setAllFrom(workflowVersion);
	}
	
    @FXML //  fx:id="majorVersion"
    private TextField majorVersion; // Value injected by FXMLLoader

    @FXML //  fx:id="minorVersion"
    private TextField minorVersion; // Value injected by FXMLLoader

    @FXML //  fx:id="searchMenueItem"
    private CustomMenuItem searchMenueItem; // Value injected by FXMLLoader

    @FXML //  fx:id="serachbutton"
    private MenuButton serachbutton; // Value injected by FXMLLoader

    @FXML //  fx:id="workflowClass"
    private TextField workflowClass; // Value injected by FXMLLoader
    
    @FXML //  fx:id="patchLevel"
    private TextField patchLevel; // Value injected by FXMLLoader

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert majorVersion != null : "fx:id=\"majorVersion\" was not injected: check your FXML file 'WorkflowSummeryFilter.fxml'.";
        assert minorVersion != null : "fx:id=\"minorVersion\" was not injected: check your FXML file 'WorkflowSummeryFilter.fxml'.";
        assert searchMenueItem != null : "fx:id=\"searchMenueItem\" was not injected: check your FXML file 'WorkflowSummeryFilter.fxml'.";
        assert serachbutton != null : "fx:id=\"serachbutton\" was not injected: check your FXML file 'WorkflowSummeryFilter.fxml'.";
        assert workflowClass != null : "fx:id=\"workflowClass\" was not injected: check your FXML file 'WorkflowSummeryFilter.fxml'.";
        assert patchLevel != null : "fx:id=\"patchLevel\" was not injected: check your FXML file 'WorkflowSummeryFilter.fxml'.";
        
        workflowClass.textProperty().bindBidirectional(model.classname );
        majorVersion.textProperty().bindBidirectional(model.versionMajor, new LongStringConverter());
        minorVersion.textProperty().bindBidirectional(model.versionMinor, new LongStringConverter());
        patchLevel.textProperty().bindBidirectional(model.patchlevel, new LongStringConverter());
        
        searchMenueItem.setContent(formFactory.createWorkflowClassesTreeForm(this).createContent());
        serachbutton.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/de/scoopgmbh/copper/gui/icon/search.png"))));
        
        searchMenueItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});

        searchMenueItem.getStyleClass().setAll("workflowclassSearchMenueItem","menu-item");
	}

	@Override
	public WorkflowSummeryFilterModel getFilter() {
		return model;
	}

	@Override
	public URL getFxmlRessource() {
		return getClass().getResource("WorkflowSummeryFilter.fxml");
	}
	
	
}