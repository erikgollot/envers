package org.ego.demo.envers.infrastructure.envers;

import org.springframework.stereotype.Component;

@Component
public class AuditContext {
    private boolean canAudit = true;

    public boolean isCanAudit() {
        return canAudit;
    }

    public void setCanAudit(boolean canAudit) {
        this.canAudit = canAudit;
    }
}
