package org.xkqr.testing;

import android.inputmethodservice.InputMethodService;
import android.view.View;

public class Keyboard extends InputMethodService {
    @Override
    public View onCreateInputView() {
        return new KeyboardView(this);
    }

}
