package org.ego.demo.envers.infrastructure.envers;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostCollectionRecreateEventListenerImpl;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.hibernate.event.spi.PostDeleteEvent;
import org.springframework.stereotype.Component;

@Component
public class EnversCustomPostCollectionRecreate extends EnversPostCollectionRecreateEventListenerImpl {

    public EnversCustomPostCollectionRecreate() {
        super(null);
    }

    public EnversCustomPostCollectionRecreate(EnversService enversService, AuditContextService auditContextService) {
        super(enversService);
        this.auditContextService = auditContextService;
    }

    @Override
    public void onPostRecreateCollection(PostCollectionRecreateEvent event) {
        if (auditContextService.canAudit()) {
            super.onPostRecreateCollection(event);
        }
    }

    private AuditContextService auditContextService;
}
