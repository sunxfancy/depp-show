package org.sxf.deppshow;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

/**
 * Created by sxf on 17-1-21.
 */

public class Controller {

    @FXML
    public void initialize() {
        slider.setMin(0);
        slider.setValue(0);
        slider.setBlockIncrement(1.0);
        slider.setMajorTickUnit(1.0);
        slider.valueProperty().bindBidirectional(page_num);
        pages.textProperty().bind(page_num.asString());
        page_num.addListener((event) -> {
            update();
        });
        isLoaded = true;
        if (model != null) {
            update();
        }
    }

    public void setModel(Model model) {
        this.model = model;
        slider.setMax(model.pages.size()-1);
        if (isLoaded && model != null) {
            update();
        }
    }

    void update() {
        now = model.pages.get(page_num.get());
        tokens.setText(now.tokens);
        stacks.setText(now.stacks);
        left.setText(now.left);
        right.setText(now.right);
    }

    public void leftAction(ActionEvent actionEvent) {
        if (page_num.get() > 0)
            page_num.set(page_num.get()-1);
    }

    public void rightAction(ActionEvent actionEvent) {
        if (page_num.get() < model.pages.size()-1)
            page_num.set(page_num.get()+1);
    }

    boolean isLoaded = false;
    Model model = null;
    Page now = null;
    IntegerProperty page_num = new SimpleIntegerProperty(0);

    @FXML
    Label tokens;

    @FXML
    Label stacks;

    @FXML
    Label left;

    @FXML
    Label right;

    @FXML
    Slider slider;

    @FXML
    Button prev;

    @FXML
    Button next;

    @FXML
    Label pages;


}
