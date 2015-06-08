package org.vaadin.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.vaadin.materialdesign.MaterialDesign;

import javax.servlet.annotation.WebServlet;

@Theme("material-design")
@Title("Material Design for Vaadin 7 demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(new VerticalLayout() {
            {
                addComponent(new Toolbar());
                addComponent(new Search());
                addComponent(new Card() {
                    {
                        addComponent(new Actions() {
                            {
                                addComponent(new FlatButton("Action 1"));
                                addComponent(new FlatButton("Action 2"));
                            }
                        });
                    }
                });
            }
        });
    }

    private class Search extends HorizontalLayout {
        public Search() {
            addStyleName(MaterialDesign.SEARCH);
            addComponent(new Icon("search"));
            addComponent(new TextField());
        }
    }

    private class Icon extends Label {
        public Icon(String content) {
            super(content);
            addStyleName(MaterialDesign.ICON);
        }
    }

    private class Toolbar extends HorizontalLayout {
        public Toolbar() {
            addStyleName(MaterialDesign.TOOLBAR);
        }
    }

    private class Card extends VerticalLayout {
        public Card() {
            addStyleName(MaterialDesign.CARD);
            setSizeUndefined();
        }
    }

    private class Actions extends HorizontalLayout {
        public Actions() {
            addStyleName(MaterialDesign.ACTIONS);
        }
    }

    private class FlatButton extends NativeButton {
        public FlatButton(String caption) {
            super(caption);
            addStyleName(MaterialDesign.FLAT_BUTTON);
        }
    }
}
