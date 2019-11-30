package com.cpy.onsiteinform.common;

/**
 * Created with Intellij Idea
 * Author: Qin
 * Date: 2015/9/7
 */
public class UserContext<T> {

    private static class UserContextHolder {
        private static final UserContext INSTANCE = new UserContext();
    }

    private ThreadLocal<T> traceThreadLocal = new ThreadLocal<>();

    private UserContext(){
    }

    public static <T> UserContext<T> getContext(){
        return UserContextHolder.INSTANCE;
    }

    public T getCurrentUser(){
        T user = traceThreadLocal.get();
        return user;
    }

    public void setCurrentUser(T user){
        this.traceThreadLocal.set(user);
    }


}
