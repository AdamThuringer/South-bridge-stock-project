package stockapp.modules.nativegraph;

import java.util.Map.Entry;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class StockCallback implements Callback<ListView<Entry<String, String>>, ListCell<Entry<String, String>>>{

    public ListCell<Entry<String, String>> call(ListView<Entry<String, String>> p) {
        final ListCell<Entry<String, String>> cell = new ListCell<Entry<String, String>>() {
            @Override
            public void updateItem(Entry<String, String> item, boolean empty) {
                super.updateItem(item, empty);
                if(item != null) {
                    setText(item.getValue());
                }
            }
        };
        return cell;
    }
    
}
