package org.ego.demo.envers.infrastructure.envers;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPreUpdateEventListenerImpl;
import org.hibernate.event.spi.PreUpdateEvent;
import org.springframework.stereotype.Component;

@Component
public class EnversCustomPreUpdate extends EnversPreUpdateEventListenerImpl  {

    public EnversCustomPreUpdate() {
        super(null);
    }

    public EnversCustomPreUpdate(EnversService enversService, AuditContextService auditContextService) {
        super(enversService);
        this.auditContextService = auditContextService;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        if (auditContextService.canAudit()) {
            return super.onPreUpdate(event);
        } else {
            return false;
        }
    }

    private AuditContextService auditContextService;
}
