package com.example.service;

import com.example.model.TenantSupport;
import com.example.util.TenantContext;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

@Slf4j
public class CustomEmptyInterceptor extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof TenantSupport) {
            log.info("[save] Updating the entity " + id + " with util information: " + TenantContext.getCurrentTenant());
            ((TenantSupport) entity).setTenantId(TenantContext.getCurrentTenant());
        }
        return false;
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof TenantSupport) {
            log.info("[delete] Updating the entity " + id + " with util information: " + TenantContext.getCurrentTenant());
            ((TenantSupport) entity).setTenantId(TenantContext.getCurrentTenant());
        }
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
        if (entity instanceof TenantSupport) {
            log.info("[flush-dirty] Updating the entity " + id + " with util information: " + TenantContext.getCurrentTenant());
            ((TenantSupport) entity).setTenantId(TenantContext.getCurrentTenant());
        }
        return false;
    }
}
