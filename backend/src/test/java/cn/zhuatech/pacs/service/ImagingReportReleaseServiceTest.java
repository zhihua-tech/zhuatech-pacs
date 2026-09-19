/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class ImagingReportReleaseServiceTest {
    private final ImagingReportReleaseService service = new ImagingReportReleaseService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void releasesControlledReport() {
        var result = service.assess(new ImagingReportReleaseService.Request("I1", true, true, true, true,
                true, true, true, true, true, true, true));
        assertThat(result.decision()).isEqualTo(ImagingReportReleaseService.Decision.RELEASE);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void reviewsDocumentationGaps() {
        var result = service.assess(new ImagingReportReleaseService.Request("I2", true, true, true, true,
                false, false, false, false, false, true, false));
        assertThat(result.actions()).hasSize(3);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksPatientSafetyFailures() {
        var result = service.assess(new ImagingReportReleaseService.Request("I3", false, false, false, false,
                true, false, false, true, true, false, true));
        assertThat(result.blockers()).hasSize(7);
    }
}
