package nccs.onlinestore;

import nccs.onlinestore.view.ClientView;

public class MainApp {

    public static void main(String[] args) throws Exception {

        ClientView clientView = new ClientView();
        if (clientView.logIn()) {
            clientView.mainPage();
        }

    }

}
