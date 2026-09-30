package fr.insa.toto.webui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "")
public class MainPageProvisoire extends VerticalLayout {

    public MainPageProvisoire() {
        this.add(new H2("Teste si le projet est bien configuré pour vaadin !"));
        // Create a button
        Button button = new Button("Click Me");

        // Add a click listener to the button
        button.addClickListener(event -> {
            // Show a notification when the button is clicked
            Notification.show("COUCOU!");
        });

        // Add the button to the layout
        this.add(button);
    }
    
}
