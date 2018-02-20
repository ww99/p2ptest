package cn.wolfcode.p2p.base.qo;

import cn.wolfcode.p2p.base.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
* Created by 123 on 2018/2/19.
*/
@Getter@Setter
public class IpLogQueryObjecrt extends QueryObject {
        private String username;
        private int state=-1;
        private Date beginDate;
        private Date endDate;
        public Date getBegindate(){
                return beginDate;
        }
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        public void setBeginDate(Date beginDate){
                this.beginDate = beginDate;
        }
        public Date getEndDate(){
                return DateUtil.getEndDate(endDate);
        }
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        public void setEndDate(Date endDate){
                this.endDate = endDate;
        }
}
