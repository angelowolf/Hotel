package Interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:26 p.m.
 */
public class in extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        String result = Action.LOGIN;
        if (actionInvocation.getInvocationContext().getSession().containsKey("user")) {
            result = actionInvocation.invoke();
        }
        return result;
    }
}//end in
