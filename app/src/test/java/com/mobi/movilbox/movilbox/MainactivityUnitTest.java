package com.mobi.movilbox.movilbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobi.movilbox.movilbox.Activitys.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * test para Mainactivity
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MainActivity.class})
public class MainactivityUnitTest {
    MainActivity spyActivity;

    @Before
    public void setup() throws Exception {
        spyActivity = spy(new MainActivity());
    }

    /**
     * Valida que se cargue el Layout correcto
     * para la actividad.
     */
    @Test
    public void testOnCreate() {
        Method[] appCompatActivityOnCreateMethods =
                PowerMockito.methods(AppCompatActivity.class, "onCreate");
        PowerMockito.suppress(appCompatActivityOnCreateMethods);
        doNothing().when(spyActivity).setContentView(anyInt());
        doNothing().when(spyActivity).onCreateInitialization(any(Bundle.class));
        spyActivity.onCreate(any(Bundle.class));
        verify(spyActivity, times(1)).setContentView(R.layout.activity_main);
    }

}
