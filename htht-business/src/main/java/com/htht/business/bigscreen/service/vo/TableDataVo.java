package com.htht.business.bigscreen.service.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.htht.business.bigscreen.domain.TableRow;
import lombok.Data;

@JsonIgnoreProperties(value = "tableColValList")
@Data
public class TableDataVo extends TableRow {


}
