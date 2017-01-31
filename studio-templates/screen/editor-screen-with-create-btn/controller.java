<%
if (copyright) {
    println '/*'
    println " * ${copyright.replace('\n', '\n * ')}"
    println ' */'
} else {
    print ""
}
%>package ${packageName};

import com.haulmont.cuba.gui.components.AbstractEditor;
import ${entity.fqn};
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.Map;

<%if (classComment) {%>
${classComment}<%}%>
public class ${controllerName} extends AbstractEditor<${entity.className}> {

    @Inject
    private Metadata metadata;

    @Inject
    private Datasource<${entity.className}> ${entity.uncapitalizedClassName}Ds;

    @Inject
    private Button createNewBtn;

    @Override
    public void init(Map<String, Object> params) {
        ${entity.uncapitalizedClassName}Ds.addItemPropertyChangeListener(e -> createNewBtn.setEnabled(true));
    }

    public void createNew() {
        getDsContext().commit();
        showNotification("Saved: " + getItem().getInstanceName(), NotificationType.TRAY);
        setItem(metadata.create(${entity.className}.class));
    }

}