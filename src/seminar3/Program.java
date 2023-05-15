package seminar3;

import seminar3.Data.DataFirst;
import seminar3.MVP.ModelFirst;
import seminar3.MVP.Presenter;
import seminar3.MVP.ViewConsole;

public class Program {
    public static void main(String[] args) {
        Presenter presenter = new Presenter(new ModelFirst(), new ViewConsole(), new DataFirst());
        presenter.start();
    }
}
