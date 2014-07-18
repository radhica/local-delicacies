package support.Assert;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import org.robolectric.Robolectric;

/**
 * Created by mlandaverde on 7/14/14.
 */
public class FragmentUtil {
    public static void startFragment( Fragment fragment )
    {
        Activity activity = createActivity();

        FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.beginTransaction()
                .add( fragment, null )
                .commit();
    }

    private static Activity createActivity() {
        return Robolectric.buildActivity(Activity.class)
                .create()
                .start()
                .resume()
                .get();
    }
}
