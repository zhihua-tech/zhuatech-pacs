/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.domain;
import org.springframework.stereotype.Component;
import java.util.List;
@Component public class DomainCatalog {
    public String systemName(){return "知华 PACS 医学影像协同平台";}
    public String sceneName(){return "预约、检查、阅片与报告质控";}
    public List<SeedItem> seedItems(){return List.of(
        new SeedItem("PACS-20260801-001","急诊 CT 报告优先队列","处理中","影像诊断组","紧急"),
        new SeedItem("PACS-20260801-002","增强检查知情材料复核","待处理","检查执行组","高"),
        new SeedItem("PACS-20260801-003","疑难病例联合阅片","已完成","专家阅片组","中"),
        new SeedItem("PACS-20260801-004","设备检查量负载调度","处理中","影像运营组","高"));}
    public List<String> recommendedActions(){return List.of("优先分配急诊与危重影像报告","平衡设备队列并预留应急容量","复核报告时效与图像质控记录");}
    public record SeedItem(String recordNo,String title,String status,String owner,String priority){}
}
