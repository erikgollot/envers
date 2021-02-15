package org.ego.demo.envers.infrastructure.envers;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostUpdateEvent;
import org.springframework.stereotype.Component;

@Component
public class EnversCustomPostUpdate extends EnversPostUpdateEventListenerImpl {

    public EnversCustomPostUpdate() {
        super(null);
    }

    public EnversCustomPostUpdate(EnversService enversService, AuditContextService auditContextService) {
        super(enversService);
        this.auditContextService = auditContextService;
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        if (auditContextService.canAudit()) {
            super.onPostUpdate(event);
        }
    }

    private AuditContextService auditContextService;
}
