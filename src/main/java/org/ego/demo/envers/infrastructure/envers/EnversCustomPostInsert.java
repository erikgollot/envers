package org.ego.demo.envers.infrastructure.envers;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnversCustomPostInsert extends EnversPostInsertEventListenerImpl  {

    public EnversCustomPostInsert() {
        super(null);
    }

    public EnversCustomPostInsert(EnversService enversService,AuditContextService auditContextService) {
        super(enversService);
        this.auditContextService = auditContextService;
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        if (auditContextService.canAudit()) {
            super.onPostInsert(event);
        }
    }

    private AuditContextService auditContextService;
}
