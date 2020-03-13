package com.bugbean.studydemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {

        DAOLogHandler daoLogHandler = new DAOLogHandler(new UserDAO());
        AbstractUserDAO proxyInstance = (AbstractUserDAO) Proxy.newProxyInstance(AbstractUserDAO.class.getClassLoader(), new Class[]{AbstractUserDAO.class}, daoLogHandler);
        proxyInstance.findByUserId("666");

        daoLogHandler = new DAOLogHandler(new DocumentDAO());
        AbstractDocumentDAO proxy = (AbstractDocumentDAO) Proxy.newProxyInstance(AbstractDocumentDAO.class.getClassLoader(), new Class[]{AbstractDocumentDAO.class}, daoLogHandler);
        proxy.deleteByDocumentId("888");
    }
}

interface AbstractUserDAO {
    Boolean findByUserId(String userId);
}

interface AbstractDocumentDAO {
    Boolean deleteByDocumentId(String documentId);
}

class UserDAO implements AbstractUserDAO {

    @Override
    public Boolean findByUserId(String userId) {
        System.out.println("查询到id为" + userId + "的用户");
        return true;
    }
}

class DocumentDAO implements AbstractDocumentDAO {

    @Override
    public Boolean deleteByDocumentId(String documentId) {
        System.out.println("删除了id为" + documentId + "的文档");
        return true;
    }
}

class DAOLogHandler implements InvocationHandler {

    private Object object;

    public DAOLogHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        method.invoke(object, args);
        afterInvoke();
        return null;
    }

    private void afterInvoke() {
        System.out.println("调用后");
    }

    private void beforeInvoke() {
        System.out.println("调用前");

    }
}
