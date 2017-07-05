package org.netbeans.gradle.project.properties;

import javax.swing.JComponent;
import org.jtrim.utils.ExceptionHelper;
import org.netbeans.gradle.project.properties.ui.ProfileBasedPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.openide.util.Lookup;

public final class ProfileBasedCustomizer implements ProjectCustomizer.CompositeCategoryProvider {
    private final String categoryName;
    private final String displayName;
    private final PanelFactory panelFactory;

    public ProfileBasedCustomizer(String categoryName, String displayName, final ProfileBasedPanel panel) {
        this(categoryName, displayName, () -> panel);

        ExceptionHelper.checkNotNullArgument(panel, "panel");
    }

    public ProfileBasedCustomizer(String categoryName, String displayName, PanelFactory panelFactory) {
        ExceptionHelper.checkNotNullArgument(categoryName, "categoryName");
        ExceptionHelper.checkNotNullArgument(displayName, "displayName");
        ExceptionHelper.checkNotNullArgument(panelFactory, "panelFactory");

        this.categoryName = categoryName;
        this.displayName = displayName;
        this.panelFactory = panelFactory;
    }

    @Override
    public ProjectCustomizer.Category createCategory(Lookup context) {
        return ProjectCustomizer.Category.create(categoryName, displayName, null);
    }

    @Override
    public JComponent createComponent(ProjectCustomizer.Category category, Lookup context) {
        ProfileBasedPanel panel = panelFactory.createPanel();
        category.setOkButtonListener(e -> panel.saveProperties());
        return panel;
    }

    public static interface PanelFactory {
        public ProfileBasedPanel createPanel();
    }
}
