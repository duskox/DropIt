package vorkapic.com.dropit;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by dvor on 20/07/16.
 */
public class DropItApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
            Stetho.initializeWithDefaults(this);
        }
    }
}
