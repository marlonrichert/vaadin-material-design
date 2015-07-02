package org.vaadin.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.vaadin.materialdesign.MaterialDesign;

import javax.servlet.annotation.WebServlet;

@Theme("md-light")
@com.vaadin.annotations.Title("Material Design for Vaadin 7 demo")
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
                addComponent(new Card() {{
                    addComponent(new PrimaryTitle() {{
                        addComponent(new Title("Title"));
                        addComponent(new Subtitle("Subtitle"));
                    }});
                    addComponent(new Actions() {{
                        addComponent(new FlatButton("Action 1"));
                        addComponent(new FlatButton("Action 2"));
                    }});
                }});
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
            addStyleName(MaterialDesign.StyleNames.ACTIONS_BLOCK);
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

    private class PrimaryTitle extends VerticalLayout {
        public PrimaryTitle() {
            addStyleName(MaterialDesign.StyleNames.PRIMARY_TITLE_BLOCK);
        }
    }

    private class Title extends Label {
        public Title(String title) {
            super(title);
            addStyleName(MaterialDesign.StyleNames.TITLE);

        }
    }

    private class Subtitle extends Label {
        public Subtitle(String subtitle) {
            super(subtitle);
            addStyleName(MaterialDesign.StyleNames.SUBTITLE);

        }
    }
}
