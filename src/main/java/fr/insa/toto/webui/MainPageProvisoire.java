package fr.insa.toto.webui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import fr.insa.beuvron.utils.database.ConnectionPool;
import fr.insa.beuvron.vaadin.utils.dataGrid.ResultSetGrid;
import fr.insa.toto.model.GestionSchema;
import fr.insa.toto.model.GestionUtilisateursDirect;
import java.sql.SQLException;

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

        try (var pst = ConnectionPool.getConnection().prepareStatement(
                "select * from utilisateur")) {
            this.add(new ResultSetGrid(pst));
        } catch (SQLException ex) {
            Notification.show("problem : " + ex.getLocalizedMessage());
        }

        Button raz = new Button("RAZ BdD2");
        raz.addClickListener(event -> {
        try (var con = ConnectionPool.getConnection()) {
            GestionSchema.razBdD(con);
            GestionUtilisateursDirect.creeUtilisateur(con, "thth", "p1");
            UI.getCurrent().getPage().reload();
        } catch (SQLException ex) {
            Notification.show("problem : " + ex.getLocalizedMessage());
        }
        });
        // Add the button to the layout
        this.add(new H3("pour init BdD"));
        this.add(raz);

    }

}
