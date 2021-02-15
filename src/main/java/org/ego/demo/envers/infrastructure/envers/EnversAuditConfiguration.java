package org.ego.demo.envers.infrastructure.envers;


import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.*;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

@Configuration
public class EnversAuditConfiguration {
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Autowired
    AuditContextService auditContextService;

    @PostConstruct
    protected void init() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        EnversService enversService = sessionFactory.getServiceRegistry().getService(EnversService.class);

        registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(new EnversCustomPostInsert(enversService,auditContextService));
        registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(new EnversCustomPostDelete(enversService,auditContextService));
        registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(new EnversCustomPreUpdate(enversService,auditContextService));
        registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(new EnversCustomPostUpdate(enversService,auditContextService));
        registry.getEventListenerGroup(EventType.POST_COLLECTION_RECREATE).appendListener(new EnversCustomPostCollectionRecreate(enversService,auditContextService));
        registry.getEventListenerGroup(EventType.PRE_COLLECTION_REMOVE).appendListener(new EnversCustomPreCollectionRemove(enversService,auditContextService));
        registry.getEventListenerGroup(EventType.PRE_COLLECTION_UPDATE).appendListener(new EnversCustomPreCollectionUpdate(enversService,auditContextService));
    }
}
