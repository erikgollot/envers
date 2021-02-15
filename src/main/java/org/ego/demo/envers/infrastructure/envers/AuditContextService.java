package org.ego.demo.envers.infrastructure.envers;

public interface AuditContextService {
    void setCanAudit(boolean value);
    boolean canAudit();
}
