package Interceptor;

import Persistencia.Modelo.Usuario;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author Angelo
 * @version 1.0
 * @created 28-ene-2016 08:44:26 p.m.
 */
public class InterceptorRoot extends AbstractInterceptor {


    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        String result = Action.LOGIN;
        Usuario u = (Usuario) actionInvocation.getInvocationContext().getSession().get("user");
        if (u!= null && u.isRoot()) {
            result = actionInvocation.invoke();
        }
        return result;
    }
}//end in
