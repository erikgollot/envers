package org.ego.demo.envers.infrastructure.envers;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostInsertEvent;
import org.springframework.stereotype.Component;

@Component
public class EnversCustomPostDelete extends EnversPostDeleteEventListenerImpl {

    public EnversCustomPostDelete() {
        super(null);
    }

    public EnversCustomPostDelete(EnversService enversService, AuditContextService auditContextService) {
        super(enversService);
        this.auditContextService = auditContextService;
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        if (auditContextService.canAudit()) {
            super.onPostDelete(event);
        }
    }

    private AuditContextService auditContextService;
}
