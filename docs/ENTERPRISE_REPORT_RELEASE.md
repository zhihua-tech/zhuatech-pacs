# 企业级影像报告发布治理

`POST /api/enterprise/pacs/imaging-report-release` 检查患者与医嘱匹配、影像完整性与质量、医师签署、危急发现通知、既往对比、造影剂记录、访问权限和补充报告审计，返回 `RELEASE / REVIEW / BLOCKED`。

生产环境应对接 DICOM 工作列表、电子签名、危急值闭环和 EMR 报告分发，并保留所有报告版本与访问记录。
