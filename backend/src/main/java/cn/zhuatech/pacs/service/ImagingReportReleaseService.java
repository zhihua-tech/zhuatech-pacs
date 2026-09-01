/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImagingReportReleaseService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.patientAndOrderMatched()) blockers.add("患者、申请单与影像检查不匹配");
        if (!request.imagesComplete()) blockers.add("影像序列不完整");
        if (!request.imageQualityPassed()) blockers.add("影像质量控制未通过");
        if (!request.radiologistSigned()) blockers.add("报告未由授权影像医师签署");
        if (request.criticalFinding() && !request.criticalFindingNotified()) blockers.add("危急影像发现未通知");
        if (request.criticalFinding() && !request.notificationAcknowledged()) blockers.add("危急影像通知未确认接收");
        if (!request.distributionAclApplied()) blockers.add("报告分发权限未应用");
        if (!blockers.isEmpty()) {
            actions.add("阻断报告发布并关闭患者安全和影像质量缺口");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.priorStudiesCompared() || !request.contrastEventDocumented()
                || !request.addendumLinkReady()) {
            if (!request.priorStudiesCompared()) actions.add("补充既往影像对比说明");
            if (!request.contrastEventDocumented()) actions.add("确认造影剂使用或不良事件记录");
            if (!request.addendumLinkReady()) actions.add("启用报告补充与原报告关联审计");
            return new Assessment(Decision.REVIEW, blockers, actions);
        }
        actions.add("发布报告并归档签名、危急值通知和版本记录");
        return new Assessment(Decision.RELEASE, blockers, actions);
    }

    public record Request(@NotBlank String examId, boolean patientAndOrderMatched, boolean imagesComplete,
                          boolean imageQualityPassed, boolean radiologistSigned, boolean criticalFinding,
                          boolean criticalFindingNotified, boolean notificationAcknowledged,
                          boolean priorStudiesCompared, boolean contrastEventDocumented,
                          boolean distributionAclApplied, boolean addendumLinkReady) {}
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    public enum Decision { RELEASE, REVIEW, BLOCKED }
}
