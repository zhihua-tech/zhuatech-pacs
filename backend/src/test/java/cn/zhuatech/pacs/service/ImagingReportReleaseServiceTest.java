/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ImagingReportReleaseServiceTest {
    private final ImagingReportReleaseService service = new ImagingReportReleaseService();
    @Test void releasesControlledReport() {
        var result = service.assess(new ImagingReportReleaseService.Request("I1", true, true, true, true,
                true, true, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(ImagingReportReleaseService.Decision.RELEASE);
    }
    @Test void reviewsDocumentationGaps() {
        var result = service.assess(new ImagingReportReleaseService.Request("I2", true, true, true, true,
                false, false, false, false, false, true, false));
        assertThat(result.actions()).hasSize(3);
    }
    @Test void blocksPatientSafetyFailures() {
        var result = service.assess(new ImagingReportReleaseService.Request("I3", false, false, false, false,
                true, false, false, true, true, false, true));
        assertThat(result.blockers()).hasSize(7);
    }
}
