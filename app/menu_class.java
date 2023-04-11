import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.habbit.R;

public class menu_class extends PopupMenu {
    public menu_class(Context context, View anchor) {
        super(context, anchor);
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_routine:
                //openAddRoutine(item.getActionView());
                return true;
            case R.id.setting:
//                setting(item);
                return true;
            case R.id.exit:
                //close()
                return true;
            default:
                return false;
        }
    }
}
