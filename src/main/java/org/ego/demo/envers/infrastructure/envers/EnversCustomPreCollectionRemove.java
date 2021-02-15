package org.ego.demo.envers.infrastructure.envers;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostCollectionRecreateEventListenerImpl;
import org.hibernate.envers.event.spi.EnversPreCollectionRemoveEventListenerImpl;
import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.hibernate.event.spi.PreCollectionRemoveEvent;
import org.springframework.stereotype.Component;

@Component
public class EnversCustomPreCollectionRemove extends EnversPreCollectionRemoveEventListenerImpl {

    public EnversCustomPreCollectionRemove() {
        super(null);
    }

    public EnversCustomPreCollectionRemove(EnversService enversService, AuditContextService auditContextService) {
        super(enversService);
        this.auditContextService = auditContextService;
    }

    @Override
    public void onPreRemoveCollection(PreCollectionRemoveEvent event) {
        if (auditContextService.canAudit()) {
            super.onPreRemoveCollection(event);
        }
    }

    private AuditContextService auditContextService;
}
