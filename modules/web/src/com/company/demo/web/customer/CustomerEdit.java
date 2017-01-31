package com.company.demo.web.customer;

import com.company.demo.entity.Customer;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

public class CustomerEdit extends AbstractEditor<Customer> {

    @Inject
    private Metadata metadata;

    @Inject
    private Datasource<Customer> customerDs;

    @Inject
    private Button createNewBtn;

    @Override
    public void init(Map<String, Object> params) {
        customerDs.addItemPropertyChangeListener(e -> createNewBtn.setEnabled(true));
    }

    public void createNew() {
        getDsContext().commit();
        showNotification("Saved: " + getItem().getInstanceName(), NotificationType.TRAY);
        setItem(metadata.create(Customer.class));
    }
}