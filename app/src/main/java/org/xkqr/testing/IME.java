package org.xkqr.testing;

import android.inputmethodservice.InputMethodService;
import android.view.View;

public class IME extends InputMethodService {
    @Override
    public View onCreateInputView() {
        return new IMEView(this);
    }

}
