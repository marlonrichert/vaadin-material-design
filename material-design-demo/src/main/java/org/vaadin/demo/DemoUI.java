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
                addComponent(new Toolbar());
                addComponent(new Search());
                addComponent(new Card() {
                    {
                        addComponent(new Actions() {
                            {
                                addComponent(new NativeButton("Action 1") {{
                                    addStyleName(MaterialDesign.StyleNames.FLAT_BUTTON);
                                }});
                                addComponent(new Button("Action 2") {{
                                    addStyleName(MaterialDesign.StyleNames.FLAT_BUTTON);
                                }});
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
            addStyleName("md-search-text-field");
            setInputPrompt("Search");
        }
    }

    private class Icon extends Label {
        public Icon(String content) {
            super(content);
            addStyleName(MaterialDesign.StyleNames.ICON);
        }
    }

    private class Toolbar extends HorizontalLayout {
        public Toolbar() {
            addStyleName(MaterialDesign.StyleNames.TOOLBAR);
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
        }
    }
}
