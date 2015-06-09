package org.vaadin.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.vaadin.materialdesign.MaterialDesign;

import javax.servlet.annotation.WebServlet;

@Theme("md-light")
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
                addComponent(new AppBar());
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
            setId(MaterialDesign.Ids.SEARCH);
            addComponent(new Icon("search"));
            addComponent(new SearchTextField());
        }
    }

    private class SearchTextField extends TextField {
        public SearchTextField() {
            addStyleName(MaterialDesign.StyleNames.SEARCH_TEXT_FIELD);
            setInputPrompt("Search");
        }
    }

    private class Icon extends Label {
        public Icon(String content) {
            super(content);
            addStyleName(MaterialDesign.StyleNames.ICON);
        }
    }

    private class AppBar extends HorizontalLayout {
        public AppBar() {
            setId(MaterialDesign.Ids.APP_BAR);
        }
    }

    private class Card extends VerticalLayout {
        public Card() {
            addStyleName(MaterialDesign.StyleNames.CARD);
            setSizeUndefined();
        }
    }

    private class Actions extends HorizontalLayout {
        public Actions() {
            addStyleName(MaterialDesign.StyleNames.ACTIONS);
            setMargin(true);
            setSpacing(true);
        }
    }

    private class FlatButton extends NativeButton {
        public FlatButton(String caption) {
            super(caption);
            addStyleName(MaterialDesign.StyleNames.FLAT);
        }
    }
}
