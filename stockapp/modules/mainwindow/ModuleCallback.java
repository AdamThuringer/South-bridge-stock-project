package stockapp.modules.mainwindow;

import java.util.Map;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import stockapp.Module;

public class ModuleCallback implements Callback<ListView<Map.Entry<String, Module>>, ListCell<Map.Entry<String, Module>>>{

    public ListCell<Map.Entry<String, Module>> call(ListView<Map.Entry<String, Module>> p) {
        final ListCell<Map.Entry<String, Module>> cell = new ListCell<Map.Entry<String, Module>>() {
            @Override
            public void updateItem(Map.Entry<String, Module> item, boolean empty) {
                super.updateItem(item, empty);
                if(item != null) {
                    setText(item.getValue().getName() + " by " + item.getValue().getAuthor());
                }
            }
        };
        return cell;
    }
    
}
