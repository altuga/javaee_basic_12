package com.kodcu;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.registry.infomodel.User;

@ApplicationScoped
public class EmptyDelegate {

    @Inject
    GlobalCounter gc;

    @Inject
    UserCounter uc;

    public GlobalCounter getGc() {
        return gc;
    }

    public UserCounter getUc() {
        return uc;
    }






}
