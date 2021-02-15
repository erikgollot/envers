package org.ego.demo.envers.infrastructure.envers;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPreCollectionRemoveEventListenerImpl;
import org.hibernate.envers.event.spi.EnversPreCollectionUpdateEventListenerImpl;
import org.hibernate.event.spi.PreCollectionRemoveEvent;
import org.hibernate.event.spi.PreCollectionUpdateEvent;
import org.springframework.stereotype.Component;

@Component
public class EnversCustomPreCollectionUpdate extends EnversPreCollectionUpdateEventListenerImpl {

    public EnversCustomPreCollectionUpdate() {
        super(null);
    }

    public EnversCustomPreCollectionUpdate(EnversService enversService, AuditContextService auditContextService) {
        super(enversService);
        this.auditContextService = auditContextService;
    }

    @Override
    public void onPreUpdateCollection(PreCollectionUpdateEvent event) {
        if (auditContextService.canAudit()) {
            super.onPreUpdateCollection(event);
        }
    }

    private AuditContextService auditContextService;
}
