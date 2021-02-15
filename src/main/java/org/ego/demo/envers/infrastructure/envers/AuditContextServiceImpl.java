package org.ego.demo.envers.infrastructure.envers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditContextServiceImpl implements AuditContextService {
    private AuditContext context;

    @Autowired
    public AuditContextServiceImpl(AuditContext context) {
        this.context = context;
    }

    @Override
    public void setCanAudit(boolean value) {
        synchronized (context) {
            this.context.setCanAudit(value);
        }
    }

    @Override
    public boolean canAudit() {
        return this.context.isCanAudit();
    }


}
