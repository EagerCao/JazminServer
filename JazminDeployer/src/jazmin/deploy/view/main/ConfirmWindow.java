/**
 * 
 */
package jazmin.deploy.view.main;

import java.util.function.Consumer;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author yama
 * 6 Jan, 2015
 */
@SuppressWarnings("serial")
public class ConfirmWindow extends Window{
	private Label infoLabel;
	//	
	public ConfirmWindow(Consumer<ConfirmWindow>consumer) {
        Responsive.makeResponsive(this);
        setWidth(500,Unit.PIXELS);
        setHeight(300,Unit.PIXELS);
        center();
        setCloseShortcut(KeyCode.ESCAPE, null);
        setResizable(false);
        setClosable(false);
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        setContent(content);
        //
        VerticalLayout infoContainer=new VerticalLayout();
        infoContainer.setSizeFull();
        infoContainer.setMargin(true);
        infoContainer.setSpacing(true);
        content.addComponent(infoContainer);
        content.setExpandRatio(infoContainer, 1);
        //
        infoLabel=new Label();
        infoLabel.setContentMode(ContentMode.PREFORMATTED);
        infoLabel.addStyleName(ValoTheme.LABEL_H3);
        infoLabel.setSizeUndefined();
        infoContainer.addComponent(infoLabel);
        infoContainer.setComponentAlignment(infoLabel, Alignment.MIDDLE_CENTER);
        //
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addStyleName(ValoTheme.WINDOW_BOTTOM_TOOLBAR);
        footer.setWidth(100.0f, Unit.PERCENTAGE);
        //
        Label empty=new Label();
        footer.addComponent(empty);
        footer.setExpandRatio(empty, 1);
        //
        Button ok = new Button("OK");
        ok.addStyleName(ValoTheme.BUTTON_SMALL);
        ok.addStyleName(ValoTheme.BUTTON_DANGER); 
        ok.addClickListener(e->{
        	consumer.accept(this);
        });
        ok.focus();
        footer.addComponent(ok);
        footer.setComponentAlignment(ok, Alignment.TOP_RIGHT);
        //
        Button cancel = new Button("Cancel");
        cancel.addStyleName(ValoTheme.BUTTON_SMALL);
        cancel.addClickListener(e->close());
        cancel.focus();
        footer.addComponent(cancel);
        footer.setComponentAlignment(cancel, Alignment.TOP_RIGHT);
        //
        content.addComponent(footer);
    }
	//
	public void setInfo(String info){
		infoLabel.setValue(info);
		infoLabel.setContentMode(ContentMode.PREFORMATTED);
	}
}
