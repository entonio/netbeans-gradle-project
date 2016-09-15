package org.netbeans.gradle.project.properties.ui;

import org.junit.Test;
import org.netbeans.gradle.project.properties.global.CommonGlobalSettings;
import org.netbeans.gradle.project.properties.global.SelfMaintainedTasks;
import org.netbeans.gradle.project.util.NbConsumer;

public class TaskExecutionPanelTest {
    @Test
    public void testInitAndReadBack1() throws Exception {
        GlobalSettingsPanelTestUtils.testInitAndReadBack(TaskExecutionPanel.class, new NbConsumer<CommonGlobalSettings>() {
            @Override
            public void accept(CommonGlobalSettings input) {
                input.selfMaintainedTasks().setValue(SelfMaintainedTasks.TRUE);
                input.alwaysClearOutput().setValue(true);
                input.skipTests().setValue(true);
                input.skipCheck().setValue(false);
                input.replaceLfOnStdIn().setValue(false);
            }
        });
    }

    @Test
    public void testInitAndReadBack2() throws Exception {
        GlobalSettingsPanelTestUtils.testInitAndReadBack(TaskExecutionPanel.class, new NbConsumer<CommonGlobalSettings>() {
            @Override
            public void accept(CommonGlobalSettings input) {
                input.selfMaintainedTasks().setValue(SelfMaintainedTasks.FALSE);
                input.alwaysClearOutput().setValue(false);
                input.skipTests().setValue(false);
                input.skipCheck().setValue(true);
                input.replaceLfOnStdIn().setValue(true);
            }
        });
    }

    @Test
    public void testInitAndReadBack3() throws Exception {
        GlobalSettingsPanelTestUtils.testInitAndReadBack(TaskExecutionPanel.class, new NbConsumer<CommonGlobalSettings>() {
            @Override
            public void accept(CommonGlobalSettings input) {
                input.selfMaintainedTasks().setValue(SelfMaintainedTasks.MANUAL);
                input.alwaysClearOutput().setValue(true);
                input.skipTests().setValue(false);
                input.skipCheck().setValue(true);
                input.replaceLfOnStdIn().setValue(false);
            }
        });
    }
}