package org.develnext.jphp.ext.animatefx;

import animatefx.animation.AnimationFX;
import org.develnext.jphp.ext.animatefx.classes.AnimationFXWrapper;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class AnimateFXExtension extends Extension {
    public static final String NS = "php\\gui\\animatefx";
    
    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }
    
    @Override
    public void onRegister(CompileScope scope) {
        registerWrapperClass(scope, AnimationFX.class, AnimationFXWrapper.class);
    }
}