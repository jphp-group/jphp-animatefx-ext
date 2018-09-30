package org.develnext.jphp.ext.animatefx.classes;

import animatefx.animation.AnimationFX;
import animatefx.animation.Bounce;
import animatefx.animation.Flash;
import javafx.animation.Animation;
import javafx.beans.InvalidationListener;
import javafx.scene.Node;
import javafx.util.Duration;
import org.develnext.jphp.ext.animatefx.AnimateFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseObject;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;


@Reflection.Namespace(AnimateFXExtension.NS)
@Reflection.Name("AnimationFX")
public class AnimationFXWrapper extends BaseWrapper<AnimationFX> {
    public AnimationFXWrapper(Environment env, AnimationFX wrappedObject) {
        super(env, wrappedObject);
    }
    public AnimationFXWrapper(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }
    interface WrappedInterface{
        @Reflection.Setter void setResetOnFinished(boolean value);
        @Reflection.Setter void setNode(Node value);

        @Reflection.Getter("resetOnFinished") boolean isResetOnFinished();
        @Reflection.Getter Node getNode();

        void stop();
    }

    private Invoker onFinished;

    @Reflection.Signature
    public void __construct(String type, Node node, Invoker callback){
        __wrappedObject = create(type, node);
        onFinished = callback;
        getWrappedObject().getTimeline().statusProperty().addListener((obs, o, n) -> {
            if(n.equals(Animation.Status.STOPPED)){
                if(onFinished != null) {
                    onFinished.callNoThrow();
                }
            }
        });
    }
    @Reflection.Signature
    public void __construct(String type, Node node){
        __construct(type, node, null);
    }

    @Reflection.Signature
    public void setOnFinished(Invoker invoker){
        onFinished = invoker;
    }
    @Reflection.Signature
    public void start(){
        getWrappedObject().play();
    }

    @Reflection.Setter
    public void setCycleCount(int value){
        getWrappedObject().setCycleCount(value);
    }
    @Reflection.Setter
    public void setSpeed(double value){
        getWrappedObject().setSpeed(value);
    }
    @Reflection.Setter
    public void setDelay(Duration value){
        getWrappedObject().setDelay(value);
    }
    @Reflection.Setter
    public void setCycleDuration(int value){
        getWrappedObject().setCycleDuration(value);
    }

    @Reflection.Getter
    public int getCycleCount(){
        return getWrappedObject().getTimeline().getCycleCount();
    }
    @Reflection.Getter
    public double getSpeed(){
        return getWrappedObject().getTimeline().getRate();
    }
    @Reflection.Getter
    public Duration getDelay(){
        return getWrappedObject().getTimeline().getDelay();
    }
    @Reflection.Getter
    public Duration getCycleDuration(){
        return getWrappedObject().getTimeline().getCycleDuration();
    }

    @Reflection.Signature
    public static AnimationFXWrapper play(Environment env, String type, Node node){
        return play(env, type, node, null);
    }
    @Reflection.Signature
    public static AnimationFXWrapper play(Environment env, String type, Node node, Invoker callback){
        AnimationFXWrapper wrapper = new AnimationFXWrapper(env, (ClassEntity)null);
        wrapper.__construct(type, node, callback);
        wrapper.start();
        return wrapper;
    }

    private static AnimationFX create(String type, Node node){
        try{
            Class<?> clazz = Class.forName("animatefx.animation." + type);
            if(Modifier.isAbstract(clazz.getModifiers()) || !isInstance(AnimationFX.class, clazz)){
                throw new IllegalArgumentException(String.format("%s is invalid type", type));
            }
            return (AnimationFX)clazz.getConstructor(Node.class).newInstance(node);
        }
        catch(ClassNotFoundException e){
            throw new IllegalArgumentException(String.format("Animation %s not found", type));
        }
        catch(NoSuchMethodException|InvocationTargetException|IllegalAccessException|InstantiationException e){
            throw new IllegalArgumentException(String.format("Can not initialize %s", type));
        }
    }

    private static boolean isInstance(Class<?> clazz, Class<?> subClass){
        Class<?> current = subClass;

        while(!current.equals(Object.class)){
            if(current.equals(clazz)){
                return true;
            }

            current = current.getSuperclass();
        }
        return false;
    }

//    @Reflection.Signature
//    public static void bounce(Node node){
//        new Bounce(node).play();
//    }
//    @Reflection.Signature
//    public static void flash(Node node){
//        new Flash(node).play();
//    }
}