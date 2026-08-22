/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.pacs.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
@Service public class ImagingWorklistPriorityService {
 public Result prioritize(Request r){int score=0;List<String> reasons=new ArrayList<>();if(r.emergency()){score+=60;reasons.add("急诊检查");}if(r.criticalFinding()){score+=60;reasons.add("存在危急影像发现");}if(r.contrastReaction()){score+=70;reasons.add("发生造影剂不良反应");}if(r.inpatient()){score+=10;}int remaining=r.slaMinutes()-r.waitingMinutes();if(remaining<=0){score+=40;reasons.add("已超过报告 SLA");}else if(remaining<=15){score+=25;reasons.add("即将超过报告 SLA");}String priority=score>=80?"STAT":score>=40?"URGENT":"ROUTINE";if(reasons.isEmpty())reasons.add("按常规检查时间排序");return new Result(Math.min(score,100),priority,remaining<=0,reasons);}
 public record Request(@NotBlank String studyId,@NotBlank String modality,@Min(0) int waitingMinutes,@Min(1) int slaMinutes,@NotNull Boolean emergency,@NotNull Boolean criticalFinding,@NotNull Boolean contrastReaction,@NotNull Boolean inpatient){}
 public record Result(int priorityScore,String priority,boolean slaBreached,List<String> reasons){}
}
